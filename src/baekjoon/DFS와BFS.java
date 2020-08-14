package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS {
    static boolean[][] 정점 = new boolean[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int V = Integer.parseInt(str[2]);

        boolean[] visit = new boolean[1001];

        for (int i = 0; i < 1001; i++) 정점[i] = new boolean[1001];

        for (int i = 0; i < M; i++) {
            str = reader.readLine().split(" ");

            int v1 = Integer.parseInt(str[0]);
            int v2 = Integer.parseInt(str[1]);

            정점[v1][v2] = true;
            정점[v2][v1] = true;
        }

        if (정점[V] == null) {
            System.out.println(V);
            System.out.println(V);
        } else {
            String output = dfs(visit, V);
            System.out.println(output.substring(0, output.length() - 1));
            visit = new boolean[1001];
            System.out.print(bfs(visit, V));
        }
    }

    static String dfs(boolean[] visit, int index) {
        if (visit[index]) return "";
        visit[index] = true;
        StringBuilder str = new StringBuilder();
        str.append(index).append(" ");
        for (int i = 0; i < 1001; i++) {
            if (정점[index][i]) str.append(dfs(visit, i));
        }
        return str.toString();
    }

    static String bfs(boolean[] visit, int index) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(index);
        StringBuilder builder = new StringBuilder();
        while (!q.isEmpty()) {
            int value = q.poll();
            if (!visit[value]) {
                visit[value] = true;
                builder.append(value).append(" ");
                for (int i = 0; i < 1001; i++) {
                    if (정점[value][i]) q.add(i);
                }
            }
        }

        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

}
