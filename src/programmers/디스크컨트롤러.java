package programmers;

import java.util.*;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        System.out.println(new 디스크컨트롤러().solution(new int[][]{
                {0, 10}, {2, 12}, {9, 19}, {15, 17}
        }));

        System.out.println(new 디스크컨트롤러().solution(new int[][]{
                {0, 3}, {1, 9}, {2, 6}
        }));
        System.out.println(new 디스크컨트롤러().solution(new int[][]{
                {1000, 1000}
        }));

        System.out.println(new 디스크컨트롤러().solution(new int[][]{
                {0, 1}, {0, 1}, {0, 1}, {0, 1}
        }));

        System.out.println(new 디스크컨트롤러().solution(new int[][]{
                {0, 1}, {0, 1}, {0, 1}
        }));
        System.out.println(new 디스크컨트롤러().solution(new int[][]{
                {10, 10}, {30, 10}, {50, 2}, {51, 2}
        }));

        System.out.println(new 디스크컨트롤러().solution(new int[][]{
                {0, 3}, {1, 9}, {2, 6}, {30, 3}
        }));


    }

    private final Queue<Task> nowPossibleTasks = new PriorityQueue<>();
    private final Queue<Task> nextLeftTasks = new LinkedList<>();

    public int solution(int[][] jobs) {
        for (int[] job : jobs) {
            nextLeftTasks.add(new Task(job[0], job[1], job[1]));
        }

        return solution(0, 0) / jobs.length;
    }

    private int solution(int processTimeSum, int nowTime) {
        if (nowPossibleTasks.isEmpty() && nextLeftTasks.isEmpty()) {
            return processTimeSum;
        }

        getNextLeftTasks(nowTime);

        if (nowPossibleTasks.isEmpty()) {
            return solution(processTimeSum, getNextTaskStartTime());
        }

        Task nowTask = nowPossibleTasks.poll();
        nextLeftTasks.addAll(nowPossibleTasks);
        nowPossibleTasks.clear();
        setProcessTime(nowTime + nowTask.requiredTime);

        System.out.println(nowTask + " " + nowTime + " " + processTimeSum);

        return solution(processTimeSum + nowTask.processTime, nowTime + nowTask.requiredTime);
    }

    private int getNextTaskStartTime() {
        List<Task> tempList = new ArrayList<>();

        int nextTime = Integer.MAX_VALUE;
        while (!nextLeftTasks.isEmpty()) {
            Task nextLeftTask = nextLeftTasks.poll();
            if (nextLeftTask.startTime < nextTime) {
                nextTime = nextLeftTask.startTime;
            }
            tempList.add(nextLeftTask);
        }

        nextLeftTasks.addAll(tempList);
        return nextTime;
    }

    private void setProcessTime(int nowTime) {
        List<Task> temp = new ArrayList<>();
        while (!nextLeftTasks.isEmpty()) {
            Task leftTask = nextLeftTasks.poll();
            if (leftTask.startTime < nowTime) {
                leftTask.processTime = nowTime - leftTask.startTime + leftTask.requiredTime;
            }
            temp.add(leftTask);
        }
        nextLeftTasks.addAll(temp);
    }

    private void getNextLeftTasks(int nowTime) {
        List<Task> temp = new ArrayList<>();
        while (!nextLeftTasks.isEmpty()) {
            Task leftTask = nextLeftTasks.poll();
            if (nowTime >= leftTask.startTime) {
                nowPossibleTasks.add(leftTask);
            } else {
                temp.add(leftTask);
            }
        }
        nextLeftTasks.addAll(temp);
    }

    private class Task implements Comparable<Task> {
        final int startTime;
        final int requiredTime;
        int processTime;

        public Task(int startTime, int requiredTime, int processTime) {
            this.startTime = startTime;
            this.requiredTime = requiredTime;
            this.processTime = processTime;
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(requiredTime, o.requiredTime);
        }

        @Override
        public String toString() {
            return "Task{" +
                    "startTime=" + startTime +
                    ", requiredTime=" + requiredTime +
                    ", processTime=" + processTime +
                    '}';
        }
    }
}