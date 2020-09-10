package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 연결요소의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) edges.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.get(u - 1).add(v - 1);
            edges.get(v - 1).add(u - 1);
        }

        boolean[] visited = new boolean[N];

        int num = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Stack<Integer> stack = new Stack<>();
                stack.add(i);

                while (!stack.isEmpty()) {
                    int now = stack.pop();
                    List<Integer> list = edges.get(now);
                    for (int edge : list) {
                        if (!visited[edge]) {
                            visited[edge] = true;
                            stack.add(edge);
                        }
                    }
                }
                num ++;
            }
        }

        System.out.print(num);
    }
}
