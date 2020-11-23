package mystudy.codinginterview.interviewtset.arrayandstring;

/* 138p 
 * 문제 : 문자열 s1와 s2가 주어질 때
 * isSubString 메소드를 한 번 호출하여
 * s2가 s1를 회전시킨 결과물인지 판별해라
 * */
public class 문자열회전 {
	public static void main(String[] args) {
		System.out.println(solution("data", "teea"));
	}

	private static boolean solution(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		char firstElement = s1.charAt(0);
		
		if(s2.indexOf(firstElement) == -1) {
			return false;
		}
		
		String lotatedS2 = lotate(s2, s2.indexOf(firstElement));
			
		return isSubString(s1, lotatedS2);
	}

	private static String lotate(String value, int startIndex) {
		StringBuilder lotatedString = new StringBuilder();

		int valueIndex = startIndex;

		lotatedString.append(value.charAt(valueIndex++));

		while (valueIndex != startIndex) {
			if (valueIndex == value.length()) {
				valueIndex = 0;
			}
			
			lotatedString.append(value.charAt(valueIndex++));
		}
		
		return lotatedString.toString();
	}

	private static boolean isSubString(String s1, String s2) {
		return s1.contains(s2);
	}
}
