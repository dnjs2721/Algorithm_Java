package Programmers;

import java.util.*;

public class 연속된_부분_수열의_합 {
    public static int[] solution(int[] sequence, int k) {
        List<int[]> res = new ArrayList<>();

        int n = sequence.length;
        int maxSum = 0;
        int end = 0;

        for (int i = 0; i <n ; i++) {
            while (maxSum < k && end < n) {
                maxSum += sequence[end];
                end++;
            }
            if (maxSum == k) {
                res.add(new int[]{i, end - 1, end - 1 - i});
            }
            maxSum -= sequence[i];
        }

        res.sort(Comparator.comparing((int[] o) -> o[2]));

        return Arrays.copyOfRange(res.get(0), 0, 2);
    }

    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(sequence, 7)));

        int[] sequence1 = {1, 1, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(sequence1, 5)));

        int[] sequence2 = {2, 2, 2, 2, 2};
        System.out.println(Arrays.toString(solution(sequence2, 6)));
    }
}
