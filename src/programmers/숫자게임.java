package programmers;

import java.util.Arrays;

public class 숫자게임 {
    public static void main(String[] args) {
        System.out.println(new 숫자게임().solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
    }

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;

        int Aindex = A.length - 1;
        int Bindex = B.length - 1;

        while (Aindex >= 0 && Bindex >= 0) {
            if (B[Bindex] > A[Aindex]) {
                answer += 1;
                Bindex -= 1;
            }

            Aindex -= 1;
        }

        return answer;
    }
}