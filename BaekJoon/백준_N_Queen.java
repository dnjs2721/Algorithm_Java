package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_N_Queen {
    static int n;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if (depth == n) { // 모든 열을 탐색 했다면 == 열마다 퀸을 배치 했다면
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) { // 열 탐색
            arr[depth] = i; // 해당 열의 행
            if (possible(depth)) dfs(depth + 1); // 가능 하다면 다음 열 탐색
        }
    }

    public static boolean possible(int col) {
        for (int i = 0; i < col; i++) { // 행 탐색
            if (arr[i] == arr[col]) return false; // 이전의 열 중 현재 열의 행과 같은 행이 있는 경우
            // 대각선상에 있는 경우
            // 열의 차와 행의 차가 같을 경우 == 대각선상에 있음
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }

        return true;
    }
}
