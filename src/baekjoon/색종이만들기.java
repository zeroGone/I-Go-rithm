package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기 {
    private static int[][] papers;
    private static int whitePaperNumber = 0;
    private static int bluePaperNumber = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());
            papers = new int[N][N];
            for (int y = 0; y < N; y += 1) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
                for (int x = 0; x < N; x += 1) {
                    papers[y][x] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            solution(0, N - 1, 0, N - 1);
            System.out.println(whitePaperNumber);
            System.out.print(bluePaperNumber);
        }
    }

    private static void solution(int startY, int endY, int startX, int endX) {
        if (startY > endY || startX > endX) {
            return;
        }
        if (startY == endY && startX == endX) {
            if (papers[startY][startX] == 0) {
                whitePaperNumber += 1;
            } else {
                bluePaperNumber += 1;
            }
            return;
        }

        int isColorPaper = isColorPaper(startY, endY, startX, endX);

        if (isColorPaper == 0) {
            whitePaperNumber += 1;
        } else if (isColorPaper == 1) {
            bluePaperNumber += 1;
        } else {
            int middleY = (startY + endY) / 2;
            int middleX = (startX + endX) / 2;
            solution(startY, middleY, startX, middleX);
            solution(startY, middleY, middleX + 1, endX);
            solution(middleY + 1, endY, startX, middleX);
            solution(middleY + 1, endY, middleX + 1, endX);
        }
    }

    private static int isColorPaper(int startY, int endY, int startX, int endX) {
        int previousPaper = -1;
        for (int y = startY; y <= endY; y += 1) {
            for (int x = startX; x <= endX; x += 1) {
                if (previousPaper == -1) {
                    previousPaper = papers[y][x];
                } else if (previousPaper != papers[y][x]) {
                    return -1;
                }
            }
        }
        if (papers[startY][startX] == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
