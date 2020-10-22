package mystudy.codinginterview.interviewtest.arrayandstring;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 136p 1.4
 * 문제 : 주어진 문자열의 순열 중 회문이 가능한 순열인지 확인한다
 * ex) Tact Coa
 * */
public class Exercise4 {

	public static void main(String[] args) {
		System.out.println(new Exercise4().isPalindromePermutation("Tacb Coa"));
	}

	public boolean isPalindromePermutation(String string) {
		Map<Character, Integer> charNumberMap = new HashMap<>();

		int charNum = 0;
		
		for (int stringIndex = 0; stringIndex < string.length(); stringIndex++) {
			char character = Character.toLowerCase(string.charAt(stringIndex));
			
			if (character == ' ') {
				continue;
			}

			if (charNumberMap.containsKey(character)) {
				charNumberMap.put(character, charNumberMap.get(character) + 1);
			} else {
				charNumberMap.put(character, 1);
			}
			
			charNum++;
		}

		Iterator<Character> chIterator = charNumberMap.keySet().iterator();

		boolean hasOddNumber = false;

		while (chIterator.hasNext()) {
			char element = chIterator.next();

			if (charNum % 2 == 1) {
				if (charNumberMap.get(element) % 2 == 1) {
					hasOddNumber = !hasOddNumber;
				}
			} else {
				if (charNumberMap.get(element) % 2 == 1) {
					return hasOddNumber;
				}
			}
		}

		if (hasOddNumber) {
			return true;
		} else {
			if (charNum % 2 == 1) {
				return true;
			} else {
				return false;
			}
		}
	}
}
