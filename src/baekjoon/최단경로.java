package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로 {
    private static final Map<Integer, List<Edge>> vertexes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int V = Integer.parseInt(stringTokenizer.nextToken());
            for (int vertex = 1; vertex <= V; vertex += 1) {
                vertexes.put(vertex, new ArrayList<>());
            }

            int E = Integer.parseInt(stringTokenizer.nextToken());
            int startVertex = Integer.parseInt(reader.readLine());

            for (int number = 1; number <= E; number += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());

                int u = Integer.parseInt(stringTokenizer.nextToken());
                int v = Integer.parseInt(stringTokenizer.nextToken());
                int w = Integer.parseInt(stringTokenizer.nextToken());
                vertexes.get(u).add(new Edge(v, w));
            }

            int[] weights = new int[V + 2];
            Arrays.fill(weights, -1);

            Queue<Edge> queue = new LinkedList<>();
            queue.addAll(vertexes.get(startVertex));

            while (!queue.isEmpty()) {
                List<Edge> nexts = new ArrayList<>(queue);
                queue.clear();

                for (Edge next : nexts) {
                    int nextVertex = next.to;
                    if (weights[nextVertex] == -1 || weights[nextVertex] >= next.weight) {
                        weights[nextVertex] = next.weight;

                        List<Edge> edges = new ArrayList<>(vertexes.get(nextVertex));
                        edges.forEach(edge -> edge.weight += next.weight);
                        queue.addAll(edges);
                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            for (int vertex = 1; vertex <= V; vertex += 1) {
                if (vertex == startVertex) {
                    answer.append(0);
                } else if (weights[vertex] == -1) {
                    answer.append("INF");
                } else {
                    answer.append(weights[vertex]);
                }
                answer.append("\n");
            }
            System.out.print(answer.deleteCharAt(answer.length() - 1).toString());
        }
    }

    private static class Edge {
        final int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}