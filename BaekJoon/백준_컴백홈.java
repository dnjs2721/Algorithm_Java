package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_컴백홈 {
    static int r;
    static int c;
    static int k;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0 ,0};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                if (s.charAt(j) == 'T') {
                    visited[i][j] = true;
                }
            }
        }

        dfs(0, r - 1, 1);

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int depth) {
        if (depth == k && x == c - 1 && y == 0) {
            answer++;
            return;
        }

        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= c || ny >= r ) continue;
            if (visited[ny][nx]) continue;
            dfs(nx, ny, depth + 1);
        }
        visited[y][x] = false;
    }
}