package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 뱀 {
    private static int N;

    private static char SNAKE_LEFT = 'L';
    private static char SNAKE_RIGHT = 'D';
    private static int LEFT = 1;
    private static int RIGHT = 2;
    private static int UP = 3;
    private static int DOWN = 4;

    private static LinkedList<SnakeMove> snakeMoves = new LinkedList<>();
    private static List<Point> appleCoordinates = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(reader.readLine());
            int K = Integer.parseInt(reader.readLine());

            for (int appleNumber = 0; appleNumber < K; appleNumber += 1) {
                StringTokenizer appleCoordinate = new StringTokenizer(reader.readLine());

                int appleX = Integer.parseInt(appleCoordinate.nextToken()) - 1;
                int appleY = Integer.parseInt(appleCoordinate.nextToken()) - 1;

                appleCoordinates.add(new Point(appleY, appleX));
            }

            int L = Integer.parseInt(reader.readLine());

            for (int moveNumber = 0; moveNumber < L; moveNumber += 1) {
                StringTokenizer moveInformation = new StringTokenizer(reader.readLine());

                int turnNumber = Integer.parseInt(moveInformation.nextToken());
                char direction = moveInformation.nextToken().charAt(0);

                snakeMoves.addLast(new SnakeMove(turnNumber, direction));
            }

            LinkedList<Point> snake = new LinkedList<>();
            snake.add(new Point(0, 0));

            int turn = 0;
            int direction = RIGHT;

            while (true) {
                turn += 1;
                snake = moveSnake(direction, snake);

                if (isBumpedIntoWall(snake) || isBumpedIntoBody(snake)) {
                    break;
                }

                if (!hasApple(snake.get(0))) {
                    snake.pollLast();
                }

                direction = setDirection(turn, direction);
            }

            System.out.println(turn);
        }
    }

    private static int setDirection(int turn, int direction) {
        if (snakeMoves.isEmpty() || turn != snakeMoves.get(0).getTurnNumber()) {
            return direction;
        }

        SnakeMove nextMove = snakeMoves.pollFirst();
        char snakeDirection = nextMove.getDirection();

        if (snakeDirection == SNAKE_LEFT) {
            if (direction == LEFT) {
                return DOWN;
            } else if (direction == RIGHT) {
                return UP;
            } else if (direction == DOWN) {
                return RIGHT;
            } else {
                return LEFT;
            }
        } else {
            if (direction == LEFT) {
                return UP;
            } else if (direction == RIGHT) {
                return DOWN;
            } else if (direction == DOWN) {
                return LEFT;
            } else {
                return RIGHT;
            }
        }
    }

    private static LinkedList<Point> moveSnake(int direction, LinkedList<Point> snake) {
        Point head = snake.get(0);
        int movedX = head.getX();
        int movedY = head.getY();

        if (direction == LEFT) {
            movedY -= 1;
        }

        if (direction == RIGHT) {
            movedY += 1;
        }

        if (direction == UP) {
            movedX -= 1;
        }

        if (direction == DOWN) {
            movedX += 1;
        }

        snake.addFirst(new Point(movedY, movedX));
        return snake;
    }

    private static boolean isBumpedIntoWall(LinkedList<Point> snake) {
        Point head = snake.get(0);

        if (head.getX() >= N || head.getX() < 0) {
            return true;
        }

        if (head.getY() >= N || head.getY() < 0) {
            return true;
        }

        return false;
    }

    private static boolean isBumpedIntoBody(LinkedList<Point> snake) {
        List<Point> body = new ArrayList<>(snake);

        Point head = body.get(0);

        int headX = head.getX();
        int headY = head.getY();
        for (int bodyIndex = 1; bodyIndex < body.size(); bodyIndex += 1) {
            Point bodyElement = body.get(bodyIndex);

            int elementX = bodyElement.getX();
            int elementY = bodyElement.getY();

            if (headX == elementX && headY == elementY) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasApple(Point head) {
        int headX = head.getX();
        int headY = head.getY();

        for (int appleIndex = 0; appleIndex < appleCoordinates.size(); appleIndex += 1) {
            Point apple = appleCoordinates.get(appleIndex);

            int appleX = apple.getX();
            int appleY = apple.getY();

            if (headX == appleX && headY == appleY) {
                appleCoordinates.remove(appleIndex);
                return true;
            }
        }
        return false;
    }

    private static class SnakeMove {
        private final int turnNumber;
        private final char direction;

        public SnakeMove(int turnNumber, char direction) {
            this.turnNumber = turnNumber;
            this.direction = direction;
        }

        public char getDirection() {
            return direction;
        }

        public int getTurnNumber() {
            return turnNumber;
        }
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
