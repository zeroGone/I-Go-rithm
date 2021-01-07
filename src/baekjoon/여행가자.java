package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 여행가자 {
    private static List<Set<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());
            int M = Integer.parseInt(reader.readLine());

            for (int number = 0; number < N; number += 1) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

                Set<Integer> city = new HashSet<>();
                for (int cityNumber = 1; cityNumber <= N; cityNumber += 1) {
                    int isLinked = Integer.parseInt(stringTokenizer.nextToken());

                    if (isLinked == 1) {
                        city.add(cityNumber);
                    }
                }
                map.add(city);
            }

            int[] destinations = new int[M];
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for (int number = 0; number < M; number += 1) {
                destinations[number] = Integer.parseInt(stringTokenizer.nextToken());
            }

            if (solution(destinations)) {
                System.out.print("YES");
            } else {
                System.out.print("NO");
            }
        }
    }

    private static boolean solution(int[] destinations) {
        int destination = 0;
        Set<Integer> nexts = new HashSet<>();
        nexts.add(destinations[destination++]);

        int loopNumber = 1;
        while (loopNumber < 200 && destination < destinations.length) {
            List<Integer> nextVisits = new ArrayList<>(nexts);

            for (int next : nextVisits) {
                Set<Integer> cities = map.get(next - 1);
                nexts.addAll(cities);
            }

            if (nexts.contains(destinations[destination])) {
                loopNumber = 1;
                nexts.clear();
                nexts.add(destinations[destination++]);
            } else {
                loopNumber += 1;
            }
        }

        return destination == destinations.length;
    }
}