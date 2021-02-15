package programmers;

import java.util.*;

public class 메뉴리뉴얼 {
    private static Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            for (int courseCase : course) {
                combination(order, new boolean[order.length()], 0, courseCase);
            }
        }

        Map<Integer, List<String>> menuMap = new HashMap<>();
        for (int courseCase : course) {
            menuMap.put(courseCase, new ArrayList<>());
        }

        for (String menu : map.keySet()) {
            int orderNumber = map.get(menu);

            if (orderNumber >= 2) {
                List<String> menus = menuMap.get(menu.length());

                if (menus.isEmpty() || map.get(menus.get(0)) == map.get(menu)) {
                    menus.add(menu);
                    continue;
                }
                if (map.get(menus.get(0)) < map.get(menu)) {
                    menus.clear();
                    menus.add(menu);
                }
            }
        }

        List<String> answerMenus = new ArrayList<>();
        for (int courseCase : course) {
            for (String menu : menuMap.get(courseCase)) {
                answerMenus.add(menu);
            }
        }
        Collections.sort(answerMenus);

        String[] answer = new String[answerMenus.size()];
        for (int index = 0; index < answer.length; index += 1) {
            answer[index] = answerMenus.get(index);
        }

        return answer;
    }

    private void insert(String string) {
        if (!map.containsKey(string)) {
            map.put(string, 0);
        }
        map.put(string, map.get(string) + 1);
    }

    private void combination(String string, boolean[] value, int start, int number) {
        if (number == 0) {
            insert(makeString(string, value));
            return;
        }

        for (int index = start; index < value.length; index += 1) {
            if (!value[index]) {
                value[index] = true;
                combination(string, value, index + 1, number - 1);
                value[index] = false;
            }
        }
    }

    private String makeString(String string, boolean[] value) {
        List<Character> characters = new ArrayList<>();
        for (int index = 0; index < value.length; index += 1) {
            if (value[index]) {
                characters.add(string.charAt(index));
            }
        }
        Collections.sort(characters);

        StringBuilder builder = new StringBuilder();
        for (char character : characters) {
            builder.append(character);
        }
        return builder.toString();
    }
}
