package programmers;

import java.util.Stack;

public class 괄호변환 {
    public static void main(String[] args) {
        System.out.println(new 괄호변환().solution("()))((()"));
        System.out.println(new 괄호변환().solution("(()())()"));
        System.out.println(new 괄호변환().solution(")()("));

    }
    public String solution(String p) {
        if (p.length() == 0) return p;

        int i = 0;
        int num = p.charAt(i) == '(' ? 1 : -1;
        for (i = 1; num != 0 && i < p.length(); i++) {
            if (p.charAt(i) == '(') num++;
            else num--;
        }

        String u = p.substring(0, i);
        String v = p.substring(i);

        if(check(u)) return u + solution(v);
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        builder.append(solution(v));
        builder.append(')');

        StringBuilder temp = new StringBuilder();
        for(i = 1; i<u.length()-1; i++){
            if(u.charAt(i) == '(') temp.append(')');
            else temp.append('(');
        }
        builder.append(temp.toString());
        return builder.toString();
    }

    public boolean check(String u){
        if(u.charAt(0) == ')') return false;

        Stack<Character> stack = new Stack<>();
        stack.push(u.charAt(0));

        for(int i=1; i<u.length(); i++){
            char v = u.charAt(i);
            if(v == '(') stack.push(v);
            else if(stack.isEmpty()) return false;
            else stack.pop();
        }

        return stack.isEmpty();
    }
}
