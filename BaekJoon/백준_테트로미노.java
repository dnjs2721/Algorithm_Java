package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_테트로미노 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int y, int x, int sum, int depth) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (visited[ny][nx]) continue;
            if (depth == 2) {
                visited[ny][nx] = true;
                dfs(y, x, sum + map[ny][nx], depth + 1);
                visited[ny][nx] = false;
            }
            visited[ny][nx] = true;
            dfs(ny, nx, sum + map[ny][nx], depth + 1);
            visited[ny][nx] = false;
        }
    }
}

