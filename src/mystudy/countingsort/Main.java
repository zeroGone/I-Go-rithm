package mystudy.countingsort;

import java.util.*;
/*
* 값들의 개수를 셀 때 주로 쓰임. 값의 종류가 많아질 수록 비효율적
* */
public class Main {
    public static void main(String[] args) {
        System.out.println(countingSort("hello world. good morning. how are you."));
    }

    private static String countingSort(String s){
        Map<Character, Integer> map = new TreeMap<>();
        for(char c : s.toCharArray()){
            int num = 0;
            if(map.containsKey(c)) num = map.get(c);
            map.put(c, num+1);
        }

        StringBuilder builder = new StringBuilder();
        for(char c : map.keySet()){
            int num = map.get(c);
            for(int i=0; i<num; i++) builder.append(c);
        }
        return builder.toString();
    }
}
