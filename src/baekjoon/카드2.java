package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class 카드2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        LinkedList<Integer> q = new LinkedList<>();

        for(int i=1; i<=input; i++){
            q.add(i);
        }

        while(q.size() != 1){
            q.pollFirst();
            int n = q.pollFirst();
            q.add(n);
        }

        System.out.println(q.poll());
    }
}
