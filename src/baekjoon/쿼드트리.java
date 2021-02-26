package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());
            char[][] video = new char[N][N];

            for (int y = 0; y < N; y += 1) {
                String value = reader.readLine();
                for (int x = 0; x < N; x += 1) {
                    video[y][x] = value.charAt(x);
                }
            }
            System.out.print(solution(video, 0, N - 1, 0, N - 1));
        }
    }

    private static String solution(char[][] video, int startY, int endY, int startX, int endX) {
        if (hasSameValue(video, startY, endY, startX, endX)) {
            return Character.toString(video[startY][startX]);
        }

        int middleY = (endY + startY) / 2;
        int middleX = (endX + startX) / 2;

        StringBuilder stringBuilder = new StringBuilder("(");
        stringBuilder.append(solution(video, startY, middleY, startX, middleX));
        stringBuilder.append(solution(video, startY, middleY, middleX + 1, endX));
        stringBuilder.append(solution(video, middleY + 1, endY, startX, middleX));
        stringBuilder.append(solution(video, middleY + 1, endY, middleX + 1, endX));

        return stringBuilder.append(")").toString();
    }

    private static boolean hasSameValue(char[][] video, int startY, int endY, int startX, int endX) {
        char pre = video[startY][startX];
        for (int y = startY; y <= endY; y += 1) {
            for (int x = startX; x <= endX; x += 1) {
                if (pre != video[y][x]) {
                    return false;
                }
            }
        }
        return true;
    }
}
