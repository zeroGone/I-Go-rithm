package programmers;

import java.util.Arrays;

public class 행렬의곱셈 {
    public static void main(String[] args) {
        int[][] arr1 = new int[][]{
                {1,2,3},
                {4,5,6}
        };

        int[][] arr2 = new int[][]{
                {1,4},
                {4,5},
                {3,6}
        };

        System.out.println(Arrays.deepToString(new 행렬의곱셈().solution(arr1, arr2)));
    }


    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                int sum = 0;
                for (int z = 0; z < arr1[i].length; z++) {
                    sum += arr1[i][z] * arr2[z][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
