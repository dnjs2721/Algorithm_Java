package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_헌내기는_친구가_필요해 {
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

        map = new char[n][m];
        visited = new boolean[n][m];

        int sx = 0;
        int sy = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'I') {
                    sx = j;
                    sy = i;
                }
            }
        }

        int answer = bfs(sx, sy);

        if (answer == 0) System.out.println("TT");
        else System.out.println(answer);
    }

    public static int bfs(int x, int y) {
        int meet = 0;
        Queue<Node> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new Node(x, y));
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (map[ny][nx] == 'X') continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == 'P') meet++;
                visited[ny][nx] = true;
                q.add(new Node(nx, ny));
            }
        }

        return meet;
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
