package programmers;

public class 음양더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int index = 0; index < absolutes.length; index += 1) {
            if (signs[index]) {
                answer += absolutes[index];
            } else {
                answer += -absolutes[index];
            }
        }
        return answer;
    }
}
