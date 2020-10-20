package programmers;

import java.util.Arrays;

public class 야근지수 {

    public long solution(int n, int[] works) {
        Arrays.sort(works);

        long avg = 0;

        for (int work : works) {
            avg += work;
        }

        avg = avg / works.length;

        int start = 0;

        for (int index = 0; index < works.length; index++) {
            if (works[index] > avg) {
                start = index;
                break;
            }
        }

        int number = 0;
        int index = works.length - 1;

        while(number < works.length - start && n > 0){
            if(works[index] <= avg){
                number++;
            }else{
                works[index]--;
                n--;
            }
            index = index == start ? works.length-1 : index - 1;
        }

        index = works.length - 1;

        while(n > 0){
            works[index]--;
            n--;
            index = index == 0 ? works.length-1 : index -1;
        }

        long answer = 0;

        for(int work : works){
            answer += work < 0 ? 0 : Math.pow(work, 2);
        }

        return answer;
    }
}
