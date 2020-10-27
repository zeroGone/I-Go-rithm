package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder builder = new StringBuilder();
		while(true) {
			StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
			
			int first = Integer.parseInt(stringTokenizer.nextToken());
			int second = Integer.parseInt(stringTokenizer.nextToken());
			
			if(first == 0 && second == 0) {
				break;
			}
			if(first > second) {
				builder.append("Yes").append("\n");
			}else {
				builder.append("No").append("\n");
			}
		}
		
		System.out.print(builder.deleteCharAt(builder.length()-1).toString());
	}
}
