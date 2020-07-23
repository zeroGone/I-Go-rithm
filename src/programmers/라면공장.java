package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

class 라면공장 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int start = 0;
        for (int day = 0; day < k; day++) {
            stock--;
            if (stock == 0 && day + 1 != k) {
                int index = start;
                while (index < dates.length && dates[index] <= day + 1) {
                    q.offer(supplies[index]);
                    index++;
                }

                start = index;
                answer++;
                stock += q.poll();
            }
        }

        return answer;
    }
}
