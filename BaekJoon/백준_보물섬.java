package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_보물섬 {
    static int n, m;
    static char[][] map;
    static int[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'W') continue;
                answer = Math.max(answer, bfs(j, i));
            }
        }

        System.out.println(answer);
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        visited = new int[n][m];
        visited[y][x] = 1;
        q.add(new Node(x, y));
        int res = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || map[ny][nx] == 'W') continue;
                if (visited[ny][nx] > 0) continue;
                visited[ny][nx] = visited[node.y][node.x] + 1;
                res = Math.max(res, visited[ny][nx]);
                q.add(new Node(nx, ny));
            }
        }

        return res - 1;
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
