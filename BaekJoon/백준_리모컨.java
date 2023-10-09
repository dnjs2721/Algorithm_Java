package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_리모컨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goal = Integer.parseInt(br.readLine());

        boolean[] keypad = new boolean[10];
        int n = Integer.parseInt(br.readLine());
        if (n != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                keypad[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int startToGoal = Math.abs(100 - goal); // 시작에서 목표까지 +, - 로 이동 횟수

        if (100 == goal || n == 10) { // +, - 로만 채널을 변경하거나 목표가 100번인 경우
            System.out.println(startToGoal);
            return;
        }

        if (n == 9 && !keypad[0]) { // 0번만 누를 수 있는경우
            System.out.println(Math.min(goal + 1, startToGoal)); // +,- 를 0번에서 시작, 100번에서 시작 비교
            return;
        }

        int res = Integer.MAX_VALUE; // 숫자 버튼을 통해 채널 변경했을 경우 목표까지의 최소 이동 횟수

        for (int i = 0; true; i++) { // 숫자 버튼을 통해 채널을 변경 -> 0부터 무한
            String now = String.valueOf(i);
            boolean flag = false;
            for (int j = 0; j < now.length(); j++) {
                if (keypad[now.charAt(j) - '0']) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue; // 망가진 버튼을 통한 채널변경 불가

            int val = now.length() + Math.abs(goal - i); // 채널 이동 후 +, - 이동
            if (val > res) { // 누르는 횟수가 이전보다 많아지는 경우 탐색 종료
                break;
            }
            res = val;
        }

        System.out.println(Math.min(res, startToGoal));
    }
}