package programmers;

import java.util.Arrays;

public class 삼각달팽이 {
    public static void main(String[] args) {
        new 삼각달팽이().solution(5);
    }

    public int[] solution(int n) {
        int[][] map = new int[n][n];

        int sum = 0;
        for (; n > 0; n--) sum += n;

        int x = 0;
        int y = 0;
        boolean down = true;
        map[0][0] = 1;
        for (int i = 2; i <= sum; i++) {
            if (down) {
                if (x + 1 == map.length || map[x + 1][y] != 0) {
                    if (y + 1 == map.length || map[x][y + 1] != 0){
                        x--;
                        y--;
                        down = false;
                    }else y++;
                } else x++;
            } else {
                if (map[x-1][y-1] == 0) {
                    x--;
                    y--;
                } else{
                    x++;
                    down = true;
                }
            }

            map[x][y] = i;

        }

        int[] answer = new int[sum];
        int index = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                if(map[i][j] != 0){
                    answer[index] = map[i][j];
                    index++;
                }
            }
        }
        return answer;
    }

}
