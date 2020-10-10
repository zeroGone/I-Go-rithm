package mystudy.kruskal;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Vertex[] vertices = new Vertex[]{
                new Vertex(0, 1, 11),
                new Vertex(0, 2, 9),
                new Vertex(0, 3, 8),
                new Vertex(1, 2, 13),
                new Vertex(1, 4, 8),
                new Vertex(2, 5, 12),
                new Vertex(2, 6, 5),
                new Vertex(3, 6, 10),
                new Vertex(4, 5, 7),
        };

        System.out.println(new Main().kruskal(vertices));
    }

    private int kruskal(Vertex[] graph) {
        //1. 그래프의 정점들을 구함
        Set<Integer> edges = new HashSet<>();
        for(Vertex vertex : graph){
            int[] edgesOfVertex = vertex.getEdges();
            edges.add(edgesOfVertex[0]);
            edges.add(edgesOfVertex[1]);
        }

        //2. 최소 신장 트리 초기화
        List<Vertex> tree = new ArrayList<>();

        //3. 각 정점의 집합 초기화
        Map<Integer, Set<Integer>> setOfEdge = new HashMap<>();
        for(int edge : edges){
            Set<Integer> set = new HashSet<>();
            set.add(edge);
            setOfEdge.put(edge, set);
        }

        //4. 간선들의 비용순으로 정렬
        Arrays.sort(graph);

        int answer = 0 ;//간선의 합

        //5. 최소 신장 트리의 간선의 수가 정점의 갯수 - 1 이 될 때까지
        int index = 0;

        while(tree.size() < edges.size() -1){
            Vertex vertex = graph[index++];
            int[] edgesOfVertex = vertex.getEdges();

            Set<Integer> set1 = setOfEdge.get(edgesOfVertex[0]);
            Set<Integer> set2 = setOfEdge.get(edgesOfVertex[1]);

            //각 정점이 다른 집합에 속해있으면 합친다
            if (!set1.equals(set2)) {
                //집합2의 각각 원소들의 해당되는 집합들을 집합1로 교체하고
                for (int edge : set2) {
                    setOfEdge.put(edge, set1);
                }
                //교체된 집합1에 집합2를 더한다
                set1.addAll(set2);
                tree.add(vertex);

                //최소 간선의 합
                answer += vertex.getWeight();
            }
        }

        System.out.println(tree);//만들어진 최소 신장 트리 출력
        return answer;
    }

    private static class Vertex implements Comparable<Vertex> {
        private final int[] edges;
        private final int weight;

        public Vertex(int edge1, int edge2, int weight) {
            this.edges = new int[2];
            this.edges[0] = edge1;
            this.edges[1] = edge2;
            this.weight = weight;
        }

        public int[] getEdges() {
            return edges;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.weight <= o.getWeight() ? -1 : 1;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "edges=" + Arrays.toString(edges) +
                    ", weight=" + weight +
                    '}';
        }
    }

}
