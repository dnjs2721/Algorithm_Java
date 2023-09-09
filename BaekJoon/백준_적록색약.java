package BaekJoon;

import java.io.*;
import java.util.*;
public class 백준_적록색약 {
    static int n;
    static char[][] map1;
    static char[][] map2;
    static boolean[][] visited1;
    static boolean[][] visited2;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int[] answer = new int[]{0, 0};

        map1 = new char[n][n];
        map2 = new char[n][n];

        for (int i = 0; i < n; i++) {
            String arr = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = arr.charAt(j);
                map1[i][j] = c;
                if (c == 'R') map2[i][j] = 'A';
                else if (c == 'G') map2[i][j] = 'A';
                else map2[i][j] = c;
            }
        }

        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited1[y][x]) { // 적록색약이 아닌사람
                    dfs(new Node(x, y), map1[y][x], map1, visited1);
                    answer[0] += 1;
                }
                if (!visited2[y][x]) { // 적록색약인 사람
                    dfs(new Node(x, y), map2[y][x], map2, visited2);
                    answer[1] += 1;
                }
            }
        }

        for (int res : answer) {
            bw.write(res + " ");
        }
        bw.flush();
    }

    public static void dfs(Node node, char color, char[][] map, boolean[][] visited) {
        visited[node.y][node.x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = node.x + dx[i];
            int ny = node.y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (visited[ny][nx]) continue;
            if (color != map[ny][nx]) continue;
            visited[ny][nx] = true;
            dfs(new Node(nx, ny), map[ny][nx], map, visited);
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