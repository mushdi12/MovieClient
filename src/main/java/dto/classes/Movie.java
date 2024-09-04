package dto.classes;


import dto.enums.MovieGenre;
import dto.enums.MpaaRating;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
// класс Фильма
public class Movie implements Serializable {

    public Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    public String name; //Поле не может быть null, Строка не может быть пустой

    public Coordinates coordinate; //Поле не может быть null

    public ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    public Integer oscarsCount; //Значение поля должно быть больше 0, Поле может быть null

    public MovieGenre genre; //Поле может быть null

    public MpaaRating mpaaRating; //Поле не может быть null

    public Person director; //Поле может быть null

    public Client client;

    public Movie(Integer id, String name, Coordinates coordinate, ZonedDateTime creationDate, Integer oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person director, Client client) {
        this.id = id;
        this.name = name;
        this.coordinate = coordinate;
        this.creationDate = creationDate;
        this.oscarsCount = oscarsCount;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.director = director;
        this.client = client;

    }

    @Override
    public String toString() {
        return "Фильм:\n" +
                "  ID: " + id + "\n" +
                "  Название: '" + name + "'\n" +
                "  Координаты:\n" +
                "    X: " + coordinate.getX() + "\n" +
                "    Y: " + coordinate.getY() + "\n" +
                "  Дата выпуска: " + creationDate + "\n" +
                "  Количество Оскаров: " + oscarsCount + "\n" +
                "  Жанр: " + genre + "\n" +
                "  Рейтинг MPAA: " + mpaaRating + "\n" +
                "  Режиссёр: " + director.getName() + "\n" +
                "  Дата рождения режиссёра: " + director.getBirthday() + "\n" +
                "  Цвет глаз режиссёра: " + director.getEyeColor() + "\n" +
                "  Цвет волос режиссёра: " + director.getHairColor() + "\n" +
                "  Национальность режиссёра: " + director.getNationality() + "\n" +
                "  Локации:\n" +
                "    X: " + director.location.getX() + "\n" +
                "    Y: " + director.location.getY() + "\n" +
                "    Z: " + director.location.getZ() + "\n" +
                "  Владелец: " + client + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(coordinate, movie.coordinate) && Objects.equals(creationDate, movie.creationDate) && Objects.equals(oscarsCount, movie.oscarsCount) && genre == movie.genre && mpaaRating == movie.mpaaRating && Objects.equals(director, movie.director) && Objects.equals(client, movie.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinate, creationDate, oscarsCount, genre, mpaaRating, director, client);
    }

    public static List getFields(){
        List<String> list = new ArrayList<>();
        list.add("id");
        list.add("name");
        list.add("creationDate");
        list.add("oscarsCount");
        list.add("genre");
        list.add("mpaaRating");
        list.add("director's name");
        list.add("director's birthday");
        list.add("director's eyeColor");
        list.add("director's hairColor");
        list.add("director's nationality");
        return list;
    }

}


