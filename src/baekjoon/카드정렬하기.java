package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 카드정렬하기 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            Queue<Long> queue = new PriorityQueue<>();
            for (int index = 0; index < N; index += 1) {
                queue.offer(Long.parseLong(reader.readLine()));
            }

            long answer = 0;

            List<Long> list = new ArrayList<>();
            while (queue.size() > 1) {
                long sum = queue.poll() + queue.poll();
                queue.offer(sum);
                list.add(sum);
            }

            for(Long value : list){
                answer += value;
            }

            System.out.print(answer);
        }
    }
}