package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 정수내림차순으로배치하기 {
    public long solution(long n) {
        List<Integer> list = new ArrayList<>();

        list.add((int)(n%10));
        while(n / 10 != 0 ){
            list.add((int)(n/10%10));
            n /= 10;
        }

        Collections.sort(list);

        long answer = 0;
        long ten = 1;
        for(int i : list){
            answer += i * ten;
            ten *= 10;
        }
        return answer;
    }
}
