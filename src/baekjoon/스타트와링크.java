package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스타트와링크 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            int[][] synergy = new int[N][N];
            for (int y = 0; y < N; y += 1) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
                for (int x = 0; x < N; x += 1) {
                    synergy[y][x] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            System.out.print(solution(synergy, new boolean[N], N / 2, 0));
        }
    }

    private static int solution(int[][] synergy, boolean[] isStartTeam, int startTeamMemberNumber, int startIndex) {
        if (startTeamMemberNumber == 0) {
            List<Integer> startTeam = new ArrayList<>();
            List<Integer> linkTeam = new ArrayList<>();
            for (int index = 0; index < isStartTeam.length; index += 1) {
                if (isStartTeam[index]) {
                    startTeam.add(index);
                } else {
                    linkTeam.add(index);
                }
            }
            return Math.abs(getSynergySum(synergy, startTeam) - getSynergySum(synergy, linkTeam));
        }

        int minValue = Integer.MAX_VALUE;
        for (int index = startIndex; index < isStartTeam.length; index += 1) {
            if (!isStartTeam[index]) {
                isStartTeam[index] = true;
                minValue = Math.min(minValue, solution(synergy, isStartTeam, startTeamMemberNumber - 1, index));
                isStartTeam[index] = false;
            }
        }
        return minValue;
    }

    private static int getSynergySum(int[][] synergy, List<Integer> team) {
        int sum = 0;
        for (int index = 0; index < team.size(); index += 1) {
            for (int subIndex = index + 1; subIndex < team.size(); subIndex += 1) {
                sum += synergy[team.get(index)][team.get(subIndex)];
                sum += synergy[team.get(subIndex)][team.get(index)];
            }
        }
        return sum;
    }
}
