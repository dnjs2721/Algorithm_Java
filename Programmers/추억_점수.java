package Programmers;

import java.util.*;

public class 추억_점수 {

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int n = name.length;
        int photoLen = photo.length;

        int[] answer = new int[photoLen];

        Map<String, Integer> score = new HashMap<>();
        for (int i = 0; i < n; i++) {
            score.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photoLen; i++) {
            String[] p = photo[i];
            for (String pName : p) {
                if (score.containsKey(pName)) {
                    answer[i] += score.get(pName);
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        System.out.println(Arrays.toString(solution(name, yearning, photo)));
    }
}
