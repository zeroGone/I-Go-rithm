package programmers;

import java.util.Arrays;

public class 줄서는방법 {
    public static void main(String[] args) {
        for (int i=1; i<=24; i++){
            System.out.println(Arrays.toString(new 줄서는방법().solution(4, i)));
        }
    }

    public int[] solution(int n, long k) {
        answer = new int[n];

        int[] humans = new int[n];

        for (int i = 0; i < humans.length; i++) {
            humans[i] = i + 1;
        }

        return solution(k-1, n - 1, humans);
    }

    private int[] answer;
    private int answerIndex;

    public int[] solution(long value, int n, int[] array) {
        if (n == 0){
            answer[answerIndex++] = array[0];
            return answer;
        }

        int[] newArray = new int[array.length - 1];

        int temp = n;
        long sum = 1;

        while (temp > 1) {
            sum *= temp;
            temp--;
        }

        int index = (int) (value / sum);
        answer[answerIndex++] = array[index];

        int indexOfArray = 0;

        for (int i = 0; i < n + 1; i++) {
            if (i != index) {
                newArray[indexOfArray++] = array[i];
            }
        }

        return solution(value % sum, n - 1, newArray);
    }
}
