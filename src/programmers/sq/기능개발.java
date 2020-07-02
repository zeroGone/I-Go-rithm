package programmers.sq;

import java.util.Arrays;
import java.util.LinkedList;

public class 기능개발 {
    public static void main(String[] args) {
        int[] a = new int[100];
        for(int i=0; i<a.length; i++) a[i] = i+1;

        System.out.println(Arrays.toString(solution(new int[]{
                93, 30, 55, 95, 98, 92, 88
        }, new int[]{1, 30, 5, 1, 1, 1, 1})));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Deploy> q = new LinkedList<>();
        int temp = 100 - progresses[0];
        int value = temp % speeds[0] > 0 ? temp / speeds[0] + 1 : temp / speeds[0];

        q.add(new Deploy(value));
        for (int i = 1; i < progresses.length; i++) {
            temp = 100 - progresses[i];
            value = temp % speeds[i] > 0 ? temp / speeds[i] + 1 : temp / speeds[i];

            Deploy previous = q.pollLast();
            if(previous.getDay() < value){
                q.add(previous);
                q.add(new Deploy(value));
            }else{
                q.add(new Deploy(previous.getDay(), previous.getNumber()+1));
            }
        }

        int[] answer = new int[q.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = q.poll().getNumber();
        }
        return answer;
    }

    static class Deploy {
        private int day;
        private int number;

        public Deploy(int day) {
            this.number = 1;
            this.day = day;
        }

        public Deploy(int day, int number) {
            this.number = number;
            this.day = day;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public String toString() {
            return "Deploy{" +
                    "day=" + day +
                    ", number=" + number +
                    '}';
        }

        public int getDay() {
            return day;
        }


    }
}
