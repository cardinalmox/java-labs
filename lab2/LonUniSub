import java.util.Scanner;

public class UniqueSubstringFinder {

    public static String longestUniqueSubstring(String input) {
        int start = 0;
        int end = 0;
        int maxLen = 0;
        int maxStart = 0;
        StringBuilder window = new StringBuilder();

        while (end < input.length()) {
            char current = input.charAt(end);
            if (window.indexOf(String.valueOf(current)) == -1) {
                window.append(current);
                if (window.length() > maxLen) {
                    maxLen = window.length();
                    maxStart = start;
                }
                end++;
            } else {
                window.deleteCharAt(0);
                start++;
            }
        }

        return input.substring(maxStart, maxStart + maxLen);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        String result = longestUniqueSubstring(input);
        System.out.println("Наибольшая подстрока без повторяющихся символов: " + result);
    }
}
