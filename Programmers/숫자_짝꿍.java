package Programmers;

import java.util.*;

public class 숫자_짝꿍 {
    public static void main(String[] args) {
        System.out.println(solution("100", "2345"));
    }

    public static String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();

        for (char x : X.toCharArray()) {
            xMap.put(x, xMap.getOrDefault(x, 0) + 1);
        }

        for (char y : Y.toCharArray()) {
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }

        for (int i = 9; i >= 0; i--) {
            char number = Character.forDigit(i, 10);
            int count = Math.min(xMap.getOrDefault(number, 0), yMap.getOrDefault(number, 0));
            if (number == '0' && count > 0 && answer.length() == 0) {
                answer.append(number);
                continue;
            }
            for (int j = 0; j < count; j++) {
                answer.append(number);
            }
        }

        if (answer.length() == 0) {
            return "-1";
        }

        return answer.toString();
    }
}
