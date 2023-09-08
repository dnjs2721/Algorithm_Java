package Programmers;

import java.util.*;
public class PCCP_모의고사_2회_카페_확장 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 12, 30}, new int[]{1, 2, 0, 1}, 10));
    }

    public static int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        int now = -k;
        int last = 0;
        for (int j : order) {
            now += k;
            while (!q.isEmpty()) {
                if (q.peek() <= now) {
                    q.poll();
                } else {
                    break;
                }
            }

            if (q.isEmpty()) last = now;
            int makeTime = menu[j];

            q.add(last + makeTime);
            last += makeTime;

            answer = Math.max(answer, q.size());
        }

        return answer;
    }
}
