package baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoDots {

    static char[][] board;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);

        board = new char[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++){
            String string = reader.readLine();
            for(int j=0; j<M; j++){
                board[i][j] = string.charAt(j);
            }
        }

        String output = "No";

        dfs:
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visit[i][j])
                    if(dfs(i,j,i,j, board[i][j])){
                        output="Yes";
                        break dfs;
                    }
            }
        }

        System.out.println(output);
        reader.close();
    }

    private static boolean dfs(int i, int j, int preI, int preJ, char ch){
        if(visit[i][j]) return true;
        visit[i][j] = true;
        if(j+1<board[0].length && board[i][j+1]==ch && j+1 != preJ){
            if(dfs(i, j+1, i, j, ch)) return true;
        }
        if(i+1<board.length && board[i+1][j]==ch && i+1 != preI){
            if(dfs(i+1, j, i, j, ch)) return true;
        }
        if(j-1>=0 && board[i][j-1]==ch && j-1 != preJ){
            if(dfs(i, j-1, i, j, ch)) return true;
        }
        if(i-1>=0 && board[i-1][j]==ch && i-1 != preI){
            if(dfs(i-1, j, i, j, ch)) return true;
        }
        return false;
    }
}
