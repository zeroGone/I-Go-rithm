package programmers;

import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        System.out.println(new 괄호회전하기().solution("[](){}"));
    }

    public int solution(String s) {
        int answer = 0;
        for (int number = 0; number < s.length(); number += 1) {
            s = lotate(s);
            System.out.println(s);
            if (isRight(s)) {
                answer += 1;
            }
        }
        return answer;
    }

    private String lotate(String s) {
        StringBuilder stringBuilder = new StringBuilder(s.substring(0, s.length() - 1));
        stringBuilder.insert(0, s.charAt(s.length() - 1));
        return stringBuilder.toString();
    }

    private boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        for (char character : s.toCharArray()) {
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
                continue;
            }
            if (stack.isEmpty() || !isBracket(stack.peek(), character)) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    private boolean isBracket(char char1, char char2) {
        if (char1 == '(' && char2 == ')') {
            return true;
        }
        if (char1 == '{' && char2 == '}') {
            return true;
        }
        return char1 == '[' && char2 == ']';
    }
}
