package dto.transmision;

import lombok.Getter;

import java.io.Serializable;
import java.util.LinkedList;

@Getter
public class Reception implements Serializable {

    String message;
    LinkedList linkedList;
    Integer mode;

    public Reception(String message,Integer mode) {
        this.message = message;
        this.mode = mode;
    }
    public Reception(LinkedList linkedList,Integer mode) {
        this.linkedList = linkedList;
        this.mode = mode;
    }

    @Override
    public String toString() {
        return message;
    }
}
