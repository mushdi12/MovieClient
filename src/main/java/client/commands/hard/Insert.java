package client.commands.hard;


import client.basic.Command;
import client.validation.ValidatorObject;
import client.validation.ValidatorObjectFileMode;
import dto.classes.Movie;
import dto.transmision.Shipment;

import java.util.List;

import static client.brain.ClientCode.this_client;

public class Insert extends Command {

    @Override
    public Shipment realization(List dop_info, String index, Integer mode) {
        Movie movie;
        if (mode == 1) {
            ValidatorObject validatorObject = new ValidatorObject();
            movie = validatorObject.isValid(Integer.parseInt(index));
            return new Shipment("insert_at", movie, 5,this_client);
        } else {
            ValidatorObjectFileMode validatorObjectFileMode = new ValidatorObjectFileMode();
            movie = validatorObjectFileMode.addElementModeFile(Integer.parseInt(index), dop_info);
            if (movie != null) {
                return new Shipment("insert_at", movie, 5,this_client);
            } else {
                return new Shipment("Команда insert_at не выполнена!", movie, 0,this_client);
            }

        }

    }
}
