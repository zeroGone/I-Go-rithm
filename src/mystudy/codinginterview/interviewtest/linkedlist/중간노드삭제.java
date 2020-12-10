package mystudy.codinginterview.interviewtest.linkedlist;

/* 141p
 * 문제 : 처음과 끝이 아닌 노드를 삭제해라
 * 입력: a->b->c->d->e 에서 노드c
 * 출력: a->b->d->e
 * */
public class 중간노드삭제 {
    public static void main(String[] args) {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);

        solution(a, 'c');
    }

    private static void solution(Node firstNode, char target) {
        Node targetNode = getTarget(firstNode, target);

        validateTarget(firstNode, targetNode);
        removeTarget(firstNode, targetNode);
        print(firstNode);
    }

    private static Node getTarget(Node node, char target) {
        if (node == null) {
            return null;
        }

        if (node.getName() == target) {
            return node;
        } else {
            return getTarget(node.getNext(), target);
        }
    }

    private static void removeTarget(Node firstNode, Node target) {
        Node temp = firstNode;

        while (temp.getNext() != target) {
            temp = temp.getNext();
        }

        temp.setNext(target.getNext());
    }

    private static void validateTarget(Node firstNode, Node target) {
        if (target == null) {
            throw new IllegalArgumentException("target not exist");
        }

        if (target == firstNode || target.isLast()) {
            throw new IllegalArgumentException("target is first or last");
        }
    }

    private static void print(Node node) {
        if (node.isLast()) {
            System.out.print(node.getName());
        } else {
            System.out.print(node.getName() + "->");
            print(node.getNext());
        }
    }
}

class Node {
    private final char name;
    private Node next;

    public Node(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean isLast() {
        return next == null;
    }

    public Node getNext() {
        return next;
    }
}
