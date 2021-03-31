package programmers;

import java.util.ArrayList;
import java.util.List;

public class 게임맵최단거리 {
    public int solution(int[][] maps) {
        int answer = 0;

        boolean[][] visit = new boolean[maps.length][maps[0].length];
        visit[0][0] = true;

        List<int[]> nextPositions = new ArrayList<>();
        nextPositions.add(new int[]{0, 0});

        boolean hasSuccess = false;

        bfs:
        while (!nextPositions.isEmpty()) {
            answer += 1;

            List<int[]> nowPositions = new ArrayList<>(nextPositions);
            nextPositions.clear();

            for (int[] nowPosition : nowPositions) {
                int y = nowPosition[0];
                int x = nowPosition[1];

                if (y == maps.length - 1 && x == maps[y].length - 1) {
                    hasSuccess = true;
                    break bfs;
                }

                if (y + 1 < maps.length && maps[y + 1][x] == 1 && !visit[y + 1][x]) {
                    visit[y + 1][x] = true;
                    nextPositions.add(new int[]{y + 1, x});
                }
                if (y - 1 >= 0 && maps[y - 1][x] == 1 && !visit[y - 1][x]) {
                    visit[y - 1][x] = true;
                    nextPositions.add(new int[]{y - 1, x});
                }
                if (x + 1 < maps[y].length && maps[y][x + 1] == 1 && !visit[y][x + 1]) {
                    visit[y][x + 1] = true;
                    nextPositions.add(new int[]{y, x + 1});
                }
                if (x - 1 >= 0 && maps[y][x - 1] == 1 && !visit[y][x - 1]) {
                    visit[y][x - 1] = true;
                    nextPositions.add(new int[]{y, x - 1});
                }
            }
        }

        if (hasSuccess) {
            return answer;
        } else {
            return -1;
        }
    }
}
