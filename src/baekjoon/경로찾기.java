package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 경로찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Edge[] map = new Edge[N];

        for(int i=0; i<N; i++){
            map[i] = new Edge();
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for(int j=0; j<N; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) map[i].addEdge(j);
            }
        }


        int[][] answer = new int[N][N];
        for(int i=0; i<N; i++){
            LinkedList<Integer> q = new LinkedList<>();
            boolean[] check = new boolean[N];
            for(int value : map[i].getEdges()){
                check[value] = true;
                q.add(value);
            }

            while(!q.isEmpty()){
                int now = q.poll();
                for(int value : map[now].getEdges()){
                    if(!check[value]){
                        check[value] = true;
                        q.add(value);
                    }
                }
            }

            for(int j=0; j<N; j++){
                if(check[j]) answer[i][j] = 1;
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<N;i++){
            StringBuilder temp = new StringBuilder();
            for(int j=0; j<N; j++){
                temp.append(answer[i][j]).append(" ");
            }
            builder.append(temp.deleteCharAt(temp.length()-1)).append("\n");
        }
        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }

    static class Edge{
        private final List<Integer> list;

        public Edge(){
            this.list = new ArrayList<>();
        }

        public void addEdge(int i){
            list.add(i);
        }

        public List<Integer> getEdges(){
            return this.list;
        }
    }
}
