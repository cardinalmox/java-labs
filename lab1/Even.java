import java.util.Scanner;

public class Even {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int a = num / 100;
        int b = (num / 10) % 10;
        int c = num % 10;

        int sum = a + b + c;
        int product = a * b * c;

        if (sum % 2 == 0 && product % 2 == 0) {
            System.out.println("ДА");
        } else {
            System.out.println("НЕТ");
        }
    }
}
