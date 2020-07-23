package programmers;

public class 올바른괄호 {
    public static void main(String[] args) {
        System.out.println(new 올바른괄호().solution("()()"));
    }

    boolean solution(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(0);
            if (c == '(') num++;
            else if (num == 0) return false;
            else num--;
        }
        return num == 0;
    }
}
