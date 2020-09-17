package programmers;

public class 가장긴팰린드롬 {
    public static void main(String[] args) {
        System.out.println(new 가장긴팰린드롬().solution("abcdcba"));
    }

    public int solution(String s) {
        for (int i = s.length(); i > 0; i--) {
            int index = 0;
            while (index + i <= s.length()) {
                int start = index;
                int end = index + i - 1;
                while (start <= end) {
                    if (s.charAt(start) != s.charAt(end)) break;
                    start++;
                    end--;
                }
                if (start >= end) return i;
                index++;
            }
        }
        return 0;
    }
}
