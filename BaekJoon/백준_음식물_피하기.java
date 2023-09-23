package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_음식물_피하기 {
    static int n;
    static int m;
    static boolean[][] map;
    static boolean[][] visited;
    static int trash;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // y
        m = Integer.parseInt(st.nextToken()); // x
        int k = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1; // y
            int c = Integer.parseInt(st.nextToken()) - 1; // x

            map[r][c] = true; // 쓰레기의 위치
        }

        int answer = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (visited[y][x]) continue;
                if (!map[y][x]) continue;
                trash = 0;
                dfs(x, y);
                answer = Math.max(trash, answer);
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        visited[y][x] = true;
        trash ++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (visited[ny][nx]) continue;
            if (!map[ny][nx]) continue;
            dfs(nx, ny);
        }
    }
}