public class Sum {
    public static int findMaxSubarraySum(int[] numbers) {
        int maxTotal = numbers[0];
        int currentTotal = numbers[0];

        for (int index = 1; index < numbers.length; index++) {
            currentTotal = Math.max(numbers[index], currentTotal + numbers[index]);
            maxTotal = Math.max(maxTotal, currentTotal);
        }

        return maxTotal;
    }

    public static void main(String[] args) {
        int[] inputArray = {50, 100, -20, -10, 10, 30, -70, -90};
        System.out.println("Максимальная сумма подмассива: " + findMaxSubarraySum(inputArray));
    }
}

