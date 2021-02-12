package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 촌수계산 {
    private static Map<Integer, Set<Integer>> childs = new HashMap<>();
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            parents = new int[n + 1];

            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int target1 = Integer.parseInt(stringTokenizer.nextToken());
            int target2 = Integer.parseInt(stringTokenizer.nextToken());

            int m = Integer.parseInt(reader.readLine());
            for (int number = 1; number <= m; number += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());

                addChild(x, y);
                setParent(x, y);
            }

            System.out.print(solution(n, target1, target2));
        }
    }

    private static int solution(int n, int start, int target) {
        Set<Integer> searchList = new HashSet<>();
        searchList.add(start);
        return search(searchList, new boolean[n + 1], 0, target);
    }

    private static int search(Set<Integer> searchList, boolean[] visit, int number, int target) {
        Set<Integer> nextSearchList = new HashSet<>();
        for (int value : searchList) {
            if (target == value) {
                return number;
            }
            if (!visit[value]) {
                visit[value] = true;

                if (parents[value] != 0) {
                    nextSearchList.add(parents[value]);
                }
                if (childs.containsKey(value)) {
                    nextSearchList.addAll(childs.get(value));
                }
            }
        }

        if (nextSearchList.isEmpty()) {
            return -1;
        } else {
            return search(nextSearchList, visit, number + 1, target);
        }
    }

    private static void addChild(int parent, int child) {
        if (!childs.containsKey(parent)) {
            childs.put(parent, new HashSet<>());
        }
        childs.get(parent).add(child);
    }

    private static void setParent(int parent, int child) {
        parents[child] = parent;
    }
}