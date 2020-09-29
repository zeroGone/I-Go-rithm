package programmers;

import java.util.*;

public class 순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Node[] nodes = new Node[n];
        for(int i=0; i<n; i++) nodes[i] = new Node(i);
        for(int[] result : results){
            nodes[result[0]-1].addWin(nodes[result[1]-1]);
            nodes[result[1]-1].addLose(nodes[result[0]-1]);
        }

        for(Node node : nodes){
            int sum = search(true, new boolean[n], node);
            sum += search(false, new boolean[n], node);
            if(sum == n-1) answer++;
        }
        return answer;
    }

    private int search(boolean win, boolean[] check, Node node){
        int sum = 0;
        check[node.getValue()] = true;
        LinkedList<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node now = q.poll();

            List<Node> nextList = win ? now.getWin() : now.getLose();

            for(Node next : nextList){
                if(!check[next.getValue()]){
                    check[next.getValue()] = true;
                    q.add(next);
                    sum++;
                }
            }
        }
        return sum;
    }


    class Node{
        int value;
        List<Node> win;//이 노드가 이긴
        List<Node> lose;//이 노드가 진
        public Node(int value){
            this.value = value;
            this.win = new ArrayList<>();
            this.lose = new ArrayList<>();
        }
        public int getValue(){
            return this.value;
        }
        public void addWin(Node node){
            this.win.add(node);
        }

        public void addLose(Node node){
            this.lose.add(node);
        }


        public List<Node> getWin(){
            return this.win;
        }

        public List<Node> getLose(){
            return this.lose;
        }
    }
}
