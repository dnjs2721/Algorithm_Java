package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_욕심쟁이_판다 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dp;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        dp = new int[n][n]; // 각 지점을 출발 지점이라고 생각할 때 최대로 이동할 수 있는 거리

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 1; // 모든 칸은 최소 1이다.
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(dfs(j, i), answer);
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int x, int y) {
        if (visited[y][x]) { // 방문했던 곳이라면 해당 칸에서 시작하면 최대 몇칸을 갈 수 있는지 알 수 있다.
            return dp[y][x];
        }

        visited[y][x] = true; // 방문 처리
        int tmp = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; // 범위를 벗어나면 안된다.
            if (map[y][x] >= map[ny][nx]) continue; // 인접 칸이 현재 칸보다 작으면 안된다.
            tmp = Math.max(dfs(nx, ny), tmp); // 이동 가능한 인접 칸의 최대 이동횟수 증 최댓값.
        }
        dp[y][x] += tmp; // 인접 칸의 최대이동 횟수를 더하면 현재 위치의 최대 이동횟수가 된다.

        return dp[y][x];
    }
}
