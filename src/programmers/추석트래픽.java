package programmers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 추석트래픽 {
    public static void main(String[] args) {
        System.out.println(new 추석트래픽().solution(new String[]{
                "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"
        }));
    }

    private final List<Log> logs = new ArrayList<>();

    public int solution(String[] lines) {
        for (String string : lines) {
            String[] splitedString = string.split(" ");

            String[] dayString = splitedString[0].split("-");
            String[] timeString = splitedString[1].split(":");
            int[] processSeconds = parseSecondAndNanoSecond(splitedString[2]);

            logs.add(new Log(dayString, timeString, processSeconds));
        }
        Collections.sort(logs);
        int answer = 0;
        for (LocalDateTime time = logs.get(0).start; time.compareTo(logs.get(logs.size() - 1).end) <= 0; time = time.plusNanos(1000000)) {
            int number = 0;

            LocalDateTime plusOneSecond = time.plusNanos(999000000);

            List<Log> removes = new ArrayList<>();

            for (Log log : logs) {
                if (log.start.isAfter(plusOneSecond)) {
                    break;
                }
                if (log.end.isBefore(time)) {
                    removes.add(log);
                    continue;
                }
                number += 1;
            }

            if(removes.size() > 0){
                logs.removeAll(removes);
            }

            if (answer < number) {
                answer = number;
            }
        }
        return answer;
    }

    private int[] parseSecondAndNanoSecond(String second) {
        if (second.charAt(second.length() - 1) == 's') {
            second = second.substring(0, second.length() - 1);
        }

        String[] secondAndNanoSecondString = second.split("\\.");

        int[] secondAndNanoSecond = new int[]{Integer.parseInt(secondAndNanoSecondString[0]), 0};
        if (secondAndNanoSecondString.length == 2) {
            secondAndNanoSecond[1] = toNanoSecond(secondAndNanoSecondString[1]);
        }
        return secondAndNanoSecond;
    }

    private int toNanoSecond(String nanaSecondString) {
        int parsedNanoSecond = Integer.parseInt(nanaSecondString);
        int multipledValue = 1000000;
        if (nanaSecondString.length() == 2) {
            multipledValue *= 10;
        }
        if (nanaSecondString.length() == 1) {
            multipledValue *= 10;
        }
        return parsedNanoSecond * multipledValue;
    }

    private class Log implements Comparable<Log> {
        private final LocalDateTime start;
        private final LocalDateTime end;

        public Log(String[] days, String[] timeString, int[] processSeconds) {
            int year = Integer.parseInt(days[0]);
            int month = Integer.parseInt(days[1]);
            int day = Integer.parseInt(days[2]);
            int hour = Integer.parseInt(timeString[0]);
            int minute = Integer.parseInt(timeString[1]);
            int[] secondAndNanoSecond = parseSecondAndNanoSecond(timeString[2]);

            end = LocalDateTime.of(year, month, day, hour, minute, secondAndNanoSecond[0], secondAndNanoSecond[1]);
            start = end.minusSeconds(processSeconds[0]).minusNanos(processSeconds[1]).plusNanos(1000000);
        }

        @Override
        public String toString() {
            return "Log{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Log o) {
            if (start.isBefore(o.start)) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}