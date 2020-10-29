package javaworkspace;

/* 137p 1.5
 * 문제 : 두 문자열을 비교해서 하나의 문자 삽입, 삭제, 교체 해서 같게 만들 수 있는지
 * ex1 : pale, ple = true
 * ex2 : pales, pale = true
 * ex3 : pale, bale = true
 * ex4 : pale, bake = false
 * */
public class Main {
	public static void main(String[] args) {
		Main main = new Main();

		System.out.println(main.solution("pale", "ple"));
		System.out.println(main.solution("pales", "pale"));
		System.out.println(main.solution("pale", "bale"));
		System.out.println(main.solution("pale", "bake"));
	}

	public boolean solution(String str1, String str2) {
		if (Math.abs(str1.length() - str2.length()) > 1) {
			return false;
		}

		if (str1.length() < str2.length()) {
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}

		if (isInsertOrDeleteAble(str1, str2)) {
			return true;
		}

		if (str1.length() != str2.length()) {
			return false;
		}

		if (isEditAble(str1, str2)) {
			return true;
		}

		return false;
	}

	private boolean isInsertOrDeleteAble(String str1, String str2) {
		int str1Index = 0;
		int str2Index = 0;
		boolean firstDifference = false;
		while (str1Index < str1.length() && str2Index < str2.length()) {
			if (str1.charAt(str1Index) == str2.charAt(str2Index)) {
				str1Index++;
				str2Index++;
			} else {
				if (firstDifference) {
					return false;
				} else {
					firstDifference = true;
				}
				str1Index++;
			}
		}
		return true;
	}

	private boolean isEditAble(String str1, String str2) {
		boolean firstEdit = false;

		int stringIndex = 0;

		while (stringIndex < str1.length()) {
			if (str1.charAt(stringIndex) != str2.charAt(stringIndex)) {
				if (firstEdit) {
					return false;
				} else {
					firstEdit = true;
				}
			}
			stringIndex++;
		}
		return true;
	}
}
