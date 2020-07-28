package programmers;

import java.util.*;

public class 튜플 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 튜플().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
    }

    public int[] solution(String s) {
        List<Number> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) builder.append(c);
            else if (builder.length() != 0) {
                Number value = new Number(Integer.parseInt(builder.toString()));

                if (list.contains(value)) list.get(list.indexOf(value)).addCount();
                else list.add(value);
                builder.delete(0, builder.length());
            }
        }

        list.sort((Number o1, Number o2) -> -Integer.compare(o1.getCount(), o2.getCount()));

        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) answer[i] = list.get(i).getValue();
        return answer;
    }

    class Number {
        int value;
        int count;

        public Number(int value) {
            this.value = value;
            this.count = 1;
        }

        public void addCount() {
            this.count += 1;
        }

        public int getValue() {
            return value;
        }

        public int getCount() {
            return count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Number number = (Number) o;
            return value == number.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Number{" +
                    "value=" + value +
                    ", count=" + count +
                    '}';
        }
    }
}
