package client.validation;


import dto.classes.Coordinates;
import dto.classes.Location;
import dto.classes.Movie;
import dto.classes.Person;
import dto.enums.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

import static client.brain.ClientCode.this_client;


public class ValidatorObject {

    public Movie isValid(Integer id) {
        System.out.println("Введите данныe о фильме:");
        Scanner scanner = new Scanner(System.in);
        //
        String userstring = null;
        do {
            System.out.println("Введите название фильма: ");
            try {
                userstring = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
            if (isValid(userstring)) {
                System.out.println("Ошибка: поле не может быть и пустым. Повторите попытку.");
            }
        } while (isValid(userstring));
        String name_movie = userstring;
        //
        System.out.print("Введите координаты съемок,");
        String user_x = null;
        do {
            System.out.println("Введите x: ");
            try {
                user_x = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
            if (isValidDouble(user_x)) {
                System.out.println("Ошибка: поле не может быть пустым и должно быть числом (double). Повторите попытку.");
            }
        } while (isValidDouble(user_x));
        double x_movie = Double.parseDouble(user_x);
        String user_y = null;
        do {
            System.out.println("Введите y: ");
            try {
                user_y = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
            if (isValidLong(user_y)) {
                System.out.println("Ошибка: поле не может быть пустым и должно быть числом (long). Повторите попытку.");
            }
        } while (isValidLong(user_y));
        long y_movie = Long.parseLong(user_y);
        Coordinates coordinates_movie = new Coordinates(x_movie, y_movie);
        //
        String user_oscar = null;
        do {
            System.out.println("Введите кол-во оскаров: ");
            try {
                user_oscar = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }

            if ((isValidInt(user_oscar))) {
                System.out.println("Ошибка: поле должно быть числом >= 0 (int). Повторите попытку.");
            }
        } while (isValidInt(user_oscar));
        int oscar_movie = Integer.parseInt(user_oscar);
        //
        ZonedDateTime time = ZonedDateTime.now();
        //
        MovieGenre movieGenre_test;
        do {
            System.out.println("Введите один из предложенных жанров фильмов: ");
            for (MovieGenre movieGenre : MovieGenre.values()) {
                System.out.print(movieGenre + " ");
            }
            System.out.print("\n");
            String input_movieGenre = null;
            try {
                input_movieGenre = scanner.nextLine().toUpperCase().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
            try {
                movieGenre_test = MovieGenre.valueOf(input_movieGenre);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: такого жанра нет. Повторите ввод.");
                movieGenre_test = null;
            }
        } while (movieGenre_test == null);
        MovieGenre movieGenre = movieGenre_test;
        //
        MpaaRating mpaaRating_test;
        do {
            System.out.println("Введите один из предложенных MPA-рейтинг фильмов: ");
            for (MpaaRating mpaaRating : MpaaRating.values()) {
                System.out.print(mpaaRating + " ");
            }
            String input_mpaaRating = null;
            System.out.print("\n");
            try {
                input_mpaaRating = scanner.nextLine().toUpperCase().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
            try {
                mpaaRating_test = MpaaRating.valueOf(input_mpaaRating);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: такого рейтинга нет. Повторите ввод.");
                mpaaRating_test = null;
            }
        } while (mpaaRating_test == null);
        MpaaRating mpaaRating_movie = mpaaRating_test;
        //
        System.out.println("Введите информацию о режиссере фильма");
        String user_name = null;
        do {
            System.out.println("Введите имя Режиссера: ");
            try {
                user_name = scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }

            if (isntInt(user_name)) {
                System.out.println("Ошибка: поле не должно быть числом и пустым. Повторите попытку.");
            }
        } while (isntInt(user_name));
        String name_director = user_name;
        //
        System.out.println("Введите дату рождения Режиссера: ");
        String user_year = null;
        do {
            System.out.println("Введите год:");
            try {
                user_year = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }

            if (isValidIntForYear(user_year)) {
                System.out.println("Ошибка: поле(int) должен быть > 1900. Повторите попытку.");
            }
        } while (isValidIntForYear(user_year));
        int year = Integer.parseInt(user_year);
        //
        String user_month = null;
        do {
            System.out.println("Введите месяц: ");
            try {
                user_month = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }

            if (isValidIntForMonth(user_month)) {
                System.out.println("Ошибка: не может быть пусто и 0 < число(int) <= 12). Повторите попытку.");
            }
        } while (isValidIntForMonth(user_month));
        int month = Integer.parseInt(user_month);
        //
        String user_day = null;
        do {
            System.out.println("Введите день: ");
            try {
                user_day = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
            if (isValidIntForDay(user_day, String.valueOf(month))) {
                System.out.println("Ошибка: с таким месяцем нельзя указать такой день. Повторите попытку.");
            }
        } while (isValidIntForDay(user_day, String.valueOf(month)));
        int day = Integer.parseInt(user_day);
        //
        String user_hour = null;
        do {
            System.out.println("Введите час: ");
            try {
                user_hour = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
            if (isValidIntBigTime(user_hour)) {
                System.out.println("Ошибка: поле не может быть пусто и должно быть(int) <= 23. Повторите попытку.");
            }
        } while (isValidIntBigTime(user_hour));
        int hour = Integer.parseInt(user_hour);
        //
        String user_minute = null;
        do {
            System.out.println("Введите минуту: ");
            try {
                user_minute = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }

            if (isValidIntTime(user_minute) /* && ()*/) {
                System.out.println("Ошибка: поле не может быть пусто и должно быть(int) <= 59. Повторите попытку.");
            }
        } while (isValidIntTime(user_minute));
        int minute = Integer.parseInt(user_minute);
        //
        String user_second = null;
        do {
            System.out.println("Введите секунды: ");
            try {
                user_second = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
            if (isValidIntTime(user_second)) {
                System.out.println("Ошибка: поле не может быть пусто и должно быть(int) <= 59. Повторите попытку.");
            }
        } while (isValidIntTime(user_second));
        int second = Integer.parseInt(user_second);


        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute, second);
        //
        ColorOfEyes colorOfEyes_test;
        do {
            System.out.println("Введите один из предложенных цветов глаз: ");
            for (ColorOfEyes colorOfEyes : ColorOfEyes.values()) {
                System.out.print(colorOfEyes + " ");
            }
            String input_colorOfEyes = null;
            System.out.print("\n");
            try {
                input_colorOfEyes = scanner.nextLine().toUpperCase().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }

            try {
                colorOfEyes_test = ColorOfEyes.valueOf(input_colorOfEyes);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: таких цвет глас нет. Повторите ввод.");
                colorOfEyes_test = null;
            }
        } while (colorOfEyes_test == null);
        ColorOfEyes colorOfEyes = colorOfEyes_test;
        //
        ColorOfHair colorOfHair_test;
        do {
            System.out.println("Введите один из предложенных цветов волос: ");
            for (ColorOfHair colorOfHair : ColorOfHair.values()) {
                System.out.print(colorOfHair + " ");
            }
            System.out.print("\n");
            String input_colorOfHair = null;
            try {
                input_colorOfHair = scanner.nextLine().toUpperCase().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
            try {
                colorOfHair_test = ColorOfHair.valueOf(input_colorOfHair);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: такого цвета волос нет. Повторите ввод.");
                colorOfHair_test = null;
            }
        } while (colorOfHair_test == null);
        ColorOfHair colorOfHair = colorOfHair_test;
        //
        Country nationality_test;
        do {
            System.out.println("Введите одну из предложенных национальностей: ");
            for (Country country : Country.values()) {
                System.out.print(country + " ");
            }
            System.out.print("\n");
            String input_nationality = null;
            try {
                input_nationality = scanner.nextLine().toUpperCase().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }

            try {
                nationality_test = Country.valueOf(input_nationality);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: такой национальности нет. Повторите ввод.");
                nationality_test = null;
            }
        } while (nationality_test == null);
        Country nationality = nationality_test;
        //
        System.out.println("Введите координаты местонахождения режиссера: ");
        //
        String user_x_director = null;
        do {
            System.out.println("Введите x: ");
            try {
                user_x_director = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }

            if (isInt(user_x_director)) {
                System.out.println("Ошибка: поле должно быть int. Повторите попытку.");
            }
        } while (isValidInt(user_x_director));
        int x_director = Integer.parseInt(user_x_director);
        //
        String user_y_director = null;
        do {
            System.out.println("Введите y: ");
            try {
                user_y_director = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }

            if (isValidLongSimple(user_y_director)) {
                System.out.println("Ошибка: поле должно быть long. Повторите попытку.");
            }
        } while (isValidLongSimple(user_y_director));
        long y_director = Long.parseLong(user_y_director);
        //
        String user_z_director = null;
        do {
            System.out.println("Введите z: ");
            try {
                user_z_director = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.exit(0);
            }

            if (isValidLong(user_z_director)) {
                System.out.println("Ошибка: поле должно быть long и не пусто. Повторите попытку.");
            }
        } while (isValidLong(user_z_director));
        long z_director = Long.parseLong(user_z_director);

        Location location_director = new Location(x_director, y_director, z_director);
        Person person = new Person(name_director, dateTime, colorOfEyes, colorOfHair, nationality, location_director);
        return new Movie(id, name_movie, coordinates_movie, time, oscar_movie, movieGenre, mpaaRating_movie, person,this_client);


    }

    private static boolean isValid(String input) {
        return (input.isEmpty()); // Пример: возвращает true, если строка не пустая и не равна null
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

