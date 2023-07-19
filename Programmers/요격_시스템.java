package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 요격_시스템 {
    public static int solution(int[][] targets) {
        int answer = 0;
        int preEnd = 0;

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        for (int i = 0; i < targets.length; i++) {
            int curStart = targets[i][0];
            int curEnd = targets[i][1];

            if ( preEnd <= curStart) {
                preEnd = curEnd;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        System.out.println(solution(targets));
    }
}
