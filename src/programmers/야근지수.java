package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {

    public static void main(String[] args) {
        System.out.println(new 야근지수().solution(3, new int[]{1,1}));
    }

    public long solution(int n, int[] works) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int work : works){
            q.offer(work);
        }

        System.out.println(q);

        while(n > 0){
            int work = 0;

            if(!q.isEmpty()){
                work = q.poll();
            }

            if(work > 1){
                q.offer(work-1);
            }

            n--;
        }

        long answer = 0;

        while(!q.isEmpty()){
            int num = q.poll();
            System.out.println(num);
            answer += Math.pow(num, 2);
        }

        return answer;
    }
}
