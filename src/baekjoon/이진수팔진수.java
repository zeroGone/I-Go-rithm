package baekjoon;

import java.util.Scanner;

public class 이진수팔진수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String binaryNumber = scanner.next();
        StringBuilder stringBuilder = new StringBuilder();

        if (binaryNumber.length() % 3 == 1) {
            stringBuilder.append(binaryNumber.charAt(0) - 48);
        }
        if (binaryNumber.length() % 3 == 2) {
            stringBuilder.append(binaryNumber.charAt(1) - 48 + (binaryNumber.charAt(0) - 48) * 2);
        }

        for (int index = binaryNumber.length() % 3; index < binaryNumber.length(); index += 3) {
            stringBuilder.append(calculate(binaryNumber.substring(index, index + 3)));
        }
        System.out.print(stringBuilder.toString());
    }

    private static int calculate(String numberString) {
        int sum = numberString.charAt(2) - 48;
        sum += (numberString.charAt(1) - 48) * 2;
        return sum + (numberString.charAt(0) - 48) * 4;
    }
}