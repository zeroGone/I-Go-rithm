package programmers;

import java.util.*;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int choose = nums.length/2;
        Set<Integer> set = new HashSet<>();

        for(int i:nums){
            set.add(i);
        }

        if(set.size() > choose) return choose;
        else return set.size();
    }
}
