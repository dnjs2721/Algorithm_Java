package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_현수막 {
    static int m;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;
                if (visited[i][j]) continue;
                bfs(j, i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new Node(x, y));
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                q.add(new Node(nx, ny));
            }
        }
    }

    public static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}