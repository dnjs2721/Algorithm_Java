package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_미친_로봇 {
    static int n;
    static double[] ewsn = new double[4];
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static double goal = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            ewsn[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        visited = new boolean[2 * n + 1][2 * n + 1];
        dfs(n, n, 0, 1);

        System.out.println(goal);
    }

    public static void dfs(int x, int y, int depth, double res) {
        if (depth == n) {
            goal += res;
            return;
        }

        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            if (ewsn[i] == 0) continue;
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (visited[ny][nx]) continue;
            dfs(nx, ny, depth + 1, res * ewsn[i]);
        }
        visited[y][x] = false;
    }
}
