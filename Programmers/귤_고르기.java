package Programmers;

import java.util.*;

public class 귤_고르기 {
    public static void main(String[] args) {
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        int tmp = 0;
        for (int key : keys) {
            if (tmp >= k) {
                break;
            }
            tmp += map.get(key);
            answer++;
        }

        return answer;
    }
}
