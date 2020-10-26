package baekjoon;

import java.util.Scanner;

public class 펠린드롬인지확인하기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		System.out.println(isPailndrome(string, 0, string.length()-1));
	}
	
	private static int isPailndrome(String string, int left, int right) {
		if(left > right) {
			return 1;
		}
		
		if(string.charAt(left) != string.charAt(right)) {
			return 0;
		}
		
		return isPailndrome(string, left+1, right-1);
	}
}
