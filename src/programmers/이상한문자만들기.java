package programmers;

import java.util.Collections;

public class 이상한문자만들기 {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();

        int index = 1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                builder.append(" ");
                index = 1;
            }
            else{
                if(index%2 == 0){
                    builder.append(Character.toLowerCase(s.charAt(i)));
                }else{
                    builder.append(Character.toUpperCase(s.charAt(i)));
                }
                index ++;
            }
        }

        return builder.toString();
    }
}
