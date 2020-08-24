package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class 카드1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        LinkedList<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++)  q.add(i);

        StringBuilder builder = new StringBuilder();
        while(q.size() != 1){
            builder.append(q.pollFirst()).append(" ");
            int num = q.pollFirst();
            q.add(num);
        }
        builder.append(q.poll());

        System.out.print(builder.toString());
    }
}
