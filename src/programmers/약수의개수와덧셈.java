package programmers;

public class 약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        for (int value = left; value <= right; value += 1) {
            int sum = 0;
            for (int number = 1; number <= value; number += 1) {
                if (value % number == 0) {
                    sum += 1;
                }
            }

            if (sum % 2 == 0) {
                answer += value;
            } else {
                answer -= value;
            }
        }
        return answer;
    }
}
