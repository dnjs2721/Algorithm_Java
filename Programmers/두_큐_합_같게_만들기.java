package Programmers;

import java.util.*;

public class 두_큐_합_같게_만들기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int n = queue1.length;

        long sumQ1 = 0;
        long sumQ2 = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int n1 = queue1[i];
            int n2 = queue2[i];

            q1.add(n1);
            q2.add(n2);

            sumQ1 += n1;
            sumQ2 += n2;
        }

        int max = (n + n) * 2;
        int idx = 0;
        while (idx < max) {
            idx++;
            if (sumQ1 > sumQ2) {
                int poll = q1.poll();
                q2.add(poll);
                sumQ1 -= poll;
                sumQ2 += poll;
                answer++;
            } else if (sumQ1 < sumQ2) {
                int poll = q2.poll();
                sumQ1 += poll;
                sumQ2 -= poll;
                q1.add(poll);
                answer++;
            } else {
                return answer;
            }
        }

        return -1;
    }
}
