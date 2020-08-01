package programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> q = new LinkedList<>();
        for(String s : cities){
            String value = s.toLowerCase();
            if(q.contains(value)){
                q.remove(value);
                answer+=1;
            } else{
                answer+=5;
            }

            q.add(value);
            if(q.size() > cacheSize) q.poll();
        }

        return answer;
    }
}
