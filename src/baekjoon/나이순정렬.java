package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        Member[] members = new Member[N];

        for (int i = 0; i < N; i++) {
            String[] temp = reader.readLine().split(" ");
            members[i] = new Member(Integer.parseInt(temp[0]), temp[1]);
        }

        Arrays.sort(members);

        StringBuilder builder = new StringBuilder();
        for (Member m : members) {
            builder.append(m);
            builder.append('\n');
        }
        System.out.println(builder.toString());
    }

    static class Member implements Comparable<Member> {
        int age;
        String name;

        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            return this.age-o.age;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
