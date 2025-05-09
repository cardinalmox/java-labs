import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cinema implements Serializable {
    public String name;
    public List<Hall> halls = new ArrayList<>();

    public Cinema(String name) {
        this.name = name;
    }

    public void addHall(Hall hall) {
        halls.add(hall);
    }
}