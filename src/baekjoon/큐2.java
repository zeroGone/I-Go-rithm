package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐2 {
    private static final String PUSH = "push";
    private static final String POP = "pop";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String FRONT = "front";
    private static final String BACK = "back";

    private static final LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            StringBuilder outputBuilder = new StringBuilder();
            for (int number = 1; number <= N; number += 1) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

                String command = stringTokenizer.nextToken();

                switch (command) {
                    case PUSH:
                        push(Integer.parseInt(stringTokenizer.nextToken()));
                        break;
                    case POP:
                        outputBuilder.append(pop()).append("\n");
                        break;
                    case SIZE:
                        outputBuilder.append(size()).append("\n");
                        break;
                    case EMPTY:
                        outputBuilder.append(empty()).append("\n");
                        break;
                    case FRONT:
                        outputBuilder.append(front()).append("\n");
                        break;
                    case BACK:
                        outputBuilder.append(back()).append("\n");
                        break;
                }
            }

            System.out.print(outputBuilder.toString());
        }
    }

    private static void push(int value){
        queue.offer(value);
    }

    private static int pop(){
        if(queue.isEmpty()){
            return -1;
        }else{
            return queue.poll();
        }
    }

    private static int size(){
        return queue.size();
    }

    private static int empty(){
        if(queue.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }

    private static int front(){
        if(queue.isEmpty()){
            return -1;
        }else{
            return queue.peekFirst();
        }
    }

    private static int back(){
        if(queue.isEmpty()){
            return -1;
        }else{
            return queue.peekLast();
        }
    }
}