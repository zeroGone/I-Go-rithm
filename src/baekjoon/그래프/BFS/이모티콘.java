package baekjoon.그래프.BFS;

import java.util.LinkedList;
import java.util.Scanner;

public class 이모티콘 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();

        int[][] visit = new int[1001][1001];

        for(int i=0; i<visit.length; i++){
            for(int j=0; j<visit[i].length; j++) visit[i][j] = -1;
        }

        LinkedList<Vertex> q = new LinkedList<>();
        visit[1][0] = 0;
        q.add(new Vertex(1,0));

        while(!q.isEmpty()){
            Vertex v = q.poll();
            int now = v.value;
            int clipBoard = v.clipBoard;

            if(visit[now][now] == -1){
                visit[now][now] = visit[now][clipBoard]+1;
                q.add(new Vertex(now, now));
            }
            if(now+clipBoard<1001&&visit[now+clipBoard][clipBoard]==-1){
                visit[now+clipBoard][clipBoard] = visit[now][clipBoard]+1;
                q.add(new Vertex(now+clipBoard, clipBoard));
            }
            if(now-1>=0&&visit[now-1][clipBoard] ==-1){
                visit[now-1][clipBoard] = visit[now][clipBoard] +1;
                q.add(new Vertex(now-1, clipBoard));
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<1001; i++){
            if(visit[S][i]!=-1&&answer>visit[S][i]) answer=visit[S][i];
        }
        System.out.println(answer);
    }

    static class Vertex{
        int value;
        int clipBoard;

        Vertex(int value, int clipBoard){
            this.value=value;
            this.clipBoard=clipBoard;
        }
    }
}
