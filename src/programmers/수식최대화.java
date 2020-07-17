package programmers;

import java.util.*;

public class 수식최대화 {
    public static void main(String[] args) {
        수식최대화 main = new 수식최대화();
        System.out.println(main.solution("100-200*300-500+20"));
    }

    final List<Long> numbers = new ArrayList<>();
    final List<Character> operators = new ArrayList<>();

    public long solution(String expression) {
        String[] strings = new String[]{
                "*+-",
                "*-+",
                "+*-",
                "+-*",
                "-*+",
                "-+*",
        };

        converToList(expression);

        long answer = 0;

        for(String s : strings){
            LinkedList<Long> numQueue = new LinkedList<>(numbers);
            LinkedList<Character> operQueue = new LinkedList<>(operators);

            for(int i=0; i<s.length();i++){
                char operator = s.charAt(i);

                List<Long> num = new ArrayList<>();
                List<Character> temp = new ArrayList<>();
                while(!operQueue.isEmpty()){
                    char c = operQueue.pollFirst();
                    if(c != operator){
                        num.add(numQueue.poll());
                        temp.add(c);
                    }else{
                        if(operator == '-' ) numQueue.addFirst(numQueue.pollFirst() - numQueue.pollFirst());
                        else if( operator == '+') numQueue.addFirst(numQueue.pollFirst() + numQueue.pollFirst());
                        else numQueue.addFirst(numQueue.pollFirst() * numQueue.pollFirst());
                    }
                }
                num.add(numQueue.poll());

                numQueue.addAll(num);
                operQueue.addAll(temp);
            }

            long n = Math.abs(numQueue.poll());
            if (answer < n) answer = n;
        }

        return answer;
    }

    public void converToList(String string){

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<string.length(); i++){
            char c = string.charAt(i);

            if(Character.isDigit(c)){
                builder.append(c);
            }else{
                operators.add(c);
                numbers.add(Long.parseLong(builder.toString()));
                builder.delete(0, builder.length());
            }
        }
        numbers.add(Long.parseLong(builder.toString()));
    }
}
