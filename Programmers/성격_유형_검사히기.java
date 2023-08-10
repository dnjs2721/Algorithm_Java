package Programmers;

import java.util.*;

public class 성격_유형_검사히기 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }

    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> board = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            char typeA = survey[i].charAt(0);
            char typeB = survey[i].charAt(1);
            int score = choices[i];

            if (score < 4) {
                board.put(typeA, board.getOrDefault(typeA, 0) + (4 - score));
            } else if (score > 4){
                board.put(typeB, board.getOrDefault(typeB, 0) + (score - 4));
            }
        }

        answer.append(compare(board, 'R', 'T'));
        answer.append(compare(board, 'C', 'F'));
        answer.append(compare(board, 'J', 'M'));
        answer.append(compare(board, 'A', 'N'));

        return answer.toString();
    }

    public static char compare(Map<Character, Integer> board, char a, char b){
        if (board.getOrDefault(a, 0) >= board.getOrDefault(b, 0)) {
            return a;
        } else {
            return b;
        }
    }
}
