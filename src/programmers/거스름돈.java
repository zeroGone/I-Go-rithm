package programmers;

import java.util.Arrays;

public class 거스름돈 {
    public static void main(String[] args) {
        System.out.println(new 거스름돈().solution(10, new int[]{1, 2, 3, 4, 5}));
    }


    public int solution(int n, int[] money) {

        int[] nums = new int[n + 1];
        for (int m : money) {
            for (int i = 1; i < nums.length; i++) {
                if (i == m) nums[i]++;
                if (i - m >= 1 && nums[i - m] > 0) {
                    nums[i] += nums[i - m];
                }
            }
        }

        return nums[n];
    }
}
