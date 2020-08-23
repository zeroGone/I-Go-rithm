package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        while (true) {
            String input = reader.readLine();
            if (input.equals(".")) break;

            Stack<Character> stack = new Stack<>();

            boolean check = false;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '(' || c == '[') stack.push(c);
                else if (c == ')' || c == ']') {
                    if (stack.isEmpty() || !check(c==')',stack.peek())) {
                        check = true;
                        break;
                    } else{
                       stack.pop();
                    }
                }
            }
            if (!check && stack.isEmpty()) builder.append("yes\n");
            else builder.append("no\n");
        }

        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }

    private static boolean check(boolean value, char c) {
        if (value && c == '(') return true;
        if (!value && c == '[') return true;
        return false;
    }
}
