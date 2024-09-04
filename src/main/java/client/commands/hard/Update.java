package client.commands.hard;


import client.basic.Command;
import client.validation.ValidatorObject;
import client.validation.ValidatorObjectFileMode;
import dto.classes.Movie;
import dto.transmision.Shipment;

import java.util.List;

import static client.brain.ClientCode.this_client;


public class Update extends Command {

    @Override
    public Shipment realization(List dop_info, String index, Integer mode) {
        Movie movie;
        if (mode == 1) {
            movie = new ValidatorObject().isValid(Integer.parseInt(index));
            return new Shipment("update", movie, 5,this_client);
        } else {
            movie = new ValidatorObjectFileMode().addElementModeFile(Integer.parseInt(index), dop_info);
            if (movie != null) {
                return new Shipment("update", movie, 5,this_client);
            } else {
                return new Shipment("Команда update не выполнена", movie, 0,this_client);
            }
        }
    }

}
