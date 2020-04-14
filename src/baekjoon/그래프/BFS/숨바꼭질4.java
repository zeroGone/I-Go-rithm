package baekjoon.그래프.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 숨바꼭질4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();

        boolean[] check = new boolean[100001];
        int[][] dist = new int[100001][2];

        LinkedList<Integer> q = new LinkedList<>();

        q.add(N);
        check[N] = true;

        while (!q.isEmpty()) {
            int now = q.pop();

            if (now - 1 >= 0 && !check[now - 1]) {
                check[now - 1] = true;
                q.add(now - 1);
                dist[now - 1][0] = dist[now][0] + 1;
                dist[now - 1][1] = now;
            }
            if (now + 1 < 100001 && !check[now + 1]) {
                check[now + 1] = true;
                q.add(now + 1);
                dist[now + 1][0] = dist[now][0] + 1;
                dist[now + 1][1] = now;
            }

            if (now * 2 < 100001 && !check[now * 2]) {
                check[now * 2] = true;
                q.add(now * 2);
                dist[now * 2][0] = dist[now][0] + 1;
                dist[now * 2][1] = now;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(dist[K][0] + "\n");

        q.add(K);
        int value = K;
        while (dist[value][1] != 0) {
            q.add(dist[value][1]);
            value = dist[value][1];
        }
        if (N == 0) q.add(0);
        while (!q.isEmpty()) builder.append(q.pollLast() + " ");

        System.out.println(builder.deleteCharAt(builder.length() - 1).toString());
    }
}
