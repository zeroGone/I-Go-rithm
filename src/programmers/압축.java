package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 압축 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 압축().solution("KAKAO")));
        System.out.println(Arrays.toString(new 압축().solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(new 압축().solution("ABABABABABABABAB")));
//        System.out.println(Arrays.toString(new 압축().solution("THATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITIS")));

    }

    public int[] solution(String msg) {
        List<String> dictionary = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.add(Character.toString(c));
        }

        int index = 0;
        while (index < msg.length()) {
            StringBuilder builder = new StringBuilder();
            builder.append(msg.charAt(index));
            int j = index + 1;
            while (j < msg.length()) {
                builder.append(msg.charAt(j));
                if (!dictionary.contains(builder.toString())) {
                    dictionary.add(builder.toString());
                    break;
                }
                j++;
            }

            if (index != msg.length() - 1 && j < msg.length()) {
                builder.deleteCharAt(builder.length() - 1);
            }
            list.add(dictionary.indexOf(builder.toString()) + 1);
            index += builder.length();
        }

        System.out.println(Arrays.toString(dictionary.toArray()));
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
