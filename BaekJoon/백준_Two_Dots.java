package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_Two_Dots {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0 , 0};
    static int startX, startY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                startX = j;
                startY = i;
                dfs(j, i, map[i][j], 1);
            }
        }

        System.out.println("No");
    }

    public static void dfs(int x, int y, char color, int depth) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (map[ny][nx] != color) continue;
            if (depth + 1 >= 4 && nx == startX && ny == startY) {
                System.out.println("Yes");
                System.exit(0);
            }
            if (visited[ny][nx]) continue;
            dfs(nx, ny, color, depth + 1);
        }
        visited[y][x] = false;
    }
}