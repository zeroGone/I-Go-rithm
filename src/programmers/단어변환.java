package programmers;

import java.util.*;

public class 단어변환 {
    public static void main(String[] args) {
        System.out.println(new 단어변환().solution("hit", "cog", new String[]{
                "hot", "dot", "dog", "lot", "log", "cog"
        }));
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Node head = new Node(begin);
        makeTree(new ArrayList<>(), head, words);

        LinkedList<Node> q = new LinkedList<>();
        q.add(head);

        boolean check = false;
        bfs:
        while(true){
            if(q.isEmpty()) break;
            List<Node> list = new ArrayList<>();
            while(!q.isEmpty()){
                Node node = q.poll();
                if(node.getName().equals(target)){
                    check= true;
                    break bfs;
                }
                list.addAll(node.getChildList());
            }
            q.addAll(list);
            answer++;
        }

        return check? answer : 0;
    }

    public void makeTree(List<String> visit, Node parent, String[] words){
        String name = parent.getName();
        for(String word : words){
            if(!visit.contains(word)){
                int n = 0;
                for(int i=0; i<name.length(); i++){
                    if(name.charAt(i) != word.charAt(i)) n++;
                }

                if(n == 1){
                    Node child = new Node(word);
                    parent.addChild(child);
                    visit.add(name);
                    makeTree(visit, child, words);
                }
            }
        }
    }

    class Node{
        private final String name;
        private final List<Node> childList;
        public Node(String name){
            this.name = name;
            this.childList = new ArrayList<>();
        }

        public void addChild(Node child){
            this.childList.add(child);
        }

        public String getName() {
            return name;
        }

        public List<Node> getChildList() {
            return childList;
        }
    }

}
