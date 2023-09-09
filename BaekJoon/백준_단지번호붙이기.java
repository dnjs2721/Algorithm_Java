package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_단지번호붙이기 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String arr = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(arr.charAt(j)));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;
                if (visited[i][j]) continue;
                bfs(j, i, 1);
            }
        }

        bw.append(answer.size() + "\n");
        Collections.sort(answer);
        for (Integer num : answer) {
            bw.append(num + "\n");
        }
        bw.flush();
    }

    public static void bfs(int x, int y, int val) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (map[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                q.add(new Node(nx, ny));
                val++;
            }
        }
        answer.add(val);
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
