package frontend;
/*
new Movie(100, "The Shawshank Redemption",
                    new Coordinates(12, 56), ZonedDateTime.now(ZoneId.of("Europe/Moscow")), 7, MovieGenre.DRAMA, MpaaRating.R,
                    new Person("Frank Darabont", LocalDateTime.of(1960, 1, 18, 0, 0),
                            ColorOfEyes.BLUE, ColorOfHair.BROWN, Country.NORTH_KOREA, new Location(1, 2, 4)), this_client),
            new Movie(101, "The Shawshank Redemption",
                    new Coordinates(12, 56), ZonedDateTime.now(ZoneId.of("Europe/Moscow")), 7, MovieGenre.DRAMA, MpaaRating.R,
                    new Person("Frank Darabont", LocalDateTime.of(1960, 1, 18, 0, 0),
                            ColorOfEyes.BLUE, ColorOfHair.BROWN, Country.NORTH_KOREA, new Location(1, 2, 4)), this_client)
 */

import dto.classes.Movie;
import dto.transmision.Shipment;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import static client.brain.ClientCode.*;
import static frontend.LoginController.lang;


public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Label user_name;

    @FXML
    private Label avg_field;

    @FXML
    private Button remove_button;

    @FXML
    private TextField field_remove;

    @FXML
    private URL location;

    @FXML
    private Text usernameText;

    @FXML
    private Label genre_field;

    @FXML
    private TableView<Movie> table;

    @FXML
    private TableColumn<Movie, Long> idColumn;

    @FXML
    private TableColumn<Movie, String> nameColumn;

    @FXML
    private TableColumn<Movie, Double> coordXColumn;

    @FXML
    private TableColumn<Movie, Long> coordYColumn;

    @FXML
    private TableColumn<Movie, String> creationColumn;

    @FXML
    private TableColumn<Movie, Integer> oscar_column;

    @FXML
    private TableColumn<Movie, String> genreColumn;

    @FXML
    private TableColumn<Movie, String> mpaaRatingColumn;

    @FXML
    private TableColumn<Movie, String> directorColumn;

    @FXML
    private TableColumn<Movie, String> birthdayColumn;

    @FXML
    private TableColumn<Movie, String> eyeColumn;

    @FXML
    private TableColumn<Movie, String> hairColumn;

    @FXML
    private TableColumn<Movie, String> nationalityColumn;

    @FXML
    private TableColumn<Movie, Double> loc_xColumn;

    @FXML
    private TableColumn<Movie, Double> loc_yColumn;

    @FXML
    private TextField field_remove_oscar;


    @FXML
    private Button remove_by_oscar_button;

    @FXML
    private TextField update_index;

    @FXML
    private TextField insert_index;

    @FXML
    private Label qwerty;

    @FXML
    private Button update_button;

    @FXML
    private Button insert_button;

    @FXML
    private Button map_2;

    @FXML
    private Button map_3;

    @FXML
    private Button avg_button;

    @FXML
    private Button help_button;

    @FXML
    private Button genre_button;

    @FXML
    private Button add_button;

    @FXML
    private Button reload_button;

    @FXML
    private Button clear_button;

    @FXML
    private ChoiceBox<String> change;

    @FXML
    private Text user_field_2;

    @FXML
    private TableColumn<Movie, Double> loc_zColumn;

    public static ObservableList<Movie> list = FXCollections.observableArrayList();

    private String getDate(ZonedDateTime dateTime) {
        return dateTime != null ? dateTime.toString() : "";
    }

    private String getDate(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.toString() : "";
    }

    @FXML
    void initialize() throws IOException, ClassNotFoundException {


        change.getItems().addAll("ENGLISH", "RUSSIAN", "LIETUVIŠKAS", "Islandų");

        user_name.setText(this_client.login);

        remove_button.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> !field_remove.getText().trim().matches("\\d+"), // Проверка на соответствие только цифрам
                        field_remove.textProperty()
                )
        );

        remove_by_oscar_button.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> !field_remove_oscar.getText().trim().matches("\\d+"), // Проверка на соответствие только цифрам
                        field_remove_oscar.textProperty()
                )
        );

        update_button.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> !update_index.getText().trim().matches("\\d+"), // Проверка на соответствие только цифрам
                        update_index.textProperty()
                )
        );

        insert_button.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> !insert_index.getText().trim().matches("\\d+"), // Проверка на соответствие только цифрам
                        insert_index.textProperty()
                )
        );
        switch (lang) {
            case "LIETUVIŠKAS" -> {
                ResourceBundle labels = ResourceBundle.getBundle("login_button_lt");
                String buttonText = labels.getString("avg_");
                avg_button.setText(buttonText);
                buttonText = labels.getString("remove_");
                remove_button.setText(buttonText);
                buttonText = labels.getString("remove_b_o_");
                remove_by_oscar_button.setText(buttonText);
                buttonText = labels.getString("genres_");
                genre_button.setText(buttonText);
                buttonText = labels.getString("update_");
                update_button.setText(buttonText);
                buttonText = labels.getString("insert_");
                insert_button.setText(buttonText);
                buttonText = labels.getString("add_");
                add_button.setText(buttonText);
                buttonText = labels.getString("clear_");
                clear_button.setText(buttonText);
                buttonText = labels.getString("help_");
                help_button.setText(buttonText);
                buttonText = labels.getString("2d_map_");
                map_2.setText(buttonText);
                //buttonText = labels.getString("3d_map_");
                //map_3.setText(buttonText);
                buttonText = labels.getString("reload_");
                reload_button.setText(buttonText);
                buttonText = labels.getString("user_");
                user_field_2.setText(buttonText);
                lang = "LIETUVIŠKAS";
            }
            case "ENGLISH" -> {
                ResourceBundle labels = ResourceBundle.getBundle("login_button_en");
                String buttonText = labels.getString("avg_");
                avg_button.setText(buttonText);
                buttonText = labels.getString("remove_");
                remove_button.setText(buttonText);
                buttonText = labels.getString("remove_b_o_");
                remove_by_oscar_button.setText(buttonText);
                buttonText = labels.getString("genres_");
                genre_button.setText(buttonText);
                buttonText = labels.getString("update_");
                update_button.setText(buttonText);
                buttonText = labels.getString("insert_");
                insert_button.setText(buttonText);
                buttonText = labels.getString("add_");
                add_button.setText(buttonText);
                buttonText = labels.getString("clear_");
                clear_button.setText(buttonText);
                buttonText = labels.getString("help_");
                help_button.setText(buttonText);
                buttonText = labels.getString("2d_map_");
                map_2.setText(buttonText);
                // buttonText = labels.getString("3d_map_");
                //map_3.setText(buttonText);
                buttonText = labels.getString("reload_");
                reload_button.setText(buttonText);
                buttonText = labels.getString("user_");
                user_field_2.setText(buttonText);
                lang = "ENGLISH";
            }
            case "Islandų" -> {
                ResourceBundle labels = ResourceBundle.getBundle("login_button_is");
                String buttonText = labels.getString("avg_");
                avg_button.setText(buttonText);
                buttonText = labels.getString("remove_");
                remove_button.setText(buttonText);
                buttonText = labels.getString("remove_b_o_");
                remove_by_oscar_button.setText(buttonText);
                buttonText = labels.getString("genres_");
                genre_button.setText(buttonText);
                buttonText = labels.getString("update_");
                update_button.setText(buttonText);
                buttonText = labels.getString("insert_");
                insert_button.setText(buttonText);
                buttonText = labels.getString("add_");
                add_button.setText(buttonText);
                buttonText = labels.getString("clear_");
                clear_button.setText(buttonText);
                buttonText = labels.getString("help_");
                help_button.setText(buttonText);
                buttonText = labels.getString("2d_map_");
                map_2.setText(buttonText);
                //buttonText = labels.getString("3d_map_");
                //map_3.setText(buttonText);
                buttonText = labels.getString("reload_");
                reload_button.setText(buttonText);
                buttonText = labels.getString("user_");
                user_field_2.setText(buttonText);
                lang = "Islandų";
            }
            case "RUSSIAN" -> {
                avg_button.setText("Сред.Ариф.Оскаров");
                remove_button.setText("Удалить по ID");
                remove_by_oscar_button.setText("Удалить по Оскару");
                genre_button.setText("Вывести жанры");
                update_button.setText("Обновит по ID");
                insert_button.setText("Вставить по ID");
                add_button.setText("Добавить");
                clear_button.setText("Удалить");
                help_button.setText("Помощь");
                map_2.setText("2D КАРТА");
                //map_3.setText("3D КАРТА");
                reload_button.setText("Обновить");
                user_field_2.setText("Пользователь");
                lang = "RUSSIAN";
            }
        }


        idColumn.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getId()).asObject());
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        coordXColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getCoordinate().getX()).asObject());
        coordYColumn.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getCoordinate().getY()).asObject());
        creationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(getDate(cellData.getValue().getCreationDate())));
        oscar_column.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getOscarsCount()).asObject());
        genreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenre().toString()));
        mpaaRatingColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMpaaRating().toString()));

        directorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDirector().getName()));
        birthdayColumn.setCellValueFactory(cellData -> new SimpleStringProperty(getDate(cellData.getValue().getDirector().getBirthday())));
        eyeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDirector().getEyeColor().toString()));
        hairColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDirector().getHairColor().toString()));
        nationalityColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDirector().getNationality().toString()));

        loc_xColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getDirector().getLocation().getX()).asObject());
        loc_yColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getDirector().getLocation().getY()).asObject());
        loc_zColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getDirector().getLocation().getZ()).asObject());

        table.setItems(list);

        res();
    }

    @FXML
    void changeL() {
        switch (change.getValue()) {
            case "LIETUVIŠKAS" -> {
                ResourceBundle labels = ResourceBundle.getBundle("login_button_lt");
                String buttonText = labels.getString("avg_");
                avg_button.setText(buttonText);
                buttonText = labels.getString("remove_");
                remove_button.setText(buttonText);
                buttonText = labels.getString("remove_b_o_");
                remove_by_oscar_button.setText(buttonText);
                buttonText = labels.getString("genres_");
                genre_button.setText(buttonText);
                buttonText = labels.getString("update_");
                update_button.setText(buttonText);
                buttonText = labels.getString("insert_");
                insert_button.setText(buttonText);
                buttonText = labels.getString("add_");
                add_button.setText(buttonText);
                buttonText = labels.getString("clear_");
                clear_button.setText(buttonText);
                buttonText = labels.getString("help_");
                help_button.setText(buttonText);
                buttonText = labels.getString("2d_map_");
                map_2.setText(buttonText);
                //buttonText = labels.getString("3d_map_");
                //map_3.setText(buttonText);
                buttonText = labels.getString("reload_");
                reload_button.setText(buttonText);
                buttonText = labels.getString("user_");
                user_field_2.setText(buttonText);
                lang = "LIETUVIŠKAS";
            }
            case "ENGLISH" -> {
                ResourceBundle labels = ResourceBundle.getBundle("login_button_en");
                String buttonText = labels.getString("avg_");
                avg_button.setText(buttonText);
                buttonText = labels.getString("remove_");
                remove_button.setText(buttonText);
                buttonText = labels.getString("remove_b_o_");
                remove_by_oscar_button.setText(buttonText);
                buttonText = labels.getString("genres_");
                genre_button.setText(buttonText);
                buttonText = labels.getString("update_");
                update_button.setText(buttonText);
                buttonText = labels.getString("insert_");
                insert_button.setText(buttonText);
                buttonText = labels.getString("add_");
                add_button.setText(buttonText);
                buttonText = labels.getString("clear_");
                clear_button.setText(buttonText);
                buttonText = labels.getString("help_");
                help_button.setText(buttonText);
                buttonText = labels.getString("2d_map_");
                map_2.setText(buttonText);
                //buttonText = labels.getString("3d_map_");
                //map_3.setText(buttonText);
                buttonText = labels.getString("reload_");
                reload_button.setText(buttonText);
                buttonText = labels.getString("user_");
                user_field_2.setText(buttonText);
                lang = "ENGLISH";
            }
            case "Islandų" -> {
                ResourceBundle labels = ResourceBundle.getBundle("login_button_is");
                String buttonText = labels.getString("avg_");
                avg_button.setText(buttonText);
                buttonText = labels.getString("remove_");
                remove_button.setText(buttonText);
                buttonText = labels.getString("remove_b_o_");
                remove_by_oscar_button.setText(buttonText);
                buttonText = labels.getString("genres_");
                genre_button.setText(buttonText);
                buttonText = labels.getString("update_");
                update_button.setText(buttonText);
                buttonText = labels.getString("insert_");
                insert_button.setText(buttonText);
                buttonText = labels.getString("add_");
                add_button.setText(buttonText);
                buttonText = labels.getString("clear_");
                clear_button.setText(buttonText);
                buttonText = labels.getString("help_");
                help_button.setText(buttonText);
                buttonText = labels.getString("2d_map_");
                map_2.setText(buttonText);
                //buttonText = labels.getString("3d_map_");
                //map_3.setText(buttonText);
                buttonText = labels.getString("reload_");
                reload_button.setText(buttonText);
                buttonText = labels.getString("user_");
                user_field_2.setText(buttonText);
                lang = "Islandų";
            }
            case "RUSSIAN" -> {
                avg_button.setText("Сред.Ариф.Оскаров");
                remove_button.setText("Удалить по ID");
                remove_by_oscar_button.setText("Удалить по Оскару");
                genre_button.setText("Вывести жанры");
                update_button.setText("Обновит по ID");
                insert_button.setText("Вставить по ID");
                add_button.setText("Добавить");
                clear_button.setText("Удалить");
                help_button.setText("Помощь");
                map_2.setText("2D КАРТА");
                //map_3.setText("3D КАРТА");
                reload_button.setText("Обновить");
                user_field_2.setText("Пользователь");
                lang = "RUSSIAN";
            }
        }

    }


    @FXML
    void reload() throws IOException, ClassNotFoundException {
        res();
        System.out.println("Таблица обновлена !");
    }


    @FXML
    void goGenres() throws IOException, ClassNotFoundException, NullPointerException {
        res();
        send(channel, new Shipment("print_field_ascending_genre", 3, this_client));
        genre_field.setText(printer(channel).getMessage());
        res();
    }

    @FXML
    void goAvg() throws IOException, ClassNotFoundException, NullPointerException {
        res();
        send(channel, new Shipment("average_of_oscars_count", 3, this_client));
        avg_field.setText(printer(channel).getMessage());
        res();
    }

    @FXML
    void goClear() throws IOException, ClassNotFoundException, NullPointerException {
        res();
        send(channel, new Shipment("clear", 3, this_client));
        System.out.println(printer(channel).getMessage());
        res();
    }

    @FXML
    void goRemove() throws IOException, ClassNotFoundException, NullPointerException {
        res();
        String index = field_remove.getText().trim();
        send(channel, new Shipment("remove_by_id", index, 4, this_client));
        if (printer(channel).getMessage().equalsIgnoreCase("Элемента с таким id не существует")) {
            switch (lang) {
                case "LIETUVIŠKAS" -> {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_lt");
                    String buttonText = labels.getString("remove_exp");
                    qwerty.setText(buttonText);
                    lang = "LIETUVIŠKAS";
                }
                case "ENGLISH" -> {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_en");
                    String buttonText = labels.getString("remove_exp");
                    avg_button.setText(buttonText);
                    qwerty.setText(buttonText);
                    lang = "ENGLISH";
                }
                case "Islandų" -> {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_is");
                    String buttonText = labels.getString("remove_exp");
                    avg_button.setText(buttonText);
                    qwerty.setText(buttonText);
                    lang = "Islandų";
                }
                case "RUSSIAN" -> {
                    qwerty.setText("Элемента с таким id не существует");
                    lang = "RUSSIAN";
                }

            }
        }
        res();

    }

    @FXML
    void goRBO() throws IOException, ClassNotFoundException {
        res();
        String index = field_remove_oscar.getText().trim();
        send(channel, new Shipment("remove_any_by_oscars_count", index, 4, this_client));
        if (!printer(channel).getMessage().equalsIgnoreCase("Запись с количеством оскаров была удалена.")){
            switch (lang) {
                case "LIETUVIŠKAS" -> {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_lt");
                    String buttonText = labels.getString("remove_bi_exp");
                    qwerty.setText(buttonText);
                    lang = "LIETUVIŠKAS";
                }
                case "ENGLISH" -> {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_en");
                    String buttonText = labels.getString("remove_bi_exp");
                    avg_button.setText(buttonText);
                    qwerty.setText(buttonText);
                    lang = "ENGLISH";
                }
                case "Islandų" -> {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_is");
                    String buttonText = labels.getString("remove_bi_exp");
                    avg_button.setText(buttonText);
                    qwerty.setText(buttonText);
                    lang = "Islandų";
                }
                case "RUSSIAN" -> {
                    qwerty.setText("Записи с количеством таким количество оскаров нет");
                    lang = "RUSSIAN";
                }

            }
        }

        res();

    }

    protected static int index_for_update;

    @FXML
    void goUpdate() {
        String index = update_index.getText().trim();
        index_for_update = Integer.parseInt(index);
        List<Integer> listIndex = new ArrayList();
        for (Movie m_ : list) {
            listIndex.add(m_.getId());
        }
        if (listIndex.contains(index_for_update)) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("update-window.fxml"));
                Parent root = fxmlLoader.load();
                Stage newStage = new Stage();
                newStage.setTitle("UPDATE'S WINDOW");
                newStage.setResizable(false);
                newStage.setScene(new Scene(root));
                newStage.show();
            } catch (IOException ex) {
                //throw new RuntimeException(ex);
                System.out.println("Ошибка!");
            }

        } else {
            switch (lang) {
                case "LIETUVIŠKAS" -> {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_lt");
                    String buttonText = labels.getString("update_exp");
                    qwerty.setText(buttonText);
                    lang = "LIETUVIŠKAS";
                }
                case "ENGLISH" -> {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_en");
                    String buttonText = labels.getString("update_exp");
                    avg_button.setText(buttonText);
                    qwerty.setText(buttonText);
                    lang = "ENGLISH";
                }
                case "Islandų" -> {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_is");
                    String buttonText = labels.getString("update_exp");
                    avg_button.setText(buttonText);
                    qwerty.setText(buttonText);
                    lang = "Islandų";
                }
                case "RUSSIAN" -> {
                    qwerty.setText("Такого индекса нет");
                    lang = "RUSSIAN";
                }

            }
        }
    }

    @FXML
    void goHelp() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("help-window.fxml"));
        Parent root = fxmlLoader.load();
        Stage newStage = new Stage();
        newStage.setResizable(false);
        newStage.setTitle("HELP'S WINDOW");
        newStage.setScene(new Scene(root));
        newStage.show();
    }

    protected static int index_for_insert;

    @FXML
    void goInsert() {
        String index = insert_index.getText().trim();
        index_for_insert = Integer.parseInt(index);
        List<Integer> listIndex = new ArrayList();
        for (Movie m_ : list) {
            listIndex.add(m_.getId());
        }
        if (listIndex.contains(index_for_insert)) {
            switch (lang) {
                case "LIETUVIŠKAS" -> {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_lt");
                    String buttonText = labels.getString("insert_exp");
                    qwerty.setText(buttonText);
                    lang = "LIETUVIŠKAS";
                }
                case "ENGLISH" -> {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_en");
                    String buttonText = labels.getString("insert_exp");
                    avg_button.setText(buttonText);
                    qwerty.setText(buttonText);
                    lang = "ENGLISH";
                }
                case "Islandų" -> {
                    ResourceBundle labels = ResourceBundle.getBundle("login_button_is");
                    String buttonText = labels.getString("insert_exp");
                    avg_button.setText(buttonText);
                    qwerty.setText(buttonText);
                    lang = "Islandų";
                }
                case "RUSSIAN" -> {
                    qwerty.setText("Такой индекс уже есть");
                    lang = "RUSSIAN";
                }
            }


        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("insert-window.fxml"));
                Parent root = fxmlLoader.load();
                Stage newStage = new Stage();
                newStage.setResizable(false);
                newStage.setTitle("INSERT'S WINDOW");
                newStage.setScene(new Scene(root));
                newStage.show();
            } catch (IOException ex) {
                //throw new RuntimeException(ex);
                System.out.println("Ошибка!");
            }
        }
    }


    @FXML
    void goAdd() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-window.fxml"));
            Parent root = fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setResizable(false);
            newStage.setTitle("ADD'S WINDOW");
            newStage.setScene(new Scene(root));
            newStage.show();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
            //System.out.println("Ошибка!");
        }
    }


    static void res() throws IOException, ClassNotFoundException {
        try {
            list.clear();
            send(channel, new Shipment("show", 3, this_client));
            LinkedList listOfMovie = printer(channel).getList();

            for (Object movie : listOfMovie) {
                list.add((Movie) movie);
            }
        } catch (NullPointerException e) {
            //System.out.println("Коллекция пуста!");
        }

    }

    @FXML
    void go2DMAP() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("coord-window.fxml"));
        Parent root = fxmlLoader.load();
        Stage newStage = new Stage();
        newStage.setTitle("2D MAP");
        newStage.setResizable(false);
        newStage.setScene(new Scene(root));
        newStage.show();
    }

    @FXML
    void go3DMAP() {

    }


}
