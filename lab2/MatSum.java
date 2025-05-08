public class MatSum {

    public static int sumOfElements(int[][] matrix) {
        int totalSum = 0;

        for (int[] row : matrix) {
            for (int value : row) {
                totalSum += value;
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 2, 1},
                {4, 7, 8},
                {1, 12, 9}
        };

        System.out.println("Сумма всех элементов массива: " + sumOfElements(matrix));
    }
}
