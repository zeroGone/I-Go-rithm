package programmers;

import java.util.ArrayList;
import java.util.List;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {

        List<String> list = new ArrayList<>();
        int[] answer = new int[2];
        for(int i=1; i<words.length; i++){
            String string = words[i];
            if(list.contains(string) || words[i-1].charAt(words[i-1].length()) != string.charAt(0)){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                break;
            }else{
                list.add(string);
            }
        }

        return answer;
    }

}
