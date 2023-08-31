package LeetCode;

import java.util.*;

public class Sol_118 {
    public static void main(String[] args) {
        solution(5);
    }

    public static List<List<Integer>> solution(int n) {
        List<List<Integer>> dp = new ArrayList<>();

        dp.add(0, new ArrayList<>(List.of(1)));

        for (int i = 1; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                Integer a = dp.get(i-1).get(j-1);
                Integer b = dp.get(i - 1).get(j);
                tmp.add(a + b);
            }
            tmp.add(1);
            dp.add(tmp);
        }

        return dp;
    }
}
