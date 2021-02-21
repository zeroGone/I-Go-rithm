package programmers;

import java.util.*;

public class 보석쇼핑 {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(new 보석쇼핑().solution(new String[]{
                "A", "B", "B", "C", "A", "B", "C"
        })));
    }

    public int[] solution(String[] gems) {
        Map<String, Integer> gemNumberMap = new HashMap<>();
        Queue<String> gemQueue = new LinkedList<>();

        Set<String> gemSet = new HashSet<>();
        Collections.addAll(gemSet, gems);

        int gemTypeNumber = gemSet.size();

        int index = 0;
        while (index < gems.length && gemNumberMap.keySet().size() < gemTypeNumber) {
            if (gemNumberMap.containsKey(gems[index])) {
                gemNumberMap.put(gems[index], gemNumberMap.get(gems[index]) + 1);
            } else {
                gemNumberMap.put(gems[index], 1);
            }
            gemQueue.offer(gems[index]);
            index += 1;
        }

        int[] answer = new int[]{1, index};

        int start = 1;
        int end = index;
        while (end < gems.length) {
            if (end - start < answer[1] - answer[0]) {
                answer = new int[]{start, end};
            }

            String head = gemQueue.peek();
            if (gemNumberMap.get(head) > 1) {
                gemNumberMap.put(head, gemNumberMap.get(head) - 1);
                gemQueue.poll();
                start += 1;
                continue;
            }

            String nextGem = gems[end];
            gemNumberMap.put(nextGem, gemNumberMap.get(nextGem) + 1);
            gemQueue.offer(nextGem);
            end += 1;
        }

        while (gemNumberMap.get(gemQueue.peek()) > 1) {
            gemNumberMap.put(gemQueue.peek(), gemNumberMap.get(gemQueue.peek()) - 1);
            gemQueue.poll();
            start += 1;

            if (end - start < answer[1] - answer[0]) {
                answer = new int[]{start, end};
            }
        }

        return answer;
    }
}
