package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_내리막길 {
    static int m;
    static int n;
    static int[][] map;
    static int[][] dp;
    static int[] dx = new int[]{0, 0, -1, 1}; // 상, 하, 좌, 우
    static int[] dy = new int[]{-1, 1, 0, 0}; // 상, 하, 좌, 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m + 1][n + 1];
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1, 1));
    }

    public static int dfs(int x, int y) {
        if (x == n && y == m) {
            return 1;
        }
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
            if (map[y][x] <= map[ny][nx]) continue;
            dp[y][x] += dfs(nx, ny);
        }

        return dp[y][x];
    }
}
