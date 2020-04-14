package baekjoon.그래프.BFS;

import java.util.Arrays;
import java.util.LinkedList;
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

        System.out.println(solution(N,K));
    }

    //강의 풀이
    static int solution(int n, int m) {
        boolean[] check = new boolean[100001];
        int[] dist = new int[100001];

        check[n] = true;
        dist[n] = 0;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int now = q.pop();
            if (now - 1 >= 0 && !check[now - 1]) {
                q.add(now - 1);
                check[now - 1] = true;
                dist[now - 1] = dist[now] + 1;
            }
            if (now + 1 < 100001 && !check[now + 1]) {
                q.add(now + 1);
                check[now + 1] = true;
                dist[now + 1] = dist[now] + 1;
            }
            if (now * 2 < 100001 && !check[now * 2]) {
                q.add(now * 2);
                check[now * 2] = true;
                dist[now * 2] = dist[now] + 1;
            }
        }

        System.out.println(Arrays.toString(dist));

        return dist[m];
    }
}
