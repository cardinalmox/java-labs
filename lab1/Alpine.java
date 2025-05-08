import java.util.Scanner;

public class Alpine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numRoads = scanner.nextInt();
        int bestRoad = 0;
        int maxHeight = 0;

        for (int road = 1; road <= numRoads; road++) {
            int numTunnels = scanner.nextInt();
            int minTunnelHeight = Integer.MAX_VALUE;

            for (int i = 0; i < numTunnels; i++) {
                int height = scanner.nextInt();
                if (height < minTunnelHeight) {
                    minTunnelHeight = height;
                }
            }

            if (minTunnelHeight > maxHeight) {
                maxHeight = minTunnelHeight;
                bestRoad = road;
            }
        }

        System.out.println(bestRoad + " " + maxHeight);
    }
}
