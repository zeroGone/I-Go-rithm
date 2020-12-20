package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 좋은단어 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(reader.readLine());

            int answer = 0;
            for (int number = 1; number <= N; number += 1) {
                Stack<Character> stack = new Stack<>();

                char[] word = reader.readLine().toCharArray();

                for (char character : word) {
                    if (stack.isEmpty() || stack.peek() != character) {
                        stack.push(character);
                    } else {
                        stack.pop();
                    }
                }

                if (stack.isEmpty()) {
                    answer += 1;
                }
            }

            System.out.print(answer);
        }
    }
}