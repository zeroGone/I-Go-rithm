package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 에디터 {
    private static final String LEFT = "L";
    private static final String RIGHT = "D";
    private static final String REMOVE = "B";
    private static final String ADD = "P";

    private static ListIterator<Character> editor;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String word = reader.readLine();

            editor = word.chars()
                    .mapToObj(element -> (char) element)
                    .collect(Collectors.toCollection(LinkedList::new)).listIterator();

            while (editor.hasNext()) {
                editor.next();
            }

            int M = Integer.parseInt(reader.readLine());

            for (int number = 1; number <= M; number += 1) {
                StringTokenizer command = new StringTokenizer(reader.readLine());

                switch (command.nextToken()) {
                    case LEFT:
                        moveCursorToLeft();
                        break;
                    case RIGHT:
                        moveCursorToRight();
                        break;
                    case REMOVE:
                        removeCharacter();
                        break;
                    case ADD:
                        addCharacter(command.nextToken().charAt(0));
                        break;
                }
            }

            while(editor.hasPrevious()){
                editor.previous();
            }

            StringBuilder output = new StringBuilder();

            while(editor.hasNext()){
                output.append(editor.next());
            }

            System.out.print(output.toString());
        }
    }

    private static void moveCursorToLeft() {
        if (editor.hasPrevious()) {
            editor.previous();
        }
    }

    private static void moveCursorToRight() {
        if (editor.hasNext()) {
            editor.next();
        }
    }

    private static void removeCharacter() {
        if(editor.hasPrevious()){
            editor.previous();
            editor.remove();
        }
    }

    private static void addCharacter(char character) {
        editor.add(character);
    }
}

