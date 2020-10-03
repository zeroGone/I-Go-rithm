package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 히스토그램가장큰직사각형 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[] array = new int[n];
            for (int i = 0; i < n; i++) array[i] = Integer.parseInt(st.nextToken());

            Node head = makeTree(array, 0, n - 1);
            builder.append(getMax(array, head, 0, n - 1)).append("\n");
        }
        System.out.print(builder.deleteCharAt(builder.length() - 1).toString());
    }

    static long getMax(int[] array, Node node, int start, int end) {
        if (start == end) return array[start];

        int minIndex = searchMin(array, node, start, end);

        long leftMax = minIndex == start ? array[start] : getMax(array, node, start, minIndex - 1);
        long rightMax = minIndex == end ? array[end] : getMax(array, node, minIndex + 1, end);
        long max = Math.max(leftMax, rightMax);

        System.out.println(end + " " + start + "  = " + (long) array[minIndex] * (end - start + 1));
        return Math.max(array[minIndex] * (end - start + 1), max);
    }

    static int searchMin(int[] array, Node node, int start, int end) {
        if (node.getStart() > end || node.getEnd() < start) return Integer.MAX_VALUE;
        if (start <= node.getStart() && node.getEnd() <= end) return node.getMinIndex();

        int left = searchMin(array, node.getLeft(), start, end);
        int right = searchMin(array, node.getRight(), start, end);
        if (left == Integer.MAX_VALUE) return right;
        else if (right == Integer.MAX_VALUE) return left;
        else return array[left] <= array[right] ? left : right;

    }

    static Node makeTree(int[] array, int start, int end) {
        Node node = new Node(start, end);

        if (start == end) {
            node.setMinIndex(start);
            return node;
        }

        int middle = (start + end) / 2;
        node.setLeft(makeTree(array, start, middle));
        node.setRight(makeTree(array, middle + 1, end));

        int leftMinIndex = node.getLeft().getMinIndex();
        int rightMinIndex = node.getRight().getMinIndex();
        int minIndex = array[leftMinIndex] <= array[rightMinIndex] ? leftMinIndex : rightMinIndex;

        node.setMinIndex(minIndex);

        return node;
    }

    static class Node {
        private final int start;
        private final int end;
        private int minIndex;
        private Node left;
        private Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return this.start;
        }

        public int getEnd() {
            return this.end;
        }

        public void setMinIndex(int index) {
            this.minIndex = index;
        }

        public int getMinIndex() {
            return this.minIndex;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public Node getLeft() {
            return this.left;
        }

        public boolean hasLeft() {
            return this.left != null;
        }

        public void setRight(Node node) {
            this.right = node;
        }

        public Node getRight() {
            return this.right;
        }

        public boolean hasRight() {
            return this.right != null;
        }


        @Override
        public String toString() {
            return "node : [" + this.start + "~" + this.end + " minIndex : " + this.minIndex + "] ";
        }
    }
}
