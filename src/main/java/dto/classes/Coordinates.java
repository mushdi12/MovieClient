package dto.classes;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;
// место съемок в координатах

@Getter
public class Coordinates implements Serializable {

    public Double x; //Поле не может быть null

    public Long y; //Поле не может быть null

    public Coordinates(double x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }

}

