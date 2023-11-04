package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_바닥_장식 {
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static int[][] leftRight = new int[][]{{-1, 0}, {1, 0}};
    static int[][] upDown = new int[][]{{0, -1}, {0, 1}};
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

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;
                answer++;
                bfs(j, i, map[i][j]);
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int x, int y, char type) {
        Queue<Node> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new Node(x, y));

        int[][] move;
        if (type == '-') {
            move = leftRight;
        } else {
            move = upDown;
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int[] direct : move) {
                int nx = node.x + direct[0];
                int ny = node.y + direct[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] != type) continue;
                visited[ny][nx] = true;
                q.add(new Node(nx, ny));
            }
        }
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