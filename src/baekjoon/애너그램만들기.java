package baekjoon;

import java.util.*;

public class 애너그램만들기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        Map<Character, Integer> map1 = makeMap(str1);
        Map<Character, Integer> map2 = makeMap(str2);

        int sum1 = calculate(map1, map2);
        int sum2 = calculate(map2, map1);

        System.out.print(str1.length() + str2.length() - sum1 - sum2);
    }

    private static int calculate(Map<Character, Integer> map1, Map<Character, Integer> map2){
        int sum =0;
        for(char c : map1.keySet()){
            if(map2.containsKey(c)){
                sum += Math.min(map1.get(c), map2.get(c));
            }
        }
        return sum;
    }

    private static Map<Character, Integer> makeMap(String str){
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        return map;
    }
}
