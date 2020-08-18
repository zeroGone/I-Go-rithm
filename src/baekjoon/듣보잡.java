package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");

        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N+M; i++){
            String k = reader.readLine();
            if(map.containsKey(k)) map.put(k, map.get(k)+1);
            else map.put(k, 1);
        }

        List<String> list = new ArrayList<>();
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String k = iterator.next();
            int n = map.get(k);
            if(n > 1) list.add(k);
        }

        Collections.sort(list);
        StringBuilder builder = new StringBuilder(list.size()+"\n");
        for(String s : list) builder.append(s).append("\n");
        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }
}

