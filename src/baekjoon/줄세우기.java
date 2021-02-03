package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 줄세우기 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            Map<Integer, List<Integer>> students = new HashMap<>();
            for (int number = 1; number <= N; number += 1) {
                students.put(number, new ArrayList<>());
            }

            for (int number = 1; number <= M; number += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());

                int A = Integer.parseInt(stringTokenizer.nextToken());
                int B = Integer.parseInt(stringTokenizer.nextToken());

                students.get(B).add(A);
            }

            boolean[] visit = new boolean[N + 1];
            StringBuilder stringBuilder = new StringBuilder();

            for (int number = 1; number <= N; number += 1) {
                if (visit[number]) {
                    continue;
                }
                solution(students, number, visit, stringBuilder);
            }

            System.out.print(stringBuilder.deleteCharAt(0).toString());
        }
    }

    private static void solution(Map<Integer, List<Integer>> students, int student, boolean[] visit, StringBuilder answer) {
        visit[student] = true;

        for (int smaller : students.get(student)) {
            if (!visit[smaller]) {
                solution(students, smaller, visit, answer);
            }
        }

        answer.append(" ").append(student);
    }
}
