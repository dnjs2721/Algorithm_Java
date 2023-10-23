package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_빵집 {

    static int r, c;
    static boolean[][] map;
    /** 이 순서가 제일 중요 **/
    static int[] dx = {1, 1, 1}; //우, 우, 우
    static int[] dy = {-1, 0, 1}; //상, , 하
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new boolean[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                if (s.charAt(j) == '.') map[i][j] = true;
            }
        }

        int res = 0;
        for (int i = 0; i < r; i++) {
            if (dfs(0, i)) res++;
        }

        System.out.println(res);
    }

    public static boolean dfs(int x, int y) {
        if (x == c - 1) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= c || ny >= r) continue; // 범위 벗어나면
            if (!map[ny][nx]) continue; // 건물이면
            if (visited[ny][nx]) continue; // 이미 방문한 곳

            visited[ny][nx] = true; // 방문처리
            if (dfs(nx, ny)) return true; // 끝까지 도달 가능하면 true 리턴
        }

        return false; // 끝까지 도달 못함
    }
}