package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의부모찾기 {
    private static final Map<Integer, List<Integer>> nodes = new HashMap<>();
    private static final int ROOT = 1;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            for (int number = 1; number <= N; number += 1) {
                nodes.put(number, new ArrayList<>());
            }

            for (int number = 1; number < N; number += 1) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
                int A = Integer.parseInt(stringTokenizer.nextToken());
                int B = Integer.parseInt(stringTokenizer.nextToken());
                nodes.get(A).add(B);
                nodes.get(B).add(A);
            }

            int[] parents = new int[N + 1];
            boolean[] visit = new boolean[N + 1];
            visit[ROOT] = true;

            dfs(parents, new boolean[N + 1], ROOT);

            StringBuilder stringBuilder = new StringBuilder();
            for (int number = 2; number <= N; number += 1) {
                stringBuilder.append(parents[number]).append("\n");
            }

            System.out.print(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
        }
    }

    private static void dfs(int[] parents, boolean[] visit, int number) {
        for (int child : nodes.get(number)) {
            if (!visit[child]) {
                visit[child] = true;
                dfs(parents, visit, child);
                parents[child] = number;
            }
        }
    }
}
