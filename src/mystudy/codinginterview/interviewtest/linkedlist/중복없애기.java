package mystudy.codinginterview.interviewtset.linkedlist;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

/* 141p 
 * 문제 : 정렬되지 않은 연결리스트가 주어질 때 중복되는 원소 제거해라
 * 문제2 : 임시 버퍼를 사용하지 않고 구현해라
 * */
public class 중복없애기 {
	public static void main(String[] args) {
		LinkedList<Integer> exampleLinkedList = new LinkedList<>();

		int elementNumber = 0;

		while (elementNumber < 100) {
			exampleLinkedList.add((int)(Math.random() * 100));
			elementNumber++;
		}

		System.out.println(solution(new LinkedList<>(exampleLinkedList)));
		System.out.println(solution2(new LinkedList<>(exampleLinkedList)));
	}

	public static LinkedList<Integer> solution(LinkedList<Integer> linkedList) {
		if (Objects.isNull(linkedList) || linkedList.size() == 0) {
			return linkedList;
		}

		Collections.sort(linkedList);

		LinkedList<Integer> resultList = new LinkedList<>();

		resultList.add(linkedList.poll());

		while (!linkedList.isEmpty()) {
			int element = linkedList.poll();

			int lastValue = resultList.peekLast();

			if (element != lastValue) {
				resultList.add(element);
			}
		}

		return resultList;
	}

	public static LinkedList<Integer> solution2(LinkedList<Integer> linkedList) {
		if (Objects.isNull(linkedList) || linkedList.size() == 0) {
			return linkedList;
		}

		int index = 0;

		while (index < linkedList.size()) {
			int indexValue = linkedList.get(index);

			int nextIndex = index + 1;

			while (nextIndex < linkedList.size()) {
				int nextValue = linkedList.get(nextIndex);

				if (indexValue == nextValue) {
					linkedList.remove(nextIndex);
				}

				nextIndex++;
			}

			index++;
		}
		
		return linkedList;
	}
}
