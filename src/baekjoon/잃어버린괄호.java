package baekjoon;

import java.util.Scanner;

public class 잃어버린괄호 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        String processedString = calculatePlusOperation(string);

        System.out.println(calculateMinusOperation(processedString));
    }

    private static String calculatePlusOperation(String string) {
        if (!string.contains("+")) {
            return string;
        }

        int plusIndex = string.indexOf("+");

        int left = plusIndex - 1;
        int right = plusIndex + 1;
        while (left - 1 >= 0 && Character.isDigit(string.charAt(left - 1))) {
            left -= 1;
        }
        while (right < string.length() && Character.isDigit(string.charAt(right))) {
            right += 1;
        }

        int leftValue = Integer.parseInt(string.substring(left, plusIndex));
        int rightValue = Integer.parseInt(string.substring(plusIndex + 1, right));

        int newValue = leftValue + rightValue;

        return calculatePlusOperation(new StringBuilder(string).delete(left, right).insert(left, newValue).toString());
    }

    private static int calculateMinusOperation(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            int minusIndex = string.lastIndexOf("-");

            int left = minusIndex - 1;
            while (left >= 0 && Character.isDigit(string.charAt(left))) {
                left -= 1;
            }
            if (left < 0) {
                left += 1;
            }

            int leftValue = Integer.parseInt(string.substring(left, minusIndex));
            int rightValue = Integer.parseInt(string.substring(minusIndex));

            return calculateMinusOperation(new StringBuilder(string).delete(left, string.length()).insert(left, leftValue + rightValue).toString());
        }
    }
}
