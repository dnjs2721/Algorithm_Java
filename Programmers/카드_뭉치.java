package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카드_뭉치 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> firstCards = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> secondCards = new LinkedList<>(Arrays.asList(cards2));

        for (String s : goal) {
            if (s.equals(firstCards.peek())) {
                firstCards.poll();
            } else if (s.equals(secondCards.peek())) {
                secondCards.poll();
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
