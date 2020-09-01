package programmers;

import java.util.Arrays;

public class 이xn타일링 {
    public static void main(String[] args) {
        System.out.println(new 이xn타일링().solution(60000));
    }

    public int solution(int n) {
        int[] a = new int[n + 1];
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            a[i] = a[i - 1] % 1000000007 + a[i - 2] % 1000000007;
        }
        return a[n] % 1000000007;
    }

}
