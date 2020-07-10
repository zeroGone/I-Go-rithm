package programmers;


import java.util.Arrays;

public class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        char [] a = s.toCharArray();
        Arrays.sort(a);
        StringBuilder builder = new StringBuilder(new String(a));
        return builder.reverse().toString();
    }
}
