package programmers;

public class JadenCase문자열만들 {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();

        boolean check = true;
        for(char c : s.toCharArray()){
            if(c == ' '){
                builder.append(c);
                check = true;
            }else{
                builder.append( check? Character.toUpperCase(c) : Character.toLowerCase(c));
                check = false;
            }
        }
        return builder.toString();
    }
}
