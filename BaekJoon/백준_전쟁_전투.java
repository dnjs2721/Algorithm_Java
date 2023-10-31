package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_전쟁_전투 {
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int wPoint = 0;
        int bPoint = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                char team = map[i][j];
                int res = bfs(j, i, team);
                if (team == 'W') wPoint += res * res;
                else bPoint += res * res;
            }
        }

        System.out.println(wPoint + " " + bPoint );
    }

    public static int bfs(int x, int y, char team) {
        Queue<Node> q = new LinkedList<>();
        visited[y][x] = true;
        int score = 1;
        q.add(new Node(x, y));
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] != team) continue;
                visited[ny][nx] = true;
                score++;
                q.add(new Node(nx, ny));
            }
        }

        return score;
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
