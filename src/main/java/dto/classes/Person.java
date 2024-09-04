package dto.classes;


import dto.enums.ColorOfEyes;
import dto.enums.ColorOfHair;
import dto.enums.Country;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class Person implements Serializable {

    public String name; //Поле не может быть null, Строка не может быть пустой

    public LocalDateTime birthday; //Поле не может быть null

    public ColorOfEyes eyeColor; //Поле не может быть null

    public ColorOfHair hairColor; //Поле может быть null

    public Country nationality; //Поле не может быть null

    public Location location; //Поле может быть null

    public Person(String name, LocalDateTime birthday, ColorOfEyes eyeColor, ColorOfHair hairColor, Country nationality, Location location) {
        this.name = name;
        this.birthday = birthday;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(birthday, person.birthday) && eyeColor == person.eyeColor && hairColor == person.hairColor && nationality == person.nationality && Objects.equals(location, person.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, eyeColor, hairColor, nationality, location);
    }
}