package line2019;

/*
문제
연인 코니와 브라운은 광활한 들판에서 ‘나 잡아 봐라’ 게임을 한다.
이 게임은 브라운이 코니를 잡거나, 코니가 너무 멀리 달아나면 끝난다.
게임이 끝나는데 걸리는 최소 시간을 구하시오.

조건
코니는 처음 위치 C에서 1초 후 1만큼 움직이고, 이후에는 가속이 붙어 매 초마다 이전 이동 거리 + 1만큼 움직인다.
즉 시간에 따른 코니의 위치는 C, C + 1, C + 3, C + 6, …이다.
브라운은 현재 위치 B에서 다음 순간 B – 1, B + 1, 2 * B 중 하나로 움직일 수 있다.
코니와 브라운의 위치 p는 조건 0 <= x <= 200,000을 만족한다.
브라운은 범위를 벗어나는 위치로는 이동할 수 없고, 코니가 범위를 벗어나면 게임이 끝난다.

입력 형식
표준 입력의 첫 줄에 코니의 위치 C와 브라운의 위치 B를 공백으로 구분하여 순서대로 읽는다.

출력 형식
브라운이 코니를 잡을 수 있는 최소시간 N초를 표준 출력한다. 단 브라운이 코니를 잡지 못한 경우에는 -1을 출력한다.

예제
입력: 11 2
출력: 5
코니의 위치: 11 → 12 → 14 → 17 → 21 → 26
브라운의 위치: 2 → 3 → 6 → 12 → 13 → 26
브라운은 코니를 5초 만에 잡을 수 있다.
* */

import java.util.Scanner;
import java.util.Stack;

public class 상반기기출 {


    //시간이 t1일 때 코니와 브라운의 위치가 p1으로 같으면 잡았다고 판단하는 알고리즘으로 풀었다
    //반례로  C = 11, B = 1인 경우 틀림.
    static int solve(int C, int B) {
        if (C == B) return 0;
        boolean[] 브라운 = new boolean[200001];

        int 이동거리 = 0;
        int time = 0;

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> newStack = new Stack<>();

        브라운[B] = true;
        stack.push(B);

        out:
        while (C <= 200000) {
            C = C + (이동거리++);

            while (!stack.isEmpty()) {
                int value = stack.pop();
                if (value == C) break out;
                int[] array = new int[3];
                array[0] = value - 1;
                array[1] = value + 1;
                array[2] = value * 2;

                for (int i : array) {
                    if (i >= 0 && i <= 200000 && !브라운[i]) {
                        브라운[i] = true;
                        newStack.push(i);
                    }
                }
            }

            while (!newStack.isEmpty()) stack.push(newStack.pop());
            time++;
        }

        if (C <= 200000) return time;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt();
        int B = scanner.nextInt();

    }
}
