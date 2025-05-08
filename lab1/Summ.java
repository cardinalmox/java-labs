import java.util.Scanner;

public class Summ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();

            if (i % 2 == 0) {
                sum += number;
            } else {
                sum -= number;
            }
        }

        System.out.println(sum);
    }
}
