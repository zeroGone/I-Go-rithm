package programmers;

public class 내적 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int index = 0; index < a.length; index += 1) {
            answer += a[index] * b[index];
        }
        return answer;
    }
}
