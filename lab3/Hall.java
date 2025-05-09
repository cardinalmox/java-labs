import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hall implements Serializable {
    public String name;
    public int rows;
    public int cols;
    public List<Session> sessions = new ArrayList<>();

    public Hall(String name, int rows, int cols) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
    }

    public void addSession(Session session) {
        sessions.add(session);
    }
}