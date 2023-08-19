package Programmers;

import java.util.*;

public class 영어_끝말잇기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }

    public static int[] solution(int n, String[] words) {
        Set<String> dic = new HashSet<>();
        dic.add(words[0]);
        char c = words[0].charAt(words[0].length() - 1);

        int bigTurn = 1;
        int smallTurn = 2;

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (dic.contains(word) || word.charAt(0) != c) {
                return new int[]{smallTurn, bigTurn};
            } else {
                dic.add(word);
                c = word.charAt(word.length() - 1);
            }
            smallTurn++;
            if (smallTurn > n) {
                smallTurn = 1;
                bigTurn++;
            }
        }

        return new int[]{0, 0};
    }
}
