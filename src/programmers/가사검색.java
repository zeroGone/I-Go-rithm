package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 가사검색 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 가사검색().solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"})));

        System.out.println(Arrays.toString(new 가사검색().solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"k????", "ka???", "kak??", "kaka?", "kakao", "????o", "???ao", "??kao", "?akao"})));
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Node head = new Node();
        Node tail = new Node();

        for (String word : words) {
            tail.insert(Integer.toString(word.length())).addNum();

            Node node = head;
            Node node2 = tail;
            for (int i = 0; i < word.length(); i++) {
                String num = Integer.toString(word.length() -1 - i);

                String c = Character.toString(word.charAt(i));
                node = node.insert(c);
                node.insert(num).addNum();

                c = Character.toString(word.charAt(word.length() - 1 - i));
                node2 = node2.insert(c);
                node2.insert(num).addNum();
            }
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            int index = 0;
            boolean check = true;
            if (query.charAt(0) == '?') {
                index = query.length() - 1;
                check = false;
            }

            Node node = check? head : tail;
            while (index < query.length() && index >= 0) {
                String c = Character.toString(query.charAt(index));

                if(c.equals("?")){
                    int num = check ? query.length() - index : index+1;
                    Node temp = node.getChild(Integer.toString(num));
                    answer[i] = temp == null? 0 : temp.getNum();
                    node = null;
                    break;
                }

                if(node.getChild(c) == null){
                    node = null;
                    break;
                }

                node = node.getChild(c);
                index = check ? index + 1 : index - 1;
            }

            if(node != null) answer[i] = node.getNum();
        }
        return answer;
    }

    class Node {
        Map<String, Node> child;
        int num;

        public Node() {
            this.child = new HashMap<>();
        }

        public void addNum() {
            this.num++;
        }

        public int getNum() {
            return this.num;
        }

        public Node insert(String str) {
            if (!this.child.containsKey(str)) this.child.put(str, new Node());
            return this.child.get(str);
        }

        public Node getChild(String str) {
            return this.child.get(str);
        }
    }
}
