package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_이동하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {0, 1, 1}; // 하, 우, 하우
        int[] dy = {1, 0, 1}; // 하, 우, 하우

        dp[1][1] = map[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < 3; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny < 1 || nx < 1 || nx > m || ny > n) continue;
                    dp[ny][nx] = Math.max(dp[ny][nx], dp[i][j] + map[ny][nx]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
