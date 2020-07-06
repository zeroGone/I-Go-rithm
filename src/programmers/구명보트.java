package programmers;

import java.util.Arrays;

public class 구명보트 {

    public static void main(String[] args) {
        int[] a = new int[50000];
        for(int i=0; i<50000; i++){
            a[i] = 1;
        }
//        System.out.println(solution(new int[]{10,20,30,40,50,60,70,80,90}, 100));
        System.out.println(solution(a, 100));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int leftValue = people[left];
            int rightValue = people[right];

            if (leftValue + rightValue <= limit){
               left++;
            }
            right--;
            answer++;
        }

        return answer;
    }
}
