package programmers;


import java.util.Arrays;

public class 주식가격 {

    public static void main(String[] args) {
        int[] a = new int[]{
                1, 2, 3, 2, 3, 3
        };

        System.out.println(Arrays.toString(solution(a)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int seconds = 0;
            for (int j = i + 1; j < prices.length; j++) {
                seconds++;
                if (prices[i] > prices[j]) break;
            }
            answer[i] = seconds;
        }

        return answer;
    }
}
