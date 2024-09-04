package client.commands.medium;

import client.basic.Command;
import dto.transmision.Shipment;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static client.basic.FilterCommandRegistry.fillFilterCommands;
import static client.basic.FilterCommandRegistry.getFilterCommand;
import static client.brain.ClientCode.this_client;
import static dto.classes.Movie.getFields;

public class Filter extends Command {
    @Override
    public Shipment realization(List dop_info, String index, Integer mode) throws IOException {
        fillFilterCommands();
        String s  = " ";
        List<String> movieFields = getFields();
        System.out.println("Введите поле для сортировки из предложенных:\n" + movieFields);

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        while (!movieFields.contains(str)) {
            System.out.println("Некорректное поле. Пожалуйста, введите одно из предложенных полей:\n" + movieFields);
            str = scanner.nextLine();
        }
        getFilterCommand(str).filterRealization();




        return new Shipment("filter", s, 4,this_client);
    }
}
