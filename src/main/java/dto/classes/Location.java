package dto.classes;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

// Место в координатах режиссера
public class Location implements Serializable {
    @Getter
    public long x;
    @Getter
    public double y;
    @Getter
    public float z; //Поле не может быть null

    public Location(long x, double y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && Double.compare(y, location.y) == 0 && Float.compare(z, location.z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", z=" + z;
    }

}
