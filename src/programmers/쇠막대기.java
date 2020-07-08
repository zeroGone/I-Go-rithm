package programmers;

import java.util.Stack;

public class 쇠막대기 {
    public int solution(String arrangement) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        char pre = arrangement.charAt(0);
        for (int i = 1; i < arrangement.length(); i++) {
            char now = arrangement.charAt(i);

            if (now == ')') {
                if (pre == '(') {
                    for(int j =0; j<stack.size(); j++){
                        stack.set(j, stack.get(j)+1);
                    }
                } else {
                    if (!stack.isEmpty()) answer += stack.pop() + 1;
                }
            } else {
                if (pre == '(') {
                    stack.push(0);
                }
            }
            pre = now;
        }

        return answer;
    }
}
