package baekjoon.그래프.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 알고스팟 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);

        int[][] miro = new int[M][N];
        int[][] distance = new int[M][N];

        for(int i=0; i<M; i++){
            String string = reader.readLine();
            for(int j=0; j<N; j++){
                miro[i][j] = Integer.parseInt(String.valueOf(string.charAt(j)));
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        reader.close();
        LinkedList<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        distance[0][0] = 0;

        while (!q.isEmpty()){
            Point now = q.poll();
            int x = now.x;
            int y = now.y;

            int nowDist = distance[x][y];
            //오른쪽
            if(x+1<M){
                if(miro[x+1][y]==1){
                    if(nowDist+1 < distance[x+1][y]) {
                        distance[x+1][y] = nowDist+1;
                        q.add(new Point(x+1, y));
                    }
                }else{
                    if(nowDist<distance[x+1][y]){
                        distance[x+1][y] = nowDist;
                        q.add(new Point(x+1, y));
                    }
                }
            }
            //아래
            if(y+1<N){
                if(miro[x][y+1]==1){
                    if(nowDist+1 < distance[x][y+1]) {
                        distance[x][y+1] = nowDist+1;
                        q.add(new Point(x, y+1));
                    }
                }else{
                    if(nowDist<distance[x][y+1]){
                        distance[x][y+1] = nowDist;
                        q.add(new Point(x, y+1));
                    }
                }
            }
            //왼쪽
            if(x-1>=0){
                if(miro[x-1][y]==1){
                    if(nowDist+1 < distance[x-1][y]) {
                        distance[x-1][y] = nowDist+1;
                        q.add(new Point(x-1, y));
                    }
                }else{
                    if(nowDist<distance[x-1][y]){
                        distance[x-1][y] = nowDist;
                        q.add(new Point(x-1, y));
                    }
                }
            }
            //위
            if(y-1>=0){
                if(miro[x][y-1]==1){
                    if(nowDist+1 < distance[x][y-1]) {
                        distance[x][y-1] = nowDist+1;
                        q.add(new Point(x, y-1));
                    }
                }else{
                    if(nowDist<distance[x][y-1]){
                        distance[x][y-1] = nowDist;
                        q.add(new Point(x, y-1));
                    }
                }
            }
        }

        System.out.println(distance[M-1][N-1]);
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
