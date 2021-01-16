package programmers;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
//        int[] a = new int[100000];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = (int) (Math.random() * 1000000000);
//        }
//        System.out.println(new 입국심사().solution(1000000000, a));

        System.out.println(new 입국심사().solution(6, new int[]{7, 10}));
        System.out.println(new 입국심사().solution(10, new int[]{2, 3, 4, 5}));
        System.out.println(new 입국심사().solution(10, new int[]{1, 5}));
        System.out.println(new 입국심사().solution(1, new int[]{2, 2}));
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 0;
        long end = Long.MAX_VALUE;
        long answer = Long.MAX_VALUE;

        while (start <= end) {
            long middle = (start + end) / 2;

            long peopleNumber = 0;
            for (int time : times) {
                peopleNumber += middle / time;

                if (peopleNumber >= n) {
                    break;
                }
            }

            if (peopleNumber < n) {
                start = middle + 1;
            } else {
                answer = Math.min(answer, middle);
                end = middle - 1;
            }
        }

        return answer;
    }
}