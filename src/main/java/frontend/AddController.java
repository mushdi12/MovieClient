package frontend;

import dto.classes.Coordinates;
import dto.classes.Location;
import dto.classes.Movie;
import dto.classes.Person;
import dto.enums.*;
import dto.transmision.Shipment;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.ResourceBundle;

import static client.brain.ClientCode.*;
import static frontend.LoginController.lang;
import static frontend.MainController.list;

public class AddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField d_name;

    @FXML
    private Button d_name_button;

    @FXML
    private TextField d_x;

    @FXML
    private Button d_x_button;

    @FXML
    private TextField d_y;

    @FXML
    private Button d_y_button;

    @FXML
    private TextField d_z;

    @FXML
    private Button d_z_button;

    @FXML
    private TextField day;

    @FXML
    private Button day_button;

    @FXML
    private ComboBox<ColorOfEyes> eye;

    @FXML
    private Button eye_button;

    @FXML
    private Button finish_button;

    @FXML
    private Button genre_button;

    @FXML
    private ComboBox<MovieGenre> genre_combo;

    @FXML
    private ComboBox<ColorOfHair> hair;

    @FXML
    private Button hair_button;

    @FXML
    private TextField hour;

    @FXML
    private Button hour_button;

    @FXML
    private TextField m_x;

    @FXML
    private Button m_x_button;

    @FXML
    private TextField m_y;

    @FXML
    private Button m_y_button;

    @FXML
    private TextField minute;

    @FXML
    private Button minute_button;

    @FXML
    private TextField month;

    @FXML
    private Text m_f;

    @FXML
    private Text d_f;

    @FXML
    private Text b_f;

    @FXML
    private Text y_9;

    @FXML
    private Button month_button;

    @FXML
    private TextField movie_name;

    @FXML
    private Button movie_name_button;

    @FXML
    private ComboBox<MpaaRating> mpa_combo;

    @FXML
    private ComboBox<Country> nationality;

    @FXML
    private Button nationality_button;

    @FXML
    private Button npa_button;

    @FXML
    private TextField oscar;

    @FXML
    private Button oscar_button;

    @FXML
    private TextField second;

    @FXML
    private Button second_button;

    @FXML
    private TextField year;

    @FXML
    private Button year_button;


    @FXML
    void initialize() {
        genre_combo.getItems().addAll(MovieGenre.values());
        mpa_combo.getItems().addAll(MpaaRating.values());
        eye.getItems().addAll(ColorOfEyes.values());
        hair.getItems().addAll(ColorOfHair.values());
        nationality.getItems().addAll(Country.values());

        BooleanBinding allFieldsGreen = Bindings.createBooleanBinding(() -> isFieldGreen(movie_name) && isFieldGreen(m_x) && isFieldGreen(m_y) && isFieldGreen(oscar) && genre_combo.getValue() != null && eye.getValue() != null && hair.getValue() != null && mpa_combo.getValue() != null && nationality.getValue() != null && isFieldGreen(d_name) && isFieldGreen(year) && isFieldGreen(month) && isFieldGreen(day) && isFieldGreen(hour) && isFieldGreen(minute) && isFieldGreen(second) && isFieldGreen(d_x) && isFieldGreen(d_y) && isFieldGreen(d_z), movie_name.styleProperty(), m_x.styleProperty(), m_y.styleProperty(), oscar.styleProperty(), genre_combo.valueProperty(), eye.valueProperty(), hair.valueProperty(), mpa_combo.valueProperty(), nationality.valueProperty(), d_name.styleProperty(), year.styleProperty(), month.styleProperty(), day.styleProperty(), hour.styleProperty(), minute.styleProperty(), second.styleProperty(), d_x.styleProperty(), d_y.styleProperty(), d_z.styleProperty()

        );
        finish_button.disableProperty().bind(allFieldsGreen.not());
        switch (lang) {
            case "LIETUVIŠKAS" -> {
                ResourceBundle labels = ResourceBundle.getBundle("login_button_lt");
                String buttonText = labels.getString("m_name_");
                movie_name_button.setText(buttonText);
                m_x_button.setText("koordinet X:");
                m_y_button.setText("koordinet Y:");
                buttonText = labels.getString("o_c_");
                oscar_button.setText(buttonText);
                buttonText = labels.getString("gen");
                genre_button.setText(buttonText);
                buttonText = labels.getString("d_name_");
                d_name_button.setText(buttonText);
                buttonText = labels.getString("year_");
                year_button.setText(buttonText);
                buttonText = labels.getString("hour_");
                hour_button.setText(buttonText);
                buttonText = labels.getString("mon_");
                month_button.setText(buttonText);
                buttonText = labels.getString("day_");
                day_button.setText(buttonText);
                buttonText = labels.getString("min_");
                minute_button.setText(buttonText);
                buttonText = labels.getString("sec_");
                second_button.setText(buttonText);
                buttonText = labels.getString("eye_");
                eye_button.setText(buttonText);
                buttonText = labels.getString("hair_");
                hair_button.setText(buttonText);
                buttonText = labels.getString("nat_");
                nationality_button.setText(buttonText);
                d_x_button.setText("koordinet X:");
                d_y_button.setText("koordinet Y:");
                d_z_button.setText("koordinet Z:");
                buttonText = labels.getString("mf");
                m_f.setText(buttonText);
                buttonText = labels.getString("df");
                d_f.setText(buttonText);
                buttonText = labels.getString("bf");
                b_f.setText(buttonText);
                buttonText = labels.getString("yf");
                y_9.setText(buttonText);

                lang = "LIETUVIŠKAS";
            }
            case "ENGLISH" -> {
                ResourceBundle labels = ResourceBundle.getBundle("login_button_en");
                String buttonText = labels.getString("m_name_");
                movie_name_button.setText(buttonText);
                m_x_button.setText("Coordinate X:");
                m_y_button.setText("Coordinate Y:");
                buttonText = labels.getString("o_c_");
                oscar_button.setText(buttonText);
                buttonText = labels.getString("gen");
                genre_button.setText(buttonText);
                buttonText = labels.getString("d_name_");
                d_name_button.setText(buttonText);
                buttonText = labels.getString("year_");
                year_button.setText(buttonText);
                buttonText = labels.getString("hour_");
                hour_button.setText(buttonText);
                buttonText = labels.getString("mon_");
                month_button.setText(buttonText);
                buttonText = labels.getString("day_");
                day_button.setText(buttonText);
                buttonText = labels.getString("min_");
                minute_button.setText(buttonText);
                buttonText = labels.getString("sec_");
                second_button.setText(buttonText);
                buttonText = labels.getString("eye_");
                eye_button.setText(buttonText);
                buttonText = labels.getString("hair_");
                hair_button.setText(buttonText);
                buttonText = labels.getString("nat_");
                nationality_button.setText(buttonText);
                d_x_button.setText("Coordinate X:");
                d_y_button.setText("Coordinate Y:");
                d_z_button.setText("Coordinate Z:");
                buttonText = labels.getString("df");
                d_f.setText(buttonText);
                buttonText = labels.getString("mf");
                m_f.setText(buttonText);
                buttonText = labels.getString("bf");
                b_f.setText(buttonText);
                buttonText = labels.getString("yf");
                y_9.setText(buttonText);
                lang = "ENGLISH";
            }
            case "Islandų" -> {
                ResourceBundle labels = ResourceBundle.getBundle("login_button_is");
                String buttonText = labels.getString("m_name_");
                movie_name_button.setText(buttonText);
                m_x_button.setText("Hnit X:");
                m_y_button.setText("Hnit Y:");
                buttonText = labels.getString("o_c_");
                oscar_button.setText(buttonText);
                buttonText = labels.getString("gen");
                genre_button.setText(buttonText);
                buttonText = labels.getString("d_name_");
                d_name_button.setText(buttonText);
                buttonText = labels.getString("year_");
                year_button.setText(buttonText);
                buttonText = labels.getString("hour_");
                hour_button.setText(buttonText);
                buttonText = labels.getString("mon_");
                month_button.setText(buttonText);
                buttonText = labels.getString("day_");
                day_button.setText(buttonText);
                buttonText = labels.getString("min_");
                minute_button.setText(buttonText);
                buttonText = labels.getString("sec_");
                second_button.setText(buttonText);
                buttonText = labels.getString("eye_");
                eye_button.setText(buttonText);
                buttonText = labels.getString("hair_");
                hair_button.setText(buttonText);
                buttonText = labels.getString("nat_");
                nationality_button.setText(buttonText);
                d_x_button.setText("Hnit X:");
                d_y_button.setText("Hnit Y:");
                d_z_button.setText("Hnit Z:");
                buttonText = labels.getString("mf");
                m_f.setText(buttonText);
                buttonText = labels.getString("df");
                d_f.setText(buttonText);
                buttonText = labels.getString("bf");
                b_f.setText(buttonText);
                buttonText = labels.getString("yf");
                y_9.setText(buttonText);
                lang = "Islandų";
            }
            case "RUSSIAN" -> {
                movie_name_button.setText("Название");
                m_x_button.setText("Координата X:");
                m_y_button.setText("Координата Y:");
                oscar_button.setText("Кол-во Оскаров");
                genre_button.setText("Жанр");
                d_name_button.setText("Имя");
                year_button.setText("Год");
                month_button.setText("Месяц");
                day_button.setText("День");
                hour_button.setText("Час");
                minute_button.setText("Минута");
                second_button.setText("Секунда");
                eye_button.setText("Цвет глаз");
                hair_button.setText("Цвет волос");
                nationality_button.setText("Национальность");
                d_x_button.setText("Координата X:");
                d_y_button.setText("Координата Y:");
                d_y_button.setText("Координата Z:");
                m_f.setText("Данные о Фильме");
                d_f.setText("Данные о Режиссере");
                b_f.setText("День Рождения");
                y_9.setText("Год > 1900");
                lang = "RUSSIAN";
            }
        }




    }

    private boolean isFieldGreen(TextField field) {
        return "-fx-background-color: green;".equals(field.getStyle());
    }

    @FXML
    void finish() throws IOException, ClassNotFoundException {
        LocalDateTime dateTime = LocalDateTime.of(year_d, month_d, day_d, hour_d, minute_d, sec_d);
        Coordinates coordinates_movie = new Coordinates(m_cx, m_cy);
        Location location_director = new Location(lx, ly, lz);
        Person person = new Person(director, dateTime, eye.getValue(), hair.getValue(), nationality.getValue(), location_director);
        Movie m = new Movie(0, name_movie, coordinates_movie, ZonedDateTime.now(), oscar_movie, genre_combo.getValue(), mpa_combo.getValue(), person, this_client);
        send(channel, new Shipment("add", m, 5, this_client));
        if (printer(channel).getMessage().equalsIgnoreCase("Фильм успешно добавлен в базу данных")) {
            System.out.println("Фильм успешно добавлен в базу данных");
        }
        send(channel, new Shipment("show", 3, this_client));
        LinkedList listOfMovie = printer(channel).getList();
        list.clear();
        for (Object movie : listOfMovie) {
            list.add((Movie) movie);
        }
    }


    String name_movie;

    @FXML
    void checkMovieName() {
        String movieName = movie_name.getText().trim();
        if (movieName.isEmpty()) {
            movie_name.setStyle("-fx-background-color: red;");
        } else {
            movie_name.setStyle("-fx-background-color: green;");
            name_movie = movieName;
        }
    }


    double m_cx;

    @FXML
    void checkCX() {
        String m_coordX = m_x.getText().trim();
        if (isValidDouble(m_coordX)) {
            m_x.setStyle("-fx-background-color: red;");
        } else {
            m_x.setStyle("-fx-background-color: green;");
            m_cx = Double.parseDouble(m_coordX);
        }
    }

    long m_cy;

    @FXML
    void checkCY() {
        String m_coordY = m_y.getText().trim();
        if (isValidLong(m_coordY)) {
            m_y.setStyle("-fx-background-color: red;");
        } else {
            m_y.setStyle("-fx-background-color: green;");
            m_cy = Long.parseLong(m_coordY);
        }
    }

    int oscar_movie;

    @FXML
    void checkOscar() {
        String oscar_ = oscar.getText().trim();
        if (isValidInt(oscar_)) {
            oscar.setStyle("-fx-background-color: red;");
        } else {
            oscar.setStyle("-fx-background-color: green;");
            oscar_movie = Integer.parseInt(oscar_);
        }
    }

    String director;

    @FXML
    void checkDirectorName() {
        String directorName = d_name.getText().trim();
        if (directorName.isEmpty()) {
            d_name.setStyle("-fx-background-color: red;");
        } else {
            d_name.setStyle("-fx-background-color: green;");
            director = directorName;
        }
    }

    int year_d;

    @FXML
    void checkYear() {
        String year_ = year.getText().trim();
        if (isValidIntForYear(year_)) {
            year.setStyle("-fx-background-color: red;");
        } else {
            year.setStyle("-fx-background-color: green;");
            year_d = Integer.parseInt(year_);
        }
    }

    int month_d;

    @FXML
    void checkMonth() {
        String month_ = month.getText().trim();
        if (isValidIntForMonth(month_)) {
            month.setStyle("-fx-background-color: red;");
        } else {
            month.setStyle("-fx-background-color: green;");
            month_d = Integer.parseInt(month_);
        }
    }

    int day_d;

    @FXML
    void checkDay() {
        String day_ = day.getText().trim();
        if (isValidIntForDay(day_, String.valueOf(month_d))) {
            day.setStyle("-fx-background-color: red;");
        } else {
            day.setStyle("-fx-background-color: green;");
            day_d = Integer.parseInt(day_);
        }
    }

    int hour_d;

    @FXML
    void checkHour() {
        String hour_ = hour.getText().trim();
        if (isValidIntBigTime(hour_)) {
            hour.setStyle("-fx-background-color: red;");
        } else {
            hour.setStyle("-fx-background-color: green;");
            hour_d = Integer.parseInt(hour_);
        }
    }

    int minute_d;

    @FXML
    void checkMin() {
        String minute_ = minute.getText().trim();
        if (isValidIntTime(minute_)) {
            minute.setStyle("-fx-background-color: red;");
        } else {
            minute.setStyle("-fx-background-color: green;");
            minute_d = Integer.parseInt(minute_);
        }
    }

    int sec_d;

    @FXML
    void checkSec() {
        String second_ = second.getText().trim();
        if (isValidIntTime(second_)) {
            second.setStyle("-fx-background-color: red;");
        } else {
            second.setStyle("-fx-background-color: green;");
            sec_d = Integer.parseInt(second_);
        }
    }


    int lx;

    @FXML
    void checkLX() {
        String d_x_ = d_x.getText().trim();
        if (isInt(d_x_)) {
            d_x.setStyle("-fx-background-color: red;");
        } else {
            d_x.setStyle("-fx-background-color: green;");
            lx = Integer.parseInt(d_x_);
        }
    }

    long ly;

    @FXML
    void checkLY() {
        String d_y_ = d_y.getText().trim();
        if (isValidLongSimple(d_y_)) {
            d_y.setStyle("-fx-background-color: red;");
        } else {
            d_y.setStyle("-fx-background-color: green;");
            ly = Long.parseLong(d_y_);
        }
    }

    long lz;

    @FXML
    void checkLZ() {
        String d_z_ = d_z.getText().trim();
        if (isValidLong(d_z_)) {
            d_z.setStyle("-fx-background-color: red;");
        } else {
            d_z.setStyle("-fx-background-color: green;");
            lz = Long.parseLong(d_z_);
        }
    }


    private static boolean isValidLong(String input_1) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            Long.parseLong(input_1);
        } catch (NumberFormatException exp) {

            flag = true;
        }
        return flag; // Пример: возвращает true, если строка не пустая и не равна null
    }


    private static boolean isValidLongSimple(String input_1) {
        boolean flag = false;
        try {
            Long.parseLong(input_1);
        } catch (NumberFormatException exp) {

            flag = true;
        }
        return flag; // Пример: возвращает true, если строка не пустая и не равна null
    }

    private static boolean isInt(String input_1) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            Integer.parseInt(input_1);
        } catch (NumberFormatException exp) {
            flag = true;
        }

        return flag;// Пример: возвращает true, если строка не пустая и не равна null
    }


    private static boolean isValidIntTime(String input_1) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            if ((Integer.parseInt(input_1) < 0)) {
                flag = true;
            }
            if ((Integer.parseInt(input_1) >= 60)) {
                flag = true;
            }
        } catch (NumberFormatException exp) {

            flag = true;
        }

        return flag;//
    }

    private static boolean isValidIntBigTime(String input_1) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            if ((Integer.parseInt(input_1) < 0)) {
                flag = true;
            }
            if ((Integer.parseInt(input_1) >= 24)) {
                flag = true;
            }
        } catch (NumberFormatException exp) {

            flag = true;
        }

        return flag;//
    }

    private static boolean isValidIntForDay(String input_1, String month) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            if ((Objects.equals(month, "2") && (((Integer.parseInt(input_1)) > 28) || ((Integer.parseInt(input_1)) <= 0))) || ((Arrays.asList("4", "6", "9", "11").contains(month)) && (((Integer.parseInt(input_1)) >= 31) || ((Integer.parseInt(input_1)) <= 0))) || (!(Arrays.asList("4", "2", "6", "9", "11").contains(month)) && (((Integer.parseInt(input_1)) > 31) || ((Integer.parseInt(input_1)) <= 0)))) {
                flag = true;
            }
        } catch (NumberFormatException exp) {

            flag = true;
        }
        return flag;// Пример: возвращает true, если строка не пустая и не равна null
    }

    private static boolean isValidIntForMonth(String input_1) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            if ((Integer.parseInt(input_1) <= 0) || (Integer.parseInt(input_1)) > 12) {
                flag = true;
            }
        } catch (NumberFormatException exp) {

            flag = true;
        }
        return flag;// Пример: возвращает true, если строка не пустая и не равна null
    }

    private static boolean isValidIntForYear(String input_1) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            if (Integer.parseInt(input_1) <= 1900 || Integer.parseInt(input_1) >= 2024) {
                flag = true;
            }
        } catch (NumberFormatException exp) {

            flag = true;
        }

        return flag;// Пример: возвращает true, если строка не пустая и не равна null
    }

    private static boolean isValidInt(String input_1) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            if (Integer.parseInt(input_1) < 0) {
                flag = true;
            }
        } catch (NumberFormatException exp) {

            flag = true;
        }

        return flag;// Пример: возвращает true, если строка не пустая и не равна null
    }

    private static boolean isValidDouble(String input_1) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            Double.parseDouble(input_1);
        } catch (NumberFormatException exp) {
            flag = true;
        }
        return flag;
    }


}
