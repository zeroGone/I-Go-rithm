package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 가장먼노드 {
    public static void main(String[] args) {
        System.out.println(new 가장먼노드().solution(6, new int[][]{
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        }));

        System.out.println(new 가장먼노드().solution(5, new int[][]{
                {1, 2}, {2, 3}, {1, 3}, {2, 4}, {4, 5}
        }));
    }

    public int solution(int n, int[][] edge) {
        Vertex[] vertex = new Vertex[n + 1];
        for (int i = 1; i <= n; i++) vertex[i] = new Vertex(i);

        for (int[] ints : edge) {
            vertex[ints[0]].addEdge(ints[1]);
            vertex[ints[1]].addEdge(ints[0]);
        }

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        LinkedList<Integer> q = new LinkedList<>();
        q.add(1);

        int answer = 0;
        while(true){
            if(q.isEmpty()) break;
            List<Integer> next = new ArrayList<>();
            while (!q.isEmpty()) {
                int value = q.poll();

                for (int i : vertex[value].getList()) {
                    if (!visited[i]) {
                        visited[i] = true;
                        next.add(i);
                    }
                }
            }

            q.addAll(next);
        }
        return answer;
    }


    class Vertex {
        private final int edge;
        private List<Integer> list;

        public Vertex(int edge) {
            this.edge = edge;
            this.list = new ArrayList<>();
        }

        public void addEdge(int edge) {
            list.add(edge);
        }

        public List<Integer> getList() {
            return this.list;
        }
    }
}
