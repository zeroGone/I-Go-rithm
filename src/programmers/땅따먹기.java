package programmers;

public class 땅따먹기 {
    public static void main(String[] args) {
        System.out.println(new 땅따먹기().solution(new int[][]{
                {1,2,3,5},
                {5,6,7,8},
                {4,3,2,1}
        }));
    }
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int z = 0; z < 4; z++) {
                    if (j != z && max < land[i-1][z]) {
                        max = land[i-1][z];
                    }
                }
                land[i][j] = land[i][j]+max;
            }
        }
        int answer = 0;
        for(int i=0; i<4; i++){
            if(answer<land[land.length-1][i]) answer = land[land.length-1][i];
        }
        return answer;
    }
}
