package Programmers;

import java.util.Stack;

public class 짝지어_제거하기 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    public static int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }
}
