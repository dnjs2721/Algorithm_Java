package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_알파벳 {
    static char[][] map;
    static boolean[] check = new boolean[26];
    static int r;
    static int c;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); // y
        c = Integer.parseInt(st.nextToken()); // x
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = s[j];
            }
        }
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int val) {
        answer = Math.max(answer, val);
        check[map[y][x] - 65] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= c || ny < 0 || ny >= r || check[map[ny][nx] - 65]) continue;
            dfs(nx, ny, val + 1);
            check[map[ny][nx] - 65] = false;
        }
    }
}