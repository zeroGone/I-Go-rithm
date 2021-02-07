package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회 {
    private static Node head;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            head = new Node(stringTokenizer.nextToken());
            makeChild(head, stringTokenizer.nextToken(), stringTokenizer.nextToken());

            for (int number = 2; number <= N; number += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());

                Node target = search(head, stringTokenizer.nextToken());
                makeChild(target, stringTokenizer.nextToken(), stringTokenizer.nextToken());
            }

            StringBuilder stringBuilder = new StringBuilder();
            searchLeft(head, stringBuilder);
            stringBuilder.append("\n");
            searchMiddle(head, stringBuilder);
            stringBuilder.append("\n");
            searchRight(head, stringBuilder);

            System.out.print(stringBuilder.toString());
        }
    }

    private static void searchLeft(Node node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        stringBuilder.append(node.value);
        searchLeft(node.left, stringBuilder);
        searchLeft(node.right, stringBuilder);
    }

    private static void searchMiddle(Node node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        searchMiddle(node.left, stringBuilder);
        stringBuilder.append(node.value);
        searchMiddle(node.right, stringBuilder);
    }

    private static void searchRight(Node node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        searchRight(node.left, stringBuilder);
        searchRight(node.right, stringBuilder);
        stringBuilder.append(node.value);
    }

    private static Node search(Node node, String value) {
        if (node == null) {
            return null;
        }
        if (node.value.equals(value)) {
            return node;
        }
        Node left = search(node.left, value);
        Node right = search(node.right, value);

        if (left == null) {
            return right;
        } else {
            return left;
        }
    }

    private static void makeChild(Node target, String left, String right) {
        if (!left.equals(".")) {
            target.left = new Node(left);
        }
        if (!right.equals(".")) {
            target.right = new Node(right);
        }
    }

    private static class Node {
        final String value;
        Node left;
        Node right;

        Node(String value) {
            this.value = value;
        }
    }
}
