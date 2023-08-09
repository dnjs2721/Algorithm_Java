package Programmers;

import java.util.*;

public class 택배상자 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
    }
    public static int solution(int[] order) {
        int idx = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i < order.length + 1; i++) {
            stack.add(i);
            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
            }
        }

        return idx;
    }
}
