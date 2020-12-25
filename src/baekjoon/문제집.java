package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제집 {
    private static Question[] questions;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            questions = new Question[Integer.parseInt(stringTokenizer.nextToken()) + 1];
            for (int index = 1; index < questions.length; index += 1) {
                questions[index] = new Question(index);
            }

            int M = Integer.parseInt(stringTokenizer.nextToken());
            for (int number = 1; number <= M; number += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());

                int firstQuestionNumber = Integer.parseInt(stringTokenizer.nextToken());
                int nextQuestionNumber = Integer.parseInt(stringTokenizer.nextToken());

                questions[firstQuestionNumber].addNextQuestionNumber(nextQuestionNumber);
                questions[nextQuestionNumber].addFirstQuestion();
            }

            StringBuilder outputBuilder = new StringBuilder();

            Queue<Question> nextQuestion = new PriorityQueue<>();

            for (int number = 1; number < questions.length; number += 1) {
                if (questions[number].isFirst()) {
                    nextQuestion.add(questions[number]);
                }
            }

            for (int number = 1; number < questions.length; number += 1) {
                Question question = nextQuestion.poll();
                outputBuilder.append(question.getNumber()).append(" ");

                for (int next : question.getNextQuestions()) {
                    questions[next].solveFirstQuestion();

                    if (questions[next].isFirst()) {
                        nextQuestion.add(questions[next]);
                    }
                }
            }

            System.out.print(outputBuilder.toString());
        }
    }
}

class Question implements Comparable<Question> {
    private final List<Integer> nextQuestions;
    private final int number;
    private int firstQuestionNumber;

    public Question(int number) {
        this.number = number;
        nextQuestions = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void addNextQuestionNumber(int number) {
        nextQuestions.add(number);
    }

    public List<Integer> getNextQuestions() {
        return nextQuestions;
    }

    public void solveFirstQuestion() {
        firstQuestionNumber -= 1;
    }

    public void addFirstQuestion() {
        firstQuestionNumber += 1;
    }

    public boolean isFirst() {
        return firstQuestionNumber == 0;
    }

    @Override
    public int compareTo(Question o) {
        return number - o.number;
    }

    @Override
    public String toString() {
        return "Question{" +
                "number=" + number +
                ", firstQuestionNumber=" + firstQuestionNumber +
                '}';
    }
}