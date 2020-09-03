package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드합체놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());

        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) q.add(Long.parseLong(st.nextToken()));

        for (int i = 0; i < m; i++) {
            long a = q.poll();
            long b = q.poll();
            q.add(a+b);
            q.add(a+b);
        }

        long sum = 0;
        while(!q.isEmpty()) sum += q.poll();

        System.out.print(sum);
        reader.close();
    }
}
