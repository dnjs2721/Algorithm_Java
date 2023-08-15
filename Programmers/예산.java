package Programmers;

import java.util.*;

public class 예산 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}, 9));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int i = 0; i < d.length; i++){
            if (d[i] <= budget) {
                budget -= d[i];
                answer++;
                continue;
            }
            break;
        }

        return answer;
    }
}
