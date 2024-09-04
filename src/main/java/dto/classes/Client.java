package dto.classes;

import lombok.Getter;

import java.io.Serializable;
@Getter
public class Client  implements Serializable {

    public String login;
    public String password;

    public Client(String login, String password) {
        this.login = login;
        this.password = password;

    }
    public Client(String login) {
        this.login = login;

    }

    @Override
    public String toString() {
        return login ;
    }
}
