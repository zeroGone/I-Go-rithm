package baekjoon;

import java.util.Scanner;

public class 이친수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] nums = new long[N+1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i < N; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }

        System.out.print(nums[N - 1]);
    }
}
