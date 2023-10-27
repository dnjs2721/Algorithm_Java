package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_숫자판_점프 {
    static int[][] map = new int[5][5];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static Set<String> answer = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String s = String.valueOf(map[i][j]);
                dfs(i, j, s);
            }
        }
        System.out.println(answer.size());
    }

    public static void dfs(int y, int x, String s) {
        if (s.length() == 6) {
            answer.add(s);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            dfs(ny, nx, s + map[ny][nx]);
        }
    }
}
