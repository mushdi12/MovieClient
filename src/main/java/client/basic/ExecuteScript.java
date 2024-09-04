package client.basic;


import dto.transmision.Shipment;

import java.util.ArrayList;
import java.util.List;

import static client.brain.ClientCode.this_client;


public class ExecuteScript extends Command {
    // коллекция названий файла
    public static final List<String> listWithCountName = new ArrayList<>();

    @Override
    public Shipment realization(List dop_info, String name_file, Integer mode) {
        if (!listWithCountName.contains(name_file)) {
            listWithCountName.add(name_file);
            new ConsoleForScript().startConsoleFileMode(name_file);
            return new Shipment("Скрипт исполнен!", 6,this_client);
        } else {
            listWithCountName.clear();
            return new Shipment("вы пытаетесь сделать рекурсию у вас файл <" + name_file + "> повторяется дважды, что приводит к рекурсии!\nИсправьте это!", 0,this_client);

        }
    }
}