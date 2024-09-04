package client.brain;


import client.basic.CommandRegistry;
import dto.transmision.Shipment;

import java.io.IOException;
import java.util.*;

import static client.basic.CommandRegistry.listOfDoubleCommands;
import static client.basic.CommandRegistry.listOfSimpleCommands;
import static client.brain.ClientCode.this_client;

public class Controller {
    public static List<String[]> empty_list = new LinkedList<>();
    public static List<Shipment> listOfShip = new ArrayList<>();


    public Shipment start() throws IOException {

        new CommandRegistry().fill();

        while (true) {

            System.out.println("Введите команду:");

            LinkedList<String> command_parts = new LinkedList<>(controller());

            if (command_parts.isEmpty()) {
                return new Shipment("Команды нет.", 0,this_client);
            } else if (checkSimpleCommand(command_parts.getFirst().toLowerCase())) {
                if (command_parts.size() == 1) {
                    return activationForSimpleCommand(command_parts.getFirst().toLowerCase());
                } else {
                    return new Shipment("Команда введена некорректно.", 0,this_client);
                }
            } else if (checkDoubleCommand(command_parts.getFirst().toLowerCase())) {
                if (command_parts.size() == 2) {
                    return activationForHardCommand(command_parts.getFirst().toLowerCase(), command_parts.getLast());
                } else {
                    return new Shipment("Команда введена некорректно.", 0,this_client);
                }
            } else {
                return new Shipment("Команды не существует.", 0,this_client);
            }
        }
    }

    private boolean checkSimpleCommand(String input) {
        return listOfSimpleCommands.containsKey(input);
    }

    private boolean checkDoubleCommand(String input) {
        return listOfDoubleCommands.containsKey(input);
    }

    public static Shipment activationForSimpleCommand(String command) throws IOException {
        return new CommandRegistry().getSimpleCommand(command).realization(empty_list, command, 1);
    }

    private Shipment activationForHardCommand(String command, String index) throws IOException {
        if (command.equals("execute_script")) {
            return (new CommandRegistry().getDoubleCommand(command.toLowerCase()).realization(empty_list, index, 1));
        } else {
            try {
                if (Integer.parseInt(index) > 0) {
                    return (new CommandRegistry().getDoubleCommand(command.toLowerCase()).realization(empty_list, index, 1));
                } else {
                    return new Shipment("Индекс введен неверно.", 0,this_client);
                }
            } catch (IllegalArgumentException e) {
                return new Shipment("Индекс введен неверно.", 0,this_client);
            }
        }
    }

    private List<String> controller() {
        String input = null;
        try {
            input = new Scanner(System.in).nextLine().trim();
        } catch (NoSuchElementException e) {
            System.exit(0);
        }
        String[] line = input.split(" ");
        List<String> filter = Arrays.stream(line)
                .filter(Objects::nonNull)
                .filter(s -> !s.isEmpty())
                .toList();
        return filter;
    }
}
