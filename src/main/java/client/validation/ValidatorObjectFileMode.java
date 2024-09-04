package client.validation;


import dto.classes.Coordinates;
import dto.classes.Location;
import dto.classes.Movie;
import dto.classes.Person;
import dto.enums.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static client.brain.ClientCode.this_client;


public class ValidatorObjectFileMode {
    private boolean flag = true;

    public Movie addElementModeFile(Integer id, List dop_info) {
        List info = dop_info;


        // Название
        String userstring = (String) info.get(0);
        if (isValid(userstring)) {
            System.out.println("Ошибка: поле не может быть числом и пустым. Повторите попытку.");
            flag = false;
        }

        // x
        String user_x = (String) info.get(1);
        if (isValidDouble(user_x)) {
            System.out.println("Ошибка: поле не может быть пустым и должно быть числом (double). Повторите попытку. !!!!!!");
            user_x = "1";
            flag = false;
        }
        double x_movie = Double.parseDouble(user_x);

        // y
        String user_y = (String) info.get(2);
        if (isValidLong(user_y)) {
            System.out.println("Ошибка: поле не может быть пустым и должно быть числом (long). Повторите попытку.");
            flag = false;
            user_y = "1";
        }
        long y_movie = Long.parseLong(user_y);
        Coordinates coordinates_movie = new Coordinates(x_movie, y_movie);

        // Оскар
        String user_oscar = (String) info.get(3);
        if ((isValidInt(user_oscar))) {
            System.out.println("Ошибка: поле должно быть числом >= 0 (int). Повторите попытку.");
            flag = false;
            user_oscar = "1";
        }
        int oscar_movie = Integer.parseInt(user_oscar);
        //
        ZonedDateTime time = ZonedDateTime.now();

        // Жанры
        MovieGenre movieGenre_test;
        String input_movieGenre = (String) info.get(4);
        input_movieGenre = input_movieGenre.toUpperCase();
        try {
            movieGenre_test = MovieGenre.valueOf(input_movieGenre);
        } catch (IllegalArgumentException e) {
            flag = false;
            movieGenre_test = MovieGenre.ACTION;
        }
        MovieGenre movieGenre = movieGenre_test;
        // рейтинг
        MpaaRating mpaaRating_test;
        String input_mpaaRating = (String) info.get(5);
        input_mpaaRating = input_mpaaRating.toUpperCase();
        try {
            mpaaRating_test = MpaaRating.valueOf(input_mpaaRating);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: такого рейтинга нет. Повторите ввод.");
            flag = false;
            mpaaRating_test = MpaaRating.G;
        }
        MpaaRating mpaaRating_movie = mpaaRating_test;

        //имя Режиссера
        String user_name = (String) info.get(6);
        if (isntInt(user_name)) {
            System.out.println("Ошибка: поле не должно быть числом и пустым. Повторите попытку.");
            user_name = "empty";
            flag = false;
        }

        //дата рождения Режиссера
        //год
        String user_year = (String) info.get(7);
        if (isValidIntForYear(user_year)) {
            System.out.println("Ошибка: поле(int) должен быть > 0. Повторите попытку.");
            user_year = "1";
            flag = false;
        }
        int year = Integer.parseInt(user_year);


        //месяц
        String user_month = (String) info.get(8);
        if (isValidIntForMonth(user_month)) {
            System.out.println("Ошибка: не может быть пусто и 0 <= число(int) <= 12). Повторите попытку.");
            user_month = "1";
            flag = false;
        }
        int month = Integer.parseInt(user_month);

        //день
        String user_day;
        user_day = (String) info.get(9);
        if (isValidIntForDay(user_day, String.valueOf(month))) {
            System.out.println("Ошибка: с таким месяцем нельзя указать такой день. Повторите попытку.");
            user_day = "1";
            flag = false;
        }
        int day = Integer.parseInt(user_day);

        //час
        String user_hour;

        user_hour = (String) info.get(10);
        if (isValidIntBigTime(user_hour)) {
            System.out.println("Ошибка: поле не может быть пусто и должно быть(int) <= 23. Повторите попытку.");
            user_hour = "1";
            flag = false;
        }
        int hour = Integer.parseInt(user_hour);

        //минута

        String user_minute = (String) info.get(11);
        if (isValidIntTime(user_minute)) {
            System.out.println("Ошибка: поле не может быть пусто и должно быть(int) <= 59. Повторите попытку.");
            user_minute = "1";
            flag = false;
        }
        int minute = Integer.parseInt(user_minute);

        //секунды
        String user_second = (String) info.get(12);
        if (isValidIntTime(user_second)) {
            System.out.println("Ошибка: поле не может быть пусто и должно быть(int) <= 59. Повторите попытку.");
            user_second = "1";
            flag = false;
        }

        int second = Integer.parseInt(user_second);


        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute, second);
        //цвет глаз
        ColorOfEyes colorOfEyes_test;

        String input_colorOfEyes = (String) info.get(13);
        input_colorOfEyes = input_colorOfEyes.toUpperCase();
        try {
            colorOfEyes_test = ColorOfEyes.valueOf(input_colorOfEyes);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: таких цвет глас нет. Повторите ввод.");
            colorOfEyes_test = ColorOfEyes.BLUE;
            flag = false;
        }
        ColorOfEyes colorOfEyes = colorOfEyes_test;
        //цвет волос
        ColorOfHair colorOfHair_test;
        String input_colorOfHair = (String) info.get(14);
        input_colorOfHair = input_colorOfHair.toUpperCase();
        try {
            colorOfHair_test = ColorOfHair.valueOf(input_colorOfHair);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: такого цвета волос нет. Повторите ввод.");
            colorOfHair_test = ColorOfHair.BLUE;
            flag = false;
        }
        ColorOfHair colorOfHair = colorOfHair_test;
        //национальность
        Country nationality_test;
        String input_nationality = (String) info.get(15);
        input_nationality = input_nationality.toUpperCase();
        try {
            nationality_test = Country.valueOf(input_nationality);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: такой национальности нет . Повторите ввод.");
            nationality_test = Country.NORTH_KOREA;
            flag = false;
        }
        Country nationality = nationality_test;

        //System.out.println("Введите координаты местонахождения режиссера: ");
        //x
        String user_x_director = (String) info.get(16);
        if (isInt(user_x_director)) {
            System.out.println("Ошибка: поле должно быть int. Повторите попытку.");
            user_x_director = "1";
            flag = false;
        }
        int x_director = Integer.parseInt(user_x_director);

        //y
        String user_y_director = (String) info.get(17);
        if (isValidLongSimple(user_y_director)) {
            System.out.println("Ошибка: поле должно быть long. Повторите попытку.");
            user_y_director = "1";
            flag = false;
        }
        long y_director = Long.parseLong(user_y_director);

        //z
        String user_z_director = (String) info.get(18);
        if (isValidLong(user_z_director)) {
            System.out.println("Ошибка: поле должно быть long и не пусто. Повторите попытку.");
            user_z_director = "1";
            flag = false;
        }
        long z_director = Long.parseLong(user_z_director);

        Location location_director = new Location(x_director, y_director, z_director);
        Person person = new Person(user_name, dateTime, colorOfEyes, colorOfHair, nationality, location_director);
        if (flag) {
            return new Movie(id, userstring, coordinates_movie, time, oscar_movie, movieGenre, mpaaRating_movie, person,this_client);
        } else {
            return null;
        }

    }

    private static boolean isValid(String input) {
        boolean flag = false;
        if (input.isEmpty()) {
            flag = true;
        }
        return (flag); // Пример: возвращает true, если строка не пустая и не равна null
    }

    private static boolean isntInt(String input) {
        if (input == null || input.isEmpty()) {
            return true; // Если строка пустая или null, вернуть true
        }
        try {
            Integer.parseInt(input); // Попытаться преобразовать строку в число
            return true; // Если успешно преобразовано, это число, вернуть false
        } catch (NumberFormatException e) {
            return false; // Если возникло исключение, значит строка не является числом, вернуть true
        }
    }

    private static boolean isValidIntForYear(String input_1) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            if (Integer.parseInt(input_1) <= 1900) {
                flag = true;
            }
        } catch (NumberFormatException exp) {

            flag = true;
        }

        return flag;// Пример: возвращает true, если строка не пустая и не равна null
    }

    private static boolean isInt(String input_1) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            if (Integer.parseInt(input_1) >= 2147483647) {
                flag = true;
            }

            Integer.parseInt(input_1);
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

    private static boolean isValidIntTime(String input_1) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            if ((Integer.parseInt(input_1) <= 0)) {
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
            if ((Integer.parseInt(input_1) <= 0)) {
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

    private static boolean isValidIntForDay(String input_1, String month) {
        boolean flag = false;
        try {
            if (input_1.isEmpty()) {
                flag = true;
            }
            if ((Objects.equals(month, "2") && (((Integer.parseInt(input_1)) > 28) || ((Integer.parseInt(input_1)) <= 0)))
                    || ((Arrays.asList("4", "6", "9", "11").contains(month)) && (((Integer.parseInt(input_1)) >= 31) || ((Integer.parseInt(input_1)) <= 0)))
                    || (!(Arrays.asList("4", "2", "6", "9", "11").contains(month)) && (((Integer.parseInt(input_1)) > 31) || ((Integer.parseInt(input_1)) <= 0)))) {
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
        }// Пример: возвращает true, если строка не пустая и не равна null
        return flag;
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
}

