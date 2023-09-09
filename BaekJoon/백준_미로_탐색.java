package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_미로_탐색 {
    static int[][] map;
    static int[][] visited;
    static int n;
    static int m;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

//    static boolean[][] bVisited;
//    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String arr = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(arr.charAt(j)));
            }
        }

        System.out.println(bfs());
//        bVisited = new boolean[n][m];
//        dfs(0, 0, 1);
//        System.out.println(answer);
    }

    public static int bfs() {
        visited = new int[n][m];
        visited[0][0] = 1;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (map[ny][nx] == 0) continue;
                if (visited[ny][nx] > 0) continue;
                visited[ny][nx] = visited[node.y][node.x] + 1;
                q.add(new Node(nx, ny));
            }
        }

        return visited[n-1][m-1];
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

//    public static void dfs(int x, int y, int val) {
//        if (x == m - 1 && y == n - 1) {
//            answer = Math.min(answer, val);
//            return;
//        }
//
//        if (x < 0 || y < 0 || x >= m || y >= n) return;
//        if (bVisited[y][x]) return;
//        if (map[y][x] == 0) return;
//        bVisited[y][x] = true;
//        for (int i = 0; i < 4; i++) {
//            dfs(x + dx[i], y + dy[i], val + 1);
//        }
//        bVisited[y][x] = false;
//    }
}
