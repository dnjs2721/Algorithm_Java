package Programmers;

import java.util.*;

public class 대충_만든_자판 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})));
    }

    private static int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];

        Map<Character, Integer> valMap = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (!valMap.containsKey(c)) {
                    valMap.put(c, i + 1);
                } else {
                    if (valMap.get(c) > i + 1) {
                        valMap.put(c, i + 1);
                    }
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            boolean flage = true;
            for (int j = 0; j < targets[i].length(); j++) {
                if (!valMap.containsKey(targets[i].charAt(j))) {
                    count = -1;
                    break;
                } else {
                    count += valMap.get(targets[i].charAt(j));
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
