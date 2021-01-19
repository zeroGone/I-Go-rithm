package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로 {
    private static class Edge implements Comparable<Edge>{
        int weight;
        int vertex;

        public Edge(int vertex, int weight) {
            this.weight = weight;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int V = Integer.parseInt(stringTokenizer.nextToken());
            int E = Integer.parseInt(stringTokenizer.nextToken());

            Map<Integer, List<Edge>> vertices = new HashMap<>();
            Map<Integer, Integer> distances = new HashMap<>();
            for (int number = 1; number <= V; number += 1) {
                vertices.put(number, new ArrayList<>());
                distances.put(number, Integer.MAX_VALUE);
            }

            int startVertex = Integer.parseInt(reader.readLine());
            distances.put(startVertex, 0);

            for (int number = 1; number <= E; number += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                int u = Integer.parseInt(stringTokenizer.nextToken());
                int v = Integer.parseInt(stringTokenizer.nextToken());
                int w = Integer.parseInt(stringTokenizer.nextToken());
                vertices.get(u).add(new Edge(v, w));
            }

            boolean[] visited = new boolean[V+1];
            Queue<Edge> queue = new PriorityQueue<>();
            queue.add(new Edge(startVertex, 0));

            while (!queue.isEmpty()) {
                int vertex = queue.poll().vertex;
                if(visited[vertex]){
                    continue;
                }
                visited[vertex] = true;
                for(Edge edge : vertices.get(vertex)){
                    if(distances.get(edge.vertex) > distances.get(vertex) + edge.weight){
                        distances.put(edge.vertex, distances.get(vertex) + edge.weight);
                        queue.add(new Edge(edge.vertex, distances.get(edge.vertex)));
                    }
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int number : distances.keySet()) {
                if(distances.get(number) == Integer.MAX_VALUE){
                    stringBuilder.append("INF");
                }else{
                    stringBuilder.append(distances.get(number));
                }
                stringBuilder.append("\n");
            }
            System.out.print(stringBuilder.deleteCharAt(stringBuilder.length()-1).toString());
        }
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