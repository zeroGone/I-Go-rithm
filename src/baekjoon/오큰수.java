package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int[] answer = new int[N];
            Arrays.fill(answer, -1);

            Queue<Number> queue = new LinkedList<>();
            for (int index = 0; index < N; index += 1) {
                queue.offer(new Number(Integer.parseInt(stringTokenizer.nextToken()), index));
            }

            Stack<Number> stack = new Stack<>();

            while (!queue.isEmpty()) {
                Number number = queue.poll();

                while (!stack.isEmpty() && stack.peek().value < number.value) {
                    answer[stack.pop().index] = number.value;
                }
                stack.push(number);
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int number : answer) {
                stringBuilder.append(number).append(" ");
            }
            System.out.print(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
        }
    }

    private static class Number {
        final int value;
        final int index;

        Number(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}