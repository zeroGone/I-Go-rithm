package programmers;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        int num = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='p' || c == 'P') num ++;
            else if(c == 'y' || c=='Y') num --;
        }
        return num ==0;
    }
}
