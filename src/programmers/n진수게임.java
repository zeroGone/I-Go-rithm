package programmers;

public class n진수게임 {
    public static void main(String[] args) {
        System.out.println(new n진수게임().solution(10, 16, 3, 2));
    }

    String[] strings = new String[]{
            "A","B","C","D","E","F"
    };

    public String solution(int n, int t, int m, int p) {
        StringBuilder builder = new StringBuilder();
        builder.append(0);
        for (int i = 1; i <= t*m; i++) {
            builder.append(conversion(n, i));
        }
        String s = builder.toString();
        builder.delete(0, builder.length());

        for(int i=0; i<t; i++){
            System.out.println(p);
            builder.append(s.charAt(p-1));
            p+=m;
        }
        return builder.toString();
    }

    private String conversion(int n, int value) {
        StringBuilder builder = new StringBuilder();
        while (value != 0) {
            builder.insert(0, value % n >= 10 ? strings[value % n - 10] : value % n);
            value /= n;
        }
        return builder.toString();
    }
}
