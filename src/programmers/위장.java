package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;


public class 위장 {
    public static void main(String[] args) {
        String[][] str = new String[30][2];
        for(int i=0; i<30; i++){
            str[i][0] = "";
            str[i][1] = Integer.toString(i);
        }
        System.out.println(solution(str));
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String cloth = clothes[i][1];
            if (map.containsKey(cloth)) map.put(cloth, map.get(cloth) + 1);
            else map.put(cloth, 1);
        }

        Iterator<String> iterator = map.keySet().iterator();
        int answer = 1;
        while(iterator.hasNext())
            answer *= map.get(iterator.next()) + 1;
        return answer - 1;
    }
}
