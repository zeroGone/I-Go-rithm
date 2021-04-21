package programmers;

public class 이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (s.length() > 1) {
            StringBuilder builder = new StringBuilder();
            for (char character : s.toCharArray()) {
                if (character == '0') {
                    answer[1] += 1;
                } else {
                    builder.append(character);
                }
            }

            int size = builder.length();
            builder.delete(0, builder.length());

            while (size > 0) {
                builder.insert(0, size % 2);
                size = size / 2;
            }

            s = builder.toString();
            answer[0] += 1;
        }

        return answer;
    }
}
