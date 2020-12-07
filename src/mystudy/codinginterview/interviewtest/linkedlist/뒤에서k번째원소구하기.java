package mystudy.codinginterview.interviewtset.linkedlist;

/* 141p 
 * 문제 : 단방향 연결리스트가 주어졌을 때
 * 뒤에서 k 번째 원소를 찾는 알고리즘을 구현하라
 * 단, 길이를 모른다
 * */
public class 뒤에서k번째원소구하기 {
	public static void main(String[] args) {
		Node firstNode = new Node(0);

		Node tempNode = firstNode;
		for (int number = 1; number <= 10; number += 1) {
			Node element = new Node(number);
			tempNode.setNext(element);
			tempNode = tempNode.getNext();
		}
		
		System.out.println(new 뒤에서k번째원소구하기().solution(2, firstNode).getIndex());
	}

	private Node solution(int k, Node first) {
		int length = getSize(first);

		int target = length - k;

		return getTarget(target, first);
	}

	private int getSize(Node node) {
		if (node.isLast()) {
			return 0;
		} else {
			return 1 + getSize(node.getNext());
		}
	}

	private Node getTarget(int index, Node node) {
		if (index == 0) {
			return node;
		} else {
			return getTarget(index - 1, node.getNext());
		}
	}
}

class Node {
	private final int index;
	private Node next;

	public Node(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
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