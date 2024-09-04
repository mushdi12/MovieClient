package frontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import client.basic.Messages;
import dto.classes.Client;
import dto.transmision.Shipment;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static client.brain.ClientCode.*;
import static client.brain.ClientCode.channel;
import static client.validation.HashPassword.gethashPassword;
import static frontend.LoginController.lang;
import static java.lang.System.out;

public class RegController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;

    @FXML
    private ImageView front;

    @FXML
    private Text field_name;

    @FXML
    private Text create_acc;

    @FXML
    private Text field_password;

    @FXML
    private Label error_field;

    @FXML
    private Button log_in_reg_button;

    @FXML
    private TextField log_user_name;

    @FXML
    private PasswordField log_user_password;

    @FXML
    void initialize() {
        log_in_reg_button.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> log_user_name.getText().trim().isEmpty() || log_user_password.getText().trim().isEmpty(),
                        log_user_name.textProperty(),
                        log_user_password.textProperty()
                )
        );
        switch (lang) {
            case "LIETUVIŠKAS" -> {
                ResourceBundle labels = ResourceBundle.getBundle("login_button_lt");
                String buttonText = labels.getString("log");
                log_in_reg_button.setText(buttonText);
                buttonText = labels.getString("back");
                back_button.setText(buttonText);
                buttonText = labels.getString("creat_acc");
                create_acc.setText(buttonText);
                buttonText = labels.getString("name");
                field_name.setText(buttonText);
                buttonText = labels.getString("password");
                field_password.setText(buttonText);
                lang = "LIETUVIŠKAS";
            }
            case "ENGLISH" -> {
                ResourceBundle labels = ResourceBundle.getBundle("login_button_en");
                String buttonText = labels.getString("log");
                log_in_reg_button.setText(buttonText);
                buttonText = labels.getString("back");
                back_button.setText(buttonText);
                buttonText = labels.getString("creat_acc");
                create_acc.setText(buttonText);
                buttonText = labels.getString("name");
                field_name.setText(buttonText);
                buttonText = labels.getString("password");
                field_password.setText(buttonText);
                lang = "ENGLISH";
            }
            case "Islandų" -> {
                ResourceBundle labels = ResourceBundle.getBundle("login_button_is");
                String buttonText = labels.getString("log");
                log_in_reg_button.setText(buttonText);
                buttonText = labels.getString("back");
                back_button.setText(buttonText);
                buttonText = labels.getString("creat_acc");
                create_acc.setText(buttonText);
                buttonText = labels.getString("name");
                field_name.setText(buttonText);
                buttonText = labels.getString("password");
                field_password.setText(buttonText);
                lang = "Islandų";
            }
            case "RUSSIAN" -> {
                log_in_reg_button.setText("ВОЙТИ");
                back_button.setText("НАЗАД");
                create_acc.setText("Создайте аккаунт");
                field_name.setText("Ваше имя");
                field_password.setText("Ваш пароль");
                lang = "RUSSIAN";
            }
        }

    }

    @FXML
    void goMain() {
        this_client = new Client(log_user_name.getText(), gethashPassword(log_user_password.getText()));
        Messages answer;
        try {
            send(channel, new Shipment(this_client, 2));
            answer = printer(channel);
            if (answer.getMessage().equals("Success")) {
                out.println("You have successfully logged in!");
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-window.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) log_in_reg_button.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
                error_field.setText("");
            } else {
                if (lang.equals("LIETUVIŠKAS")) {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_lt");
                    String buttonText = labels.getString("error_reg");
                    error_field.setText(buttonText);
                    lang = "LIETUVIŠKAS";
                } else if (lang.equals("ENGLISH")) {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_en");
                    String buttonText = labels.getString("error_reg");
                    error_field.setText(buttonText);
                    lang = "ENGLISH";
                } else if (lang.equals("Islandų")) {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_is");
                    String buttonText = labels.getString("error_reg");
                    error_field.setText(buttonText);
                    lang = "Islandų";
                } else if (lang.equals("RUSSIAN")) {
                    error_field.setText("Такой пользователь уже есть");
                    lang = "RUSSIAN";
                }
                out.println(answer);
            }
        } catch (IOException | ClassNotFoundException ex) {
            out.println(ex.getMessage());
        }

    }
    @FXML
    void goBack() {
        try {
            // Загрузка FXML главного окна
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("start-window.fxml")); // Укажите путь к вашему файлу FXML главного окна
            Parent mainView = loader.load();

            // Получение сцены из текущего окна
            Scene mainScene = new Scene(mainView);

            // Получение текущего окна (stage) из любого элемента UI, например, кнопки
            Stage window = (Stage) back_button.getScene().getWindow();

            // Установка новой сцены в текущее окно
            window.setScene(mainScene);
            window.show();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

}
