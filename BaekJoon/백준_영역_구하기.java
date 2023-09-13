package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_영역_구하기 {
    static int m, n;
    static boolean[][] map;
    static boolean[][] visited;
    static int res;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // y
        n = Integer.parseInt(st.nextToken()); // x
        int k = Integer.parseInt(st.nextToken());

        map = new boolean[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = true;
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x]) continue;
                if (visited[y][x]) continue;
                res = 0;
                dfs(x, y);
                answer.add(res);
            }
        }
        Collections.sort(answer);
        bw.write(answer.size() + "\n");
        for (Integer a : answer) {
            bw.write(a + " ");
        }
        bw.flush();
    }

    public static void dfs(int x, int y) {
        visited[y][x] = true;
        res++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (map[ny][nx]) continue;
            if (visited[ny][nx]) continue;
            dfs(nx, ny);
        }
    }
}