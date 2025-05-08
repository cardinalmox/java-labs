public class RowMax {

    public static int[] maxElementsInRows(int[][] matrix) {
        int[] rowMaxes = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int max = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            rowMaxes[i] = max;
        }

        return rowMaxes;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {7, 4, 1},
                {9, 2, 6},
                {5, 8, 3}
        };

        int[] maxInRows = maxElementsInRows(matrix);

        System.out.println("Максимальные элементы по строкам:");
        for (int value : maxInRows) {
            System.out.print(value + " ");
        }
    }
}
