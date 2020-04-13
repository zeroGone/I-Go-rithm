package baekjoon.그래프.BFS;

import java.util.Scanner;
import java.util.Stack;

public class 숨바꼭질 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();

        boolean[] visit = new boolean[100001];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> check = new Stack<>();
        stack.add(N);

        int seconds = 0;

        out:
        while (true) {
            while (!stack.isEmpty()) {
                int value = stack.pop();
                if (value == K) break out;
                if (value >= 0 && value <= 100000 && !visit[value]) check.add(value);
            }

            while (!check.isEmpty()) {
                int i = check.pop();
                if (i >= 0 && i <= 100000 && !visit[i]) {
                    stack.add(i + 1);
                    stack.add(i - 1);
                    stack.add(i * 2);
                    visit[i] = true;
                }
            }

            seconds++;
        }

        System.out.println(seconds);
    }
}
