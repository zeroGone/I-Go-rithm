package programmers;

public class 등굣길 {
    public static void main(String[] args) {
        System.out.println(new 등굣길().solution(4, 3, new int[][]{{2, 2}}));
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];

        for (int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        return dp(map, n - 1, m - 1)% 1000000007;
    }

    private int dp(int[][] map, int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }

        if (map[x][y] == -1) {
            return 0;
        }

        if (map[x][y] != 0) {
            return map[x][y] % 1000000007;
        }

        if (x - 1 >= 0) {
            map[x][y] += dp(map, x - 1, y)% 1000000007;
        }

        if (y - 1 >= 0) {
            map[x][y] += dp(map, x, y - 1) % 1000000007;
        }

        return map[x][y]% 1000000007;
    }
}
