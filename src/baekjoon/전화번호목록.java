package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        StringBuilder outputBuilder = new StringBuilder();

        for (int taseCase = 0; taseCase < t; taseCase++) {
            int n = Integer.parseInt(reader.readLine());

            String[] numbers = new String[n];

            for (int indexOfNumber = 0; indexOfNumber < n; indexOfNumber++) {
                numbers[indexOfNumber] = reader.readLine();
            }

            Number listOfNumbers = new Number();

            boolean checkForLoop = true;

            loopOfNumber:
            for (int indexOfNumber = 0; indexOfNumber < n; indexOfNumber++) {
                String stringOfNumber = numbers[indexOfNumber];

                int indexOfString = 0;

                Number number = listOfNumbers;

                while (indexOfString < stringOfNumber.length() - 1) {
                    char element = stringOfNumber.charAt(indexOfString++);

                    if(number.hasNextNumber(element) && number.getNextNumber(element).isLast()){
                        outputBuilder.append("NO").append("\n");
                        checkForLoop = false;
                        break loopOfNumber;
                    }

                    number.addNextNumber(element);
                    number = number.getNextNumber(element);
                }

                char lastElement = stringOfNumber.charAt(indexOfString);

                if(number.hasNextNumber(lastElement)){
                    outputBuilder.append("NO").append("\n");
                    checkForLoop = false;
                    break;
                }else{
                    number.addNextNumber(lastElement);
                }
            }

            if (checkForLoop){
                outputBuilder.append("YES").append("\n");
            }
        }

        System.out.print(outputBuilder.deleteCharAt(outputBuilder.length()-1).toString());
    }

    static class Number {
        private final Map<Character, Number> nextNumber;
        private boolean isLast;

        public Number() {
            this.nextNumber = new HashMap<>();
            this.isLast = true;
        }

        public void addNextNumber(char number) {
            if (!this.nextNumber.containsKey(number)) {
                this.nextNumber.put(number, new Number());
                this.isLast = false;
            }
        }

        public Number getNextNumber(char number) {
            return this.nextNumber.get(number);
        }

        public boolean hasNextNumber(char number){
            return this.nextNumber.containsKey(number);
        }

        public boolean isLast() {
            return this.isLast;
        }
    }
}

