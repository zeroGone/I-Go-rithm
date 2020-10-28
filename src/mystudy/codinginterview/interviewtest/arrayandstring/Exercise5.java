package javaworkspace;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/* 137p 1.5
 * 문제 : 두 문자열을 비교해서 하나의 문자 삽입, 삭제, 교체 해서 같게 만들 수 있는지
 * ex1 : pale, ple = true
 * ex2 : pales, pale = true
 * ex3 : pale, bale = true
 * ex4 : pale, bake = false
 * */
public class Exercise5 {
	public boolean solution(String str1, String str2) {

		if (Math.abs(str1.length() - str2.length()) > 1) {
			return false;
		}

		Map<Character, Integer> stringMap = new HashMap<>();

		initMap(stringMap, str1);

		compareStringtoMap(stringMap, str2);

		int differenceNumber = characterDifferenceNumber(stringMap);
		
		if(differenceNumber <= 1) {
			return true;
		}else {
			return false;
		}
	}

	private void initMap(Map<Character, Integer> map, String string) {
		int stringIndex = 0;

		while (stringIndex < string.length()) {
			char character = string.charAt(stringIndex++);
			int characterNumber = 0;

			if (map.containsKey(character)) {
				characterNumber = map.get(character);
			}

			map.put(character, characterNumber + 1);
		}
	}

	private void compareStringtoMap(Map<Character, Integer> map, String string) {
		int stringIndex = 0;

		while (stringIndex < string.length()) {
			char character = string.charAt(stringIndex++);
			int characterNumber = 0;

			if (map.containsKey(character)) {
				characterNumber = map.get(character);
				map.put(character, characterNumber - 1);
			}
		}
	}

	private int characterDifferenceNumber(Map<Character, Integer> map) {
		Iterator<Character> iterator = map.keySet().iterator();
		
		int sum = 0;

		while (iterator.hasNext()) {
			int number = map.get(iterator.next());
			sum += Math.abs(number);
		}

		return sum;
	}
}
