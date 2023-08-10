package Programmers;

import java.util.*;

public class 할인_행사 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }

    public static int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;

        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            boolean flag = true;
            for (int k = 0; k < want.length; k++) {
                if (!discountMap.containsKey(want[k])) {
                    flag = false;
                    break;
                }
                if (discountMap.get(want[k]) < number[k]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }

        return answer;
    }
}
