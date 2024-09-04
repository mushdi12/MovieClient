package client.basic;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static client.basic.CommandRegistry.listOfSimpleCommands;
import static client.brain.Controller.empty_list;
import static client.brain.Controller.listOfShip;


public class ConsoleForScript {

    public String index;
    String filePath;


    public void startConsoleFileMode(String envVariableName) {
        System.out.println(envVariableName);

        List<String> dop_info = new ArrayList<>();
        List<String> listOfCommand = new ArrayList<>();
        List<Integer> listOfIndex = new ArrayList<>();
        CommandRegistry console_1 = new CommandRegistry();

        try {
            filePath = System.getenv(envVariableName);
            if (filePath == null) {
                throw new NullPointerException("Переменная окружения " + envVariableName + " имеет значение null.");
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)
            );
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                listOfCommand.add(line); // Добавляем считанную команду в список
            }

            String[] lines = listOfCommand.toArray(new String[0]);

            for (int i = 0; i < lines.length; i++) {
                String test_line = lines[i];
                String[] command_name = test_line.split(" ");
                command_name[0] = command_name[0].toLowerCase().trim();
                if (((command_name[0].equals("add")) || (command_name[0].equals("insert_at")) || (command_name[0].equals("update"))) & (lines.length >= i + 19)) {
                    List<String> lines2 = new ArrayList<>();
                    for (int j = i + 1; j < i + 20; ++j) {
                        lines2.add(lines[j]);
                        listOfIndex.add(j);
                    }
                    for (String l : lines2) {
                        dop_info.add(l);
                    }
                    if (command_name[0].equals("add")) {
                        listOfShip.add(console_1.getSimpleCommand(command_name[0]).realization(dop_info, index, 2));
                        dop_info.clear();
                    } else {
                        listOfShip.add(console_1.getDoubleCommand(command_name[0]).realization(dop_info, command_name[1], 2));
                    }
                } else if (((command_name[0].equals("remove_by_id")) || (command_name[0].equals("remove_any_by_oscars_count")) || (command_name[0].equals("execute_script"))) & (command_name.length == 2)) {
                    if (command_name[0].equals("execute_script")) {
                        listOfShip.add(console_1.getDoubleCommand(command_name[0]).realization(dop_info, command_name[1], 2));
                    } else {
                        listOfShip.add(console_1.getDoubleCommand(command_name[0]).realization(empty_list, index, 2));
                    }
                } else if ((listOfSimpleCommands.containsKey(command_name[0])) & (!command_name[0].toLowerCase().equals("add"))) {
                    listOfShip.add(console_1.getSimpleCommand(command_name[0]).realization(empty_list, index, 2));
                }
            }
        } catch (IOException e) {
            System.out.printf("s");
        }

    }
}


