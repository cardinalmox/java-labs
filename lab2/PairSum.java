import java.util.HashSet;

public class PairSum {

    public static int[] findPairWithSum(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return new int[]{complement, num};
            }
            seen.add(num);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 6, 9, 8};
        int target = 17;

        int[] pair = findPairWithSum(numbers, target);

        if (pair != null) {
            System.out.println("Пара: " + pair[0] + " и " + pair[1]);
        } else {
            System.out.println("Пара с суммой " + target + " не найдена.");
        }
    }
}
