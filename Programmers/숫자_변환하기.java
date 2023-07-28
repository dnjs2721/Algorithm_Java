package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 숫자_변환하기 {
    public static void main(String[] args) {
        System.out.println(solution(10, 40, 30));
    }

    public static int solution(int x, int y, int n) {
        int[] dist = new int[1000001];
        Arrays.fill(dist, 0);

        Queue<Integer> q = new LinkedList<>();
        dist[x] = 1;
        q.add(x);

        while (!q.isEmpty()) {
            x = q.poll();
            if (x >= y) {
                continue;
            }
            if ((0 <= x + n && x + n <= 1000000) && dist[x + n] == 0) {
                dist[x + n] = dist[x] + 1;
                q.add(x + n);
            }
            if ((0 <= x * 2 && x * 2 <= 1000000) && dist[x * 2] == 0) {
                dist[x * 2] = dist[x] + 1;
                q.add(x * 2);
            }
            if ((0 <= x * 3 && x * 3 <= 1000000) && dist[x * 3] == 0) {
                dist[x * 3] = dist[x] + 1;
                q.add(x * 3);
            }
        }

        return dist[y] - 1;
    }
}
