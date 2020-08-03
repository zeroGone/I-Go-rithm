package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
//        System.out.println(new 뉴스클러스터링().solution("AAA+BBB+CC", "AA+BBB+DDF"));
        System.out.println(new 뉴스클러스터링().solution("", ""));
        System.out.println(new 뉴스클러스터링().solution("AAAA12", "aa1+aa2"));

    }

    public int solution(String str1, String str2) {
        List<String> a = makeMultipleSet(str1);
        List<String> b = makeMultipleSet(str2);
        Map<String, Integer> m1 = makeMap(a);
        Map<String, Integer> m2 = makeMap(b);
        List<String> union = makeUnion(m1, m2);
        List<String> inter = makeInter(m1, m2);

        if(inter.size() == 0) return 0;
        else if(union.size() == 0) return 65536;
        else return (int) (((double) inter.size() / union.size()) * 65536);
    }

    private List<String> makeInter(Map<String, Integer> m1, Map<String, Integer> m2) {
        List<String> inter = new ArrayList<>();

        for (String key : m1.keySet()) {
            if (m2.containsKey(key)) {
                int num = Math.min(m1.get(key), m2.get(key));
                for (int i = 0; i < num; i++) {
                    inter.add(key);
                }
            }
        }

        return inter;
    }

    private List<String> makeUnion(Map<String, Integer> m1, Map<String, Integer> m2) {

        List<String> union = new ArrayList<>();

        for (String key : m1.keySet()) {
            int num = m1.get(key);
            if (m2.containsKey(key)) {
                int j = m2.get(key);
                num = Math.max(num, j);
            }

            for (int i = 0; i < num; i++) {
                union.add(key);
            }
        }

        for (String key : m2.keySet()) {
            if (!m1.containsKey(key)) {
                for (int i = 0; i < m2.get(key); i++) {
                    union.add(key);
                }
            }
        }
        return union;
    }

    private Map<String, Integer> makeMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }
        return map;
    }

    private List<String> makeMultipleSet(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        StringBuilder builder = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                builder.append(Character.toUpperCase(c));
                j++;
            } else if (builder.length() != 0) {
                j = 0;
                builder.deleteCharAt(0);
            }
            if (j == 2) {
                list.add(builder.toString());
                builder.deleteCharAt(0);
                j = 1;
            }
            i++;
        }
        return list;
    }
}
