package programmers;

public class 키패드누르기 {

    public static void main(String[] args) {
        int[] a = new int[]{
                1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5
        };
        System.out.println(new 키패드누르기().solution(a, "right"));
    }
    public String solution(int[] numbers, String hand) {
        StringBuilder builder = new StringBuilder();

        Point leftHand = new Point(0, 0);
        Point rightHand = new Point(2, 0);

        for (int num : numbers) {
            System.out.println("value : "+num + "/  left : "+leftHand+" / right : "+rightHand);
            int yIndex = 1;

            if (num == 1 || num == 4 || num == 7) {
                builder.append("L");
                if (num == 1) yIndex = 3;
                else if (num == 4) yIndex = 2;
                leftHand.setPoint(0, yIndex);

            } else if (num == 3 || num == 6 || num == 9) {
                builder.append("R");
                if (num == 3) yIndex = 3;
                else if (num == 6) yIndex = 2;
                rightHand.setPoint(2, yIndex);

            } else {
                if( num == 2 ) yIndex = 3;
                else if( num == 5 ) yIndex = 2;
                else if( num == 0) yIndex = 0;

                Point point = new Point(1, yIndex);

                int leftDist = leftHand.getDistance(point);
                int rightDist = rightHand.getDistance(point);
                System.out.println("distance : left = "+leftDist+" / right = "+rightDist);
                if (leftDist < rightDist || (leftDist == rightDist && hand.equals("left"))) {
                    builder.append("L");
                    leftHand.setPoint(point.getX(), point.getY());
                } else {
                    builder.append("R");
                    rightHand.setPoint(point.getX(), point.getY());
                }
            }
        }

        return builder.toString();
    }

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance(Point other) {
            return Math.abs(this.x - other.getX()) + Math.abs(this.y - other.getY());
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
