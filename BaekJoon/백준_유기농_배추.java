package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_유기농_배추 {

    static boolean[][] map;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int answer = 0;

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // x
            n = Integer.parseInt(st.nextToken()); // y
            int k = Integer.parseInt(st.nextToken());

            map = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true; // 배추가 잇는곳
            }

            visited = new boolean[n][m];

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (!map[y][x]) continue; // 배추가 아니면
                    if (visited[y][x]) continue; // 방문을 했던곳이면
                    bfs(x, y);
                    answer++;
                }
            }

            bw.write(answer + "\n");
        }
        bw.flush();
    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (!map[ny][nx]) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.add(new Node(nx, ny));
            }
        }
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
