package programmers;

public class 정수삼각형 {
    public static void main(String[] args) {
        System.out.println(new 정수삼각형().solution(new int[][]{
                {7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
        }));
    }

    public int solution(int[][] triangle) {
        int[][] num = new int[triangle.length][];
        for(int i=0; i<triangle.length-1; i++) num[i] = new int[triangle[i].length];
        num[triangle.length-1] = triangle[triangle.length-1];

        return dp(num, triangle, triangle.length-1);
    }

    private int dp(int[][] top, int[][] triangle, int index){
        if(index == 1){
            return Math.max(top[index][0], top[index][1]) + triangle[0][0];
        }

        for(int i = 0; i<triangle[index].length-1; i++){
            top[index-1][i] = Math.max(top[index][i], top[index][i+1]) + triangle[index-1][i];
        }

        return dp(top, triangle, index-1);
    }
}
