package Programmers;

import java.util.*;

public class 둘만의_암호 {
    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd", 5));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        List<Integer> skipSet = new ArrayList<>();
        for (int i = 0; i < skip.length(); i++) {
            int ascii = skip.charAt(i);
            skipSet.add(ascii);
        }

        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i);
            int count = 0;
            while (count < index) {
                int next = ascii + 1;
                if (next == 123) {
                    next = 97;
                }
                if (!skipSet.contains(next)) {
                    count++;
                }
                ascii = next;
            }
            answer.append((char) ascii);
        }
        return answer.toString();
    }
}
