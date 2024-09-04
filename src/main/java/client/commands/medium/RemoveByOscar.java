package client.commands.medium;


import client.basic.Command;
import dto.transmision.Shipment;

import java.util.List;

import static client.brain.ClientCode.this_client;

public class RemoveByOscar extends Command {


    @Override
    public Shipment realization(List dop_info, String oscar, Integer mode) {
        if (mode == 1) {
            try {
                Integer.parseInt(oscar);
                return new Shipment("remove_any_by_oscars_count", oscar, 4,this_client);
            } catch (NumberFormatException e) {
                return new Shipment("Индекс должен быть числом", 0,this_client);
            }
        } else {
            return new Shipment("remove_any_by_oscars_count", oscar, 4,this_client);
        }
    }

}
