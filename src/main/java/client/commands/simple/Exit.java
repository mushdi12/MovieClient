package client.commands.simple;

import client.basic.Command;
import dto.transmision.Shipment;

import java.io.IOException;
import java.util.List;

import static client.brain.ClientCode.this_client;

public class Exit extends Command {
    @Override
    public Shipment realization(List dop_info, String index, Integer mode) throws IOException {
        return new Shipment("exit",0,this_client);
    }
}
