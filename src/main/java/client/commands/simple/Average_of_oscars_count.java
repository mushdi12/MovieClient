package client.commands.simple;

import client.basic.Command;
import dto.transmision.Shipment;

import java.util.List;

import static client.brain.ClientCode.this_client;


public class Average_of_oscars_count extends Command {


    @Override
    public Shipment realization(List dop_info, String index, Integer mode) {
        return new Shipment("average_of_oscars_count", 3,this_client);
    }
}
