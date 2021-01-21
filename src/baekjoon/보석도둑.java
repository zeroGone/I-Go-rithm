package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보석도둑 {
    private static class Jewel {
        final int weight;
        final int price;

        Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int K = Integer.parseInt(stringTokenizer.nextToken());

            Jewel[] jewels = new Jewel[N];
            for (int index = 0; index < N; index += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                int weight = Integer.parseInt(stringTokenizer.nextToken());
                int price = Integer.parseInt(stringTokenizer.nextToken());

                jewels[index] = new Jewel(weight, price);
            }

            int[] bags = new int[K];
            for (int index = 0; index < K; index += 1) {
                bags[index] = Integer.parseInt(reader.readLine());
            }

            Arrays.sort(jewels, (o1, o2) -> {
                if (o1.weight == o2.weight) {
                    return -Integer.compare(o1.price, o2.price);
                }
                return Integer.compare(o1.weight, o2.weight);
            });
            Arrays.sort(bags);

            Queue<Jewel> queue = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1.price, o2.price));

            long sum = 0;
            int jewelIndex = 0;
            for (int bag : bags) {
                while (jewelIndex < N && jewels[(jewelIndex)].weight <= bag) {
                    queue.add(jewels[jewelIndex]);
                    jewelIndex += 1;
                }

                if (!queue.isEmpty()) {
                    sum += queue.poll().price;
                }
            }

            System.out.print(sum);
        }
    }
}
