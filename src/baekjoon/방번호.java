package baekjoon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class 방번호 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        Map<Integer, Integer> set = new HashMap<>();
        for(int i=0; i<10; i++) set.put(i, 0);
        for(int i=0; i<num.length(); i++){
            int value = num.charAt(i) - 48;
            if(value == 9 && set.get(9) > set.get(6)) set.put(6, set.get(6)+1);
            else set.put(value, set.get(value)+1);
        }

        int output = 0;
        Iterator<Integer> iterator = set.keySet().iterator();
        while(iterator.hasNext()){
            int value = iterator.next();
            value = set.get(value);
            if(output < value) output = value;
        }

        System.out.print(output);
    }
}
