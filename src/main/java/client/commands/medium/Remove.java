package client.commands.medium;


import client.basic.Command;
import dto.transmision.Shipment;

import java.util.List;

import static client.brain.ClientCode.this_client;


public class Remove extends Command {


    @Override
    public Shipment realization(List dop_info, String index, Integer mode) {
        if (mode == 1) {
            try {
                Integer.parseInt(index);
                return new Shipment("remove_by_id", index, 4,this_client);
            } catch (NumberFormatException e) {
                return new Shipment("Индекс должен быть числом", 0,this_client);
            }
        } else {
            return new Shipment("remove_by_id", index, 4,this_client);
        }
    }
}