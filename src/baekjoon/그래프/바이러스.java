package baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int lines = Integer.parseInt(reader.readLine());
        boolean[][] v = new boolean[101][101];
        for(int i=0; i<lines; i++){
            String[] str = reader.readLine().split(" ");
            v[Integer.parseInt(str[0])][Integer.parseInt(str[1])]=true;
            v[Integer.parseInt(str[1])][Integer.parseInt(str[0])]=true;
        }

        boolean[] visit = new boolean[101];
        Stack<Integer> stack = new Stack();
        stack.add(1);
        int num = -1;
        while(!stack.isEmpty()){
            int n = stack.pop();
            if(visit[n]) continue;
            visit[n] = true;
            num++;
            for(int i=0;i<101;i++){
                if(v[n][i]) stack.add(i);
            }
        }

        System.out.println(num);
    }
}
