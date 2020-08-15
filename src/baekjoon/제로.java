package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(reader.readLine());

        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            long n = Long.parseLong(reader.readLine());

            if (n != 0) stack.add(n);
            else if (stack.isEmpty()) stack.add((long) 0);
            else stack.pop();
        }

        int answer = 0;
        while(!stack.isEmpty()) answer+=stack.pop();

        System.out.println(answer);
    }
}
