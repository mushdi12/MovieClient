package client.basic;


import client.commands.filters.*;

import java.util.HashMap;
import java.util.Map;

public class FilterCommandRegistry {

    public static Map<String, FilterCommands> listOfFilterCommands = new HashMap<>();


    public static void fillFilterCommands() {
        putFilterCommand("id",new IdFilter());
        putFilterCommand("name",new NameFilter());
        putFilterCommand("creationDate",new CreationDateFilter());
        putFilterCommand("oscarsCount",new OscarsFilter());
        putFilterCommand("genre", new GenreFilter());
        //-------------------------------------------------
        putFilterCommand("director's name", new DirectorsNameFilter());
        putFilterCommand("director's birthday", new DirectorsBirthdayFilter());
        putFilterCommand("director's eyeColor", new DirectorsEyesColorFilter());
        putFilterCommand("director's hairColor", new DirectorsHairColorFilter());
        putFilterCommand("director's nationality", new DirectorsHationalityFilter());

    }


    public static void putFilterCommand(String name, FilterCommands command) {
        listOfFilterCommands.put(name, command);
    }

    public static FilterCommands getFilterCommand(String name) {
        return listOfFilterCommands.get(name);
    }

}
