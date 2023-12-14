package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        long[][] dp = new long[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;
                int val = map[i][j];
                if (i + val < n) {
                    if ((i + val == n - 1 && j == n - 1) || map[i + val][j] != 0) {
                        dp[i + val][j] += dp[i][j];
                    }
                }
                if (j + val < n) {
                    if ((i == n - 1 && j + val == n - 1) || map[i][j + val] != 0) {
                        dp[i][j + val] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}