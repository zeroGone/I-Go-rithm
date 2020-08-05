package programmers;

import java.util.*;

public class 소수만들기 {
    public static void main(String[] args) {
        System.out.println(new 소수만들기().solution(new int[]{
                1,2,7,6,4
        }));
    }

    private List<Integer> list = new ArrayList<>();

    public int solution(int[] nums) {
        combi(nums, new boolean[nums.length], 0, 3);

        int answer = 0;
        for(int i : list){
            if(isPrimeNumber(i)) answer++;
        }
        return answer;
    }

    private void combi(int[] nums, boolean[] check, int start, int depth) {
        if (depth == 0) {
            int sum = 0;
            for(int i = 0; i< check.length; i++){
                if(check[i]) {
                    sum += nums[i];
                }
            }
            list.add(sum);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            check[i] = true;
            combi(nums, check, i+1, depth-1);
            check[i] = false;
        }
    }

    public boolean isPrimeNumber(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false; //소수가 아니라면 false 리턴
        } return true; // 소수라면 true 리턴
    }
}
