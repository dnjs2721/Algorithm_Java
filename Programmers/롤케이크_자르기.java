package Programmers;

import java.util.*;

public class 롤케이크_자르기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
    }

    public static int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int t : topping) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }


        Set<Integer> set = new HashSet<>();

        for (int t : topping) {
            set.add(t);
            count.put(t, count.get(t) - 1);
            if (count.get(t) == 0) {
                count.remove(t);
            }
            if (count.size() == set.size()) {
                answer++;
            } else if(count.size() < set.size()) {
                return answer;
            }
        }

        return 0;
    }
}
