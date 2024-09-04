package client.basic;


import dto.transmision.Shipment;

import java.io.IOException;
import java.util.List;

public interface VoidForCommands {
    Shipment realization(List dop_info, String index, Integer mode) throws IOException;

}
