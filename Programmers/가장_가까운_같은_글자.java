package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 가장_가까운_같은_글자 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("foobar")));
    }

    public static int[] solution(String s) {
        int length = s.length();
        int[] answer = new int[length];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                answer[i] = i - map.get(c);
            } else {
                answer[i] = -1;
            }
            map.put(c, i);
        }
        return answer;
    }
}
