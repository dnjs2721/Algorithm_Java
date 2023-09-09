package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_섬의_개수 {
    static boolean[][] map;
    static boolean[][] visited;
    static int w;
    static int h;
    static int[] dx = new int[]{0, 0, -1, 1, -1, -1, 1, 1}; // 상 하 좌 우 좌상 좌하 우상 우하
    static int[] dy = new int[]{1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // x
            h = Integer.parseInt(st.nextToken()); // y
            if (w == 0 && h == 0) break;

            map = new boolean[h][w];
            visited = new boolean[h][w];
            int res = 0;

            for (int y = 0; y < h; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < w; x++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        map[y][x] = true; // 섬
                    }
                }
            }

            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (!map[y][x]) continue;
                    if (visited[y][x]) continue;
                    dfs(new Node(x, y));
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    public static void dfs(Node node) {
        visited[node.y][node.x] = true;
        for (int i = 0; i < 8; i++) {
            int nx = node.x + dx[i];
            int ny = node.y + dy[i];
            if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
            if (visited[ny][nx]) continue;
            if (!map[ny][nx]) continue;
            dfs(new Node(nx, ny));
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