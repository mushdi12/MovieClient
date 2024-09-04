package client.basic;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
@Getter
@Setter
public class Messages {
    Integer mode;
    String message;
    LinkedList list;

    public Messages(String message, Integer mode) {
        this.message = message;
        this.mode = mode;
    }

    public Messages(LinkedList list, Integer mode) {
        this.list = list;
        this.mode = mode;
    }
}
