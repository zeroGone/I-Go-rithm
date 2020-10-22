package mystudy.codinginterview.interviewtest.arrayandstring;

/* 136p 1.3
 * 문제 : 주어진 문자열의 공백을 20%로 치환해주는 메소드를 작성하라
 * */
public class Exercise3 {

	public String blankToTwentyPercent(String string, int stringLength) {
		StringBuilder stringBuilder = new StringBuilder();

		for (int stringIndex = 0; stringIndex < string.length(); stringIndex++) {
			char character = string.charAt(stringIndex);

			if (character == ' ') {
				stringBuilder.append("%20");
			} else {
				stringBuilder.append(character);
			}
		}

		return stringBuilder.toString();
	}

}
