package baekjoon.그래프.BFS;

import java.util.LinkedList;
import java.util.Scanner;

public class 숨바꼭질3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();

        boolean[] visit = new boolean[100001];
        int[] seconds = new int[100001];

        LinkedList<Integer> q = new LinkedList<>();
        q.add(N);
        visit[N] = true;

        while (!q.isEmpty()) {
            int now = q.pollFirst();
            if (now * 2 < 100001 && !visit[now * 2]) {
                q.add(0, now * 2);
                visit[now * 2] = true;
                seconds[now * 2] = seconds[now];
            }
            if (now - 1 >= 0 && !visit[now - 1]) {
                q.add(now - 1);
                visit[now - 1] = true;
                seconds[now - 1] = seconds[now] + 1;
            }
            if (now + 1 < 100001 && !visit[now + 1]) {
                q.add(now + 1);
                visit[now + 1] = true;
                seconds[now + 1] = seconds[now] + 1;
            }
        }

        System.out.println(seconds[K]);
    }
}
