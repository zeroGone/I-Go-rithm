package programmers;

import java.util.Arrays;
import java.util.Collections;

//H-Index
public class HIndex {
    public static void main(String[] args) {
        System.out.println(new HIndex().solution(new int[]{6,6,6,6,6}));
        System.out.println(new HIndex().solution(new int[]{1,1}));
        System.out.println(new HIndex().solution(new int[]{0, 1, 3, 5, 5, 5, 5, 5, 5, 6}));

    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;

        for(int i=0; i<=10000; i++){
            int index = 0;
            while(index < citations.length){
                int value = citations[index];

                if(i <= value) break;

                index++;
            }

            if(i <= citations.length - index) answer = i;
        }
        return answer;
    }
}
