package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class 문자열폭발 {
    private static final Stack<Character> string = new Stack<>();
    private static final LinkedList<Character> remainingString = new LinkedList<>();

    private static String C4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] word = scanner.nextLine().toCharArray();
        for (char character : word) {
            string.push(character);
        }

        C4 = scanner.nextLine();

        solution();

        if (remainingString.isEmpty()) {
            System.out.print("FRULA");
        } else {
            StringBuilder outputBuilder = new StringBuilder();
            remainingString.forEach(outputBuilder::append);
            System.out.print(outputBuilder.toString());
        }
    }

    private static void solution() {
        int index = C4.length() - 1;

        while (!string.isEmpty()) {
            remainingString.push(string.pop());

            index = getIndex(index);
            index = explode(index);
        }
    }

    private static int getIndex(int index) {
        if (remainingString.peek() == C4.charAt(index)) {
            return index - 1;
        }

        if (remainingString.peek() == C4.charAt(C4.length() - 1)) {
            return C4.length() - 2;
        } else {
            return C4.length() - 1;
        }
    }

    private static int explode(int index) {
        if (index >= 0) {
            return index;
        }

        for (index = 0; index < C4.length(); index += 1) {
            remainingString.pop();
        }

        toOridinalString();

        return C4.length() - 1;
    }

    private static void toOridinalString() {
        int number = 0;
        while (!remainingString.isEmpty() && number < C4.length()) {
            string.push(remainingString.pop());
            number++;
        }
    }
}