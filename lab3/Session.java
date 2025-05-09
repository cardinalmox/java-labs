import java.io.Serializable;
import java.time.LocalDateTime;

public class Session implements Serializable {
    public String movie;
    public LocalDateTime time;
    public boolean[][] seats;

    public Session(String movie, LocalDateTime time, int rows, int cols) {
        this.movie = movie;
        this.time = time;
        this.seats = new boolean[rows][cols];
    }

    public boolean buyTicket(int row, int col) {
        if (row < 0 || col < 0 || row >= seats.length || col >= seats[0].length) return false;
        if (seats[row][col]) return false;
        seats[row][col] = true;
        return true;
    }

    public void printSeats() {
        System.out.println("Места (O = свободно, X = занято):");
        for (int i = 0; i < seats.length; i++) {
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }
}