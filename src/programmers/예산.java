package programmers;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;

        for(int i=0; i<d.length; i++){
            if(d[i] > budget) break;
            budget -= d[i];
            answer++;
        }
        return answer;
    }
}
