package programmers;

import java.util.*;

public class 섬연결하기 {
    public static void main(String[] args) throws java.lang.Exception {
        System.out.println(new 섬연결하기().solution(5, new int[][]{
                {0, 1, 1}, {0, 4, 5}, {2, 4, 1}, {2, 3, 1}, {3, 4, 1}
        }));
//
//        System.out.println(new 섬연결하기().solution(4, new int[][]{
//                {0, 1, 1}, {1, 2, 4}, {1, 3, 5}, {2, 3, 2}
//        }));

    }

    public int solution(int n, int[][] costs) {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Set<Integer>> setOfEgde = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            setOfEgde.put(i, set);
        }

        Arrays.sort(costs, (o1, o2) -> {
            if (o1[2] <= o2[2]) return -1;
            else return 1;
        });

        int index = 0;

        while(list.size() < n-1){
            int[] cost = costs[index++];

            Set<Integer> set1 = setOfEgde.get(cost[0]);
            Set<Integer> set2 = setOfEgde.get(cost[1]);

            if(set1 != set2){
                for(int edge : set2){
                    setOfEgde.put(edge, set1);
                }
                set1.addAll(set2);

                list.add(cost[2]);
            }
        }

        int answer = 0;

        for(int num : list){
            answer += num;
        }

        return answer;
    }
}
