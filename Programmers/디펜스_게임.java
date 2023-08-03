package Programmers;

import java.util.PriorityQueue;

public class 디펜스_게임 {
    public static void main(String[] args) {
        System.out.println(solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
        System.out.println(solution(2, 4, new int[]{3, 3, 3, 3}));
    }

    public static int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> heapQ = new PriorityQueue<>();

        for (int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            heapQ.add(-e);
            n -= e;
            if (n < 0) {
                if (k == 0) {
                    return i;
                }
                n = n + (-heapQ.poll());
                k--;
            }
        }
        return enemy.length;
    }
}