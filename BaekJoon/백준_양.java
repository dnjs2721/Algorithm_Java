package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_양 {
    static int r;
    static int c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int sheep = 0;
    static int wolf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '#') visited[i][j] = true;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                bfs(i, j);
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    public static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        int s = 0;
        int w = 0;
        if (map[y][x] == 'o') s++;
        else if (map[y][x] == 'v') w++;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= c || ny >= r) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == 'o') s++;
                else if (map[ny][nx] == 'v') w++;
                visited[ny][nx] = true;
                q.add(new Node(nx, ny));
            }
        }

        if (s > w) {
            sheep += s;
        } else {
            wolf += w;
        }
    }

    public static class Node {
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
