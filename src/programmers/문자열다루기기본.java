package programmers;

public class 문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = true;
        for(char c : s.toCharArray()){
            if(!Character.isDigit(c)) {
                answer = false;
                break;
            }
        }
        return answer && (s.length() == 4 || s.length() == 6);
    }
}
