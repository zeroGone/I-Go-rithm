package baekjoon;

import java.util.Scanner;

public class 뒤집힌덧셈 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        System.out.print(Rev(Rev(X) + Rev(Y)));
    }

    private static int Rev(int value) {
        StringBuilder stringBuilder = new StringBuilder();

        String string = Integer.toString(value);
        for (char character : string.toCharArray()) {
            stringBuilder.insert(0, character);
        }

        return Integer.parseInt(stringBuilder.toString());
    }
}
