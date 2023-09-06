package Programmers;

import java.util.*;
public class PCCP_모의고사_1회_외톨이_알파벳 {
    public static void main(String[] args) {
        System.out.println(solution("edeaaabbccd"));
    }

    public static String solution(String input_string) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : input_string.toCharArray()){
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == c) {
                continue;
            }
            stack.push(c);
        }


        for (char c : stack) {
            if (map.containsKey(c)) {
                if (map.get(c) > 1) {
                    continue;
                }
                answer.append(c);
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        if (answer.length() > 0) {
            char[] res = answer.toString().toCharArray();
            Arrays.sort(res);
            return new String(res);
        }

        return "N";
    }
}
