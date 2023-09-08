package Programmers;

import java.util.*;
public class PCCP_모의고사_2회_실습용_로봇 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("GRGLGRG")));
    }
    public static int[] solution(String command) {
        int[] answer = new int[]{0, 0};
        int state = 0; // 0 -> 위, 1 -> 오른쪽, 2 -> 아래쪽, 3 -> 왼쪽
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        for (char c : command.toCharArray()) {
            switch (c) {
                case 'G' -> {
                    answer[0] += dx[state];
                    answer[1] += dy[state];
                }
                case 'B' -> {
                    answer[0] -= dx[state];
                    answer[1] -= dy[state];
                }
                case 'R' -> state = (state + 1) % 4;
                case 'L' -> state = (state + 3) % 4;
            }
        }
        return answer;
    }
}
