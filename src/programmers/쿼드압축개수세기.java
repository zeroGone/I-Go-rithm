package programmers;

import java.util.Arrays;

public class 쿼드압축개수세기 {
    private int[] answer = new int[2];

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 쿼드압축개수세기().solution(new int[][]{
                new int[]{1, 1, 0, 0},
                new int[]{1, 0, 0, 0},
                new int[]{1, 0, 0, 1},
                new int[]{1, 1, 1, 1}
        })));
    }

    public int[] solution(int[][] arr) {
        solution(arr, 0, arr.length - 1, 0, arr.length - 1);
        return answer;
    }

    private void solution(int[][] array, int startY, int endY, int startX, int endX) {
        int number = checkSameNumber(array, startY, endY, startX, endX);

        if (number != -1) {
            answer[number] += 1;
        } else {
            int middleY = (endY + startY) / 2;
            int middleX = (endX + startX) / 2;

            solution(array, startY, middleY, startX, middleX);
            solution(array, startY, middleY, middleX + 1, endX);
            solution(array, middleY + 1, endY, startX, middleX);
            solution(array, middleY + 1, endY, middleX + 1, endX);
        }
    }

    private int checkSameNumber(int[][] array, int startY, int endY, int startX, int endX) {
        int value = array[startY][startX];
        for (int y = startY; y <= endY; y += 1) {
            for (int x = startX; x <= endX; x += 1) {
                if (value != array[y][x]) {
                    return -1;
                }
            }
        }
        return value;
    }
}
