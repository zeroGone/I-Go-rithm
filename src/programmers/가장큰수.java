package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 가장큰수 {

    public static void main(String[] args) {
        System.out.println(new 가장큰수().solution(new int[]{
                3, 30, 34, 5, 9
        }));

        System.out.println(new 가장큰수().solution(new int[]{
                0,0,0,0
        }));
    }
    public String solution(int[] numbers) {
        List<Integer> list = Arrays.stream(numbers).boxed().sorted((o1, o2) -> {
            String s1 = Integer.toString(o1);
            String s2 = Integer.toString(o2);

            int n1 = Integer.parseInt(s1 + s2);
            int n2 = Integer.parseInt(s2 + s1);

            return Integer.compare(n2, n1);
        }).collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<list.size(); i++) {
            builder.append(list.get(i));
        }

        return builder.toString().charAt(0) == '0' ? "0": builder.toString();
    }
}
