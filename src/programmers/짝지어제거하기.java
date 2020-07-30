package programmers;

import java.util.Stack;

public class 짝지어제거하기 {
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.add(c);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
