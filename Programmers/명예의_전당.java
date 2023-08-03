package Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 명예의_전당 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> heapQ = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            heapQ.add(score[i]);
            if (heapQ.size() > k) {
                heapQ.poll();
            }
            answer[i] = heapQ.peek();
        }
        return answer;
    }
}
