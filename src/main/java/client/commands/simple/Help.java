package client.commands.simple;


import client.basic.Command;
import dto.transmision.Shipment;

import java.util.List;

import static client.brain.ClientCode.this_client;

public class Help extends Command {
    @Override
    public Shipment realization(List dop_info, String index, Integer mode) {
        return new Shipment("help", 3,this_client);
    }


}
