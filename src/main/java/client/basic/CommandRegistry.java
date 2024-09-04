package client.basic;


import client.commands.hard.Add;
import client.commands.hard.Insert;
import client.commands.hard.Update;
import client.commands.medium.Filter;
import client.commands.medium.Remove;
import client.commands.medium.RemoveByOscar;
import client.commands.simple.*;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    public static Map<String, Command> listOfSimpleCommands = new HashMap<>();

    public static Map<String, Command> listOfDoubleCommands = new HashMap<>();
    public static Map<String, FilterCommands> listOfFilterCommands = new HashMap<>();


    public void fill() {
        putSimpleCommand("help", new Help());
        putSimpleCommand("info", new Info());
        putSimpleCommand("show", new Show());
        putSimpleCommand("average_of_oscars_count", new Average_of_oscars_count());
        putSimpleCommand("clear", new Clear());
        putSimpleCommand("print_field_ascending_genre", new Genre());
        putSimpleCommand("reorder", new Reorder());
        putSimpleCommand("filter", new Filter());
        putSimpleCommand("add", new Add());
        putSimpleCommand("exit", new Exit());
        //---------------------------------------
        putDoubleCommand("update", new Update());
        putDoubleCommand("insert_at", new Insert());
        putDoubleCommand("execute_script", new ExecuteScript());
        putDoubleCommand("remove_by_id", new Remove());
        putDoubleCommand("remove_any_by_oscars_count", new RemoveByOscar());

    }

    public void putSimpleCommand(String name, Command command) {
        listOfSimpleCommands.put(name, command);
    }

    public void putDoubleCommand(String name, Command command) {
        listOfDoubleCommands.put(name, command);
    }

    public Command getSimpleCommand(String name) {
        return listOfSimpleCommands.get(name);
    }

    public Command getDoubleCommand(String name) {
        return listOfDoubleCommands.get(name);
    }
}
