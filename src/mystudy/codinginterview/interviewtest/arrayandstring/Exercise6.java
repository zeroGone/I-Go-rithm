package mystudy.codinginterview.interviewtset.arrayandstring;

/* 137p 1.6
 * 문제 : 반복되는 문자열을 개수를 세고 압축하는 메소드를 작성하라. 
 * 만약 기존의 문자열보다 압축한 문자열이 더 길면 기존의 문자열을 반환한다.
 * 입력 : aabccccaaa
 * 출력 : a2b1c4a3
 * */
public class Exercise6 {
	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.compress("aabccccaaa"));
	}

	public String compress(String string) {
		StringBuilder stringBuilder = new StringBuilder();

		int index = 0;
		char previousCharacter = string.charAt(index);
		int characterNumber = 1;
		
		for(index = 1; index<string.length(); index++) {
			char indexCharacter = string.charAt(index);

			if (previousCharacter == indexCharacter) {
				characterNumber++;
			} else {
				stringBuilder.append(previousCharacter).append(characterNumber);
				previousCharacter = indexCharacter;
				characterNumber = 1;
			}
		}
		
		stringBuilder.append(previousCharacter).append(characterNumber);

		String compressedString = stringBuilder.toString();

		if (compressedString.length() < string.length()) {
			return compressedString;
		} else {
			return string;
		}
	}
}