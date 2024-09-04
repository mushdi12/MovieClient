package client.commands.hard;


import client.basic.Command;
import client.validation.ValidatorObject;
import client.validation.ValidatorObjectFileMode;
import dto.classes.Movie;
import dto.transmision.Shipment;

import java.util.List;

import static client.brain.ClientCode.this_client;


public class Add extends Command {

    @Override
    public Shipment realization(List dop_info, String index, Integer mode) {
        Movie movie;
        if (mode == 1) {
            ValidatorObject validatorObject = new ValidatorObject();
            movie = validatorObject.isValid(0);
        } else {
            ValidatorObjectFileMode validatorObjectFileMode = new ValidatorObjectFileMode();
            movie = validatorObjectFileMode.addElementModeFile(0, dop_info);
            if (movie != null) {
                return new Shipment("add", movie, 5,this_client);
            } else {
                return new Shipment("Команда add не выполнена!", movie, 5,this_client);
            }
        }
        return new Shipment("add", movie, 5,this_client);
    }


}

