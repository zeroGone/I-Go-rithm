package programmers;

import java.util.*;

public class 순위검색 {
    private final Map<String, List<Integer>> scoreMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String applicant : info) {
            insert(applicant);
        }

        for (String keyword : scoreMap.keySet()) {
            Collections.sort(scoreMap.get(keyword));
        }

        int[] answer = new int[query.length];

        for (int index = 0; index < answer.length; index += 1) {
            answer[index] = solution(query[index].split(" "));
        }

        return answer;
    }

    private int solution(String[] query) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index <= 6; index += 2) {
            if (!query[index].equals("-")) {
                stringBuilder.append(query[index]);
            }
        }
        String keyword = stringBuilder.toString();

        if (!scoreMap.containsKey(keyword)) {
            return 0;
        }

        int score = Integer.parseInt(query[7]);
        List<Integer> scores = scoreMap.get(keyword);

        int start = 0;
        int end = scores.size();
        while (start < end) {
            int middle = (start + end) / 2;

            if (scores.get(middle) < score) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return scores.size() - start;
    }

    private void insert(String info) {
        String[] strings = info.split(" ");

        int score = Integer.parseInt(strings[4]);
        insert(score, strings[0] + strings[1] + strings[2] + strings[3]);
        insert(score, strings[1] + strings[2] + strings[3]);
        insert(score, strings[0] + strings[2] + strings[3]);
        insert(score, strings[0] + strings[1] + strings[3]);
        insert(score, strings[0] + strings[1] + strings[2]);
        insert(score, strings[2] + strings[3]);
        insert(score, strings[1] + strings[3]);
        insert(score, strings[1] + strings[2]);
        insert(score, strings[0] + strings[3]);
        insert(score, strings[0] + strings[2]);
        insert(score, strings[0] + strings[1]);
        insert(score, strings[3]);
        insert(score, strings[2]);
        insert(score, strings[1]);
        insert(score, strings[0]);
        insert(score, "");
    }

    private void insert(int score, String keyword) {
        if (!scoreMap.containsKey(keyword)) {
            scoreMap.put(keyword, new ArrayList<>());
        }
        scoreMap.get(keyword).add(score);
    }
}