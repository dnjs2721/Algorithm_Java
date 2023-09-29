package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_연구소 {
    static int n;
    static int m;
    static int[][] map;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // y
        m = Integer.parseInt(st.nextToken()); // x

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if (depth == 3) {
            virus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void virus() {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    q.add(new Node(j, i));
                }
            }
        }
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (ny < 0 || nx < 0 || nx >= m || ny >= n) continue;
                if (copy[ny][nx] == 0) {
                    q.add(new Node(nx, ny));
                    copy[ny][nx] = 2;
                }
            }
        }
        count(copy);
    }

    public static void count(int[][] copy) {
        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) safe++;
            }
        }
        answer = Math.max(answer, safe);
    }

    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}