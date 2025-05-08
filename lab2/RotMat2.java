public class RotMat2 {

    public static int[][] rotate90CounterClockwise(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rotated = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[cols - 1 - j][i] = matrix[i][j];
            }
        }

        return rotated;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] original = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Оригинальная матрица:");
        printMatrix(original);

        int[][] rotated = rotate90CounterClockwise(original);

        System.out.println("Матрица после поворота на 90 градусов против часовой стрелки:");
        printMatrix(rotated);
    }
}
