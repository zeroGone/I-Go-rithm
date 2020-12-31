package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class 후위표기식 {
    private static final Stack<Character> operators = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < expression.length(); index += 1) {
            char character = expression.charAt(index);

            if (Character.isAlphabetic(character)) {
                stringBuilder.append(character);
                continue;
            }

            if (character == ')') {
                while (operators.peek() != '(') {
                    stringBuilder.append(operators.pop());
                }
                operators.pop();
                continue;
            }

            while (!isPush(character)) {
                stringBuilder.append(operators.pop());
            }

            operators.push(character);
        }

        while (!operators.isEmpty()) {
            stringBuilder.append(operators.pop());
        }

        System.out.println(stringBuilder.toString());
    }

    private static boolean isPush(char operator) {
        if (operators.isEmpty()) {
            return true;
        }
        if (operator == '(') {
            return true;
        }

        return getPriority(operator) > getPriority(operators.peek());
    }

    private static int getPriority(char operator) {
        if (operator == '(') {
            return 0;
        }
        if (operator == '*' || operator == '/') {
            return 2;
        } else {
            return 1;
        }
    }
}