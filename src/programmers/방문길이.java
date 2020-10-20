package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 방문길이 {
	
	public static void main(String[] args) {
		System.out.println(new 방문길이().solution("ULURRDLLU"));
	}
	
	public int solution(String dirs) {
		List<int[][]> moveList = new ArrayList<>();
		
		int[] point = new int[] {0,0};
		
		int dirsIndex = 0;
		
		while(dirsIndex < dirs.length()) {
			char move = dirs.charAt(dirsIndex++);
			
			int[] nextPoint = new int[] {point[0], point[1]};
			
			if(move == 'U') {
				nextPoint[0]++;
			}else if(move == 'L') {
				nextPoint[1]--;
			}else if(move == 'R') {
				nextPoint[1]++;
			}else {
				nextPoint[0]--;
			}
			
			if(checkScope(nextPoint[0]) && checkScope(nextPoint[1])) {
				int[][] movePoint = new int[][] {
					point, nextPoint
				};
				
				moveList.add(movePoint);
				point = nextPoint;
			}
		}
		
        int answer = 0;

		for(int i=0; i<moveList.size(); i++) {
			int[][] move1 = moveList.get(i);
			
			boolean check = false;
			
			for(int j = i+1; j<moveList.size(); j++) {
				int[][] move2 = moveList.get(j);
				
				if(checkMove(move1[0], move2[0]) && checkMove(move1[1], move2[1])) {
					check = true;
					break;
				}
				
				if(checkMove(move1[1], move2[0]) && checkMove(move1[0], move2[1])) {
					check = true;
					break;
				}
			}
			
			if(!check) {
				answer ++;
			}
		}
        
        return answer;
    }
	
	private boolean checkMove(int[] point1, int[] point2) {
		if(point1[0] != point2[0]) {
			return false;
		}
		
		if(point1[1]!= point2[1]) {
			return false;
		}
		
		return true;
	}
	
	private boolean checkScope(int point) {
		if(point < -5 || point > 5) {
			return false;
		}
		
		return true;
	}
}
