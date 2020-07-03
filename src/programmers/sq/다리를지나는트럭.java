package programmers.sq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        LinkedList<Truck> finish = new LinkedList<>();
        LinkedList<Truck> crossing = new LinkedList<>();
        int sum = 0;
        int index = 0;
        while(finish.size() < truck_weights.length){
            for(int i=0; i<crossing.size(); i++) {
                Truck truck = crossing.get(i);
                if(truck.getTime() == bridge_length) {
                    sum -= truck.getWeight();
                    crossing.poll();
                    finish.add(truck);
                }
            }

            if(index < truck_weights.length
                    && sum + truck_weights[index] <= weight){
                sum += truck_weights[index];
                crossing.add(new Truck(truck_weights[index]));
                index++;
            }

            for(Truck truck : crossing){
                truck.setTime();
            }

            answer++;
        }

        return answer;
    }

    static class Truck {
        int time;
        int weight;

        public Truck(int weight) {
            this.time = 0;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public int getTime() {
            return time;
        }

        public void setTime() {
            this.time++;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "time=" + time +
                    ", weight=" + weight +
                    '}';
        }
    }
}
