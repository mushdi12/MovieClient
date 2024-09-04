package dto.transmision;


import dto.classes.Client;
import dto.classes.Movie;
import lombok.Getter;

import java.io.Serializable;

// Отправка
@Getter
public class Shipment implements Serializable {
    String command;
    Movie movies;
    Integer mode;
    String parameter;
    Client client;


    @Override
    public String toString() {
        return "{" +
                "commands='" + command + '\'' +
                ", movies=" +
                ", indexOrOscarCount ='" + parameter + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }


    public Shipment(String command, int mode,Client client) {
        this.command = command;
        this.mode = mode;
        this.client = client;
    }

    public Shipment(Client client,int mode) {
       this.client = client;
        this.mode = mode;
    }

    public Shipment(String command, Movie movies, int mode, Client client) {
        this.command = command;
        this.movies = movies;
        this.mode = mode;
        this.client = client;

    }
    public Shipment(String command, String parameter, int mode, Client client) {
        this.command = command;
        this.parameter = parameter;
        this.mode = mode;
        this.client = client;
    }


}