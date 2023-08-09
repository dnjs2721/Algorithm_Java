package Programmers;

import java.util.*;

public class 연속_부분_수열_합의_개수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 9, 1, 1, 4}));
    }

    public static int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> answer = new HashSet<>();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n; j++){
                int sum = elements[j];
                for (int k = j + 1; k < j + i; k++) {
                    sum += elements[k % n];
                }
                answer.add(sum);
            }
        }

        return answer.size();
    }
}
