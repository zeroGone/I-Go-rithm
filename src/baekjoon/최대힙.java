package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        PriorityQueue<Long> q = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long input = Long.parseLong(reader.readLine());
            if(input != 0) q.add(input);
            else if(q.isEmpty()) builder.append(0).append("\n");
            else builder.append(q.poll()).append("\n");
        }
        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }
}
