package programmers;

import java.util.ArrayList;
import java.util.List;

public class 삼진법뒤집기 {
    public int solution(int n) {
        List<Integer> numbers = new ArrayList<>();

        while (n != 0) {
            numbers.add(n % 3);
            n /= 3;
        }

        int answer = numbers.get(numbers.size() - 1);

        for (int index = numbers.size() - 2; index >= 0; index -= 1) {
            answer += numbers.get(index) * Math.pow(3, (numbers.size() - index - 1));
        }

        return answer;
    }
}
