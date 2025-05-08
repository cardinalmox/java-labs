import java.util.Scanner;

public class Treasure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetX = scanner.nextInt();
        int targetY = scanner.nextInt();
        scanner.nextLine();

        int currentX = 0;
        int currentY = 0;
        int stepsUsed = 0;

        while (true) {
            String direction = scanner.nextLine();

            if (direction.equals("стоп")) {
                break;
            }

            int distance = Integer.parseInt(scanner.nextLine());

            int newX = currentX;
            int newY = currentY;

            switch (direction) {
                case "север":
                    newY += distance;
                    break;
                case "юг":
                    newY -= distance;
                    break;
                case "восток":
                    newX += distance;
                    break;
                case "запад":
                    newX -= distance;
                    break;
            }

            int distBefore = Math.abs(targetX - currentX) + Math.abs(targetY - currentY);
            int distAfter = Math.abs(targetX - newX) + Math.abs(targetY - newY);

            if (distAfter < distBefore) {
                currentX = newX;
                currentY = newY;
                stepsUsed++;
            }

            if (currentX == targetX && currentY == targetY) {
                break;
            }
        }

        System.out.println(stepsUsed);
    }
}
