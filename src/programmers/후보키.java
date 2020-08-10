package programmers;

import java.util.ArrayList;
import java.util.List;

public class 후보키 {

    int answer = 0;
    List<String> check = new ArrayList<>();

    public int solution(String[][] relation) {
        int total = relation[0].length;

        for (int i = 1; i <= total; i++) {
            combi(relation, new boolean[total], 0, i);
        }

        return answer;
    }

    private boolean keyContains(String key) {
        for (String s : check) {
            boolean[] check = new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                for (int j = 0; j < key.length(); j++) {
                    if (c == key.charAt(j)) check[i] = true;
                }
            }

            boolean c = true;
            for(int i=0; i< check.length; i++){
                if(!check[i]) c = false;
            }

            if(c) return true;
        }

        return false;
    }

    public void combi(String[][] relation, boolean[] visit, int start, int depth) {
        if (depth == 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    builder.append(i);
                }
            }

            if (keyContains(builder.toString())) return;
            builder.delete(0, builder.length());
            if (candidate(relation, visit)) {
                answer++;
                for (int i = 0; i < visit.length; i++) {
                    if (visit[i]) {
                        builder.append(i);
                    }
                }
                check.add(builder.toString());
            }
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            visit[i] = true;
            combi(relation, visit, i + 1, depth - 1);
            visit[i] = false;
        }
    }

    private boolean candidate(String[][] relation, boolean[] visit) {
        List<String> list = new ArrayList<>();
        for (String[] strings : relation) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < visit.length; j++) {
                if (visit[j]) builder.append(strings[j]).append(" ");
            }
            String key = builder.toString();
            if (list.contains(key)) return false;
            list.add(key);
        }
        return true;
    }
}
