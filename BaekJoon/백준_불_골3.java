package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_불_골3 {
    static int r;
    static int c;
    static int[][] visited;
    static int[][] fireVisited;
    static Queue<Node> jQueue = new LinkedList<>();
    static Queue<Node> fQueue = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new int[r][c];
        fireVisited = new int[r][c];

        for (int i = 0; i < r; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                char s = line[j];
                if (s == '#') {
                    visited[i][j] = -1;
                    fireVisited[i][j] = -1;
                } else if (s == 'J') {
                    visited[i][j] = 1;
                    jQueue.add(new Node(i, j));
                } else if (s == 'F') {
                    fireVisited[i][j] = 1;
                    fQueue.add(new Node(i, j));
                }
            }
        }

        fireBfs();
        jBfs();
    }

    public static void fireBfs() {
        while (!fQueue.isEmpty()) {
            Node node = fQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= c || ny < 0 || ny >= r) continue;
                if (fireVisited[ny][nx] == -1 || fireVisited[ny][nx] > 0) continue;
                fireVisited[ny][nx] = fireVisited[node.y][node.x] + 1;
                fQueue.add(new Node(ny, nx));
            }
        }
    }

    public static void jBfs() {
        while (!jQueue.isEmpty()) {
            Node node = jQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= c || ny < 0 || ny >= r) {
                    System.out.println(visited[node.y][node.x]);
                    return;
                }
                if (visited[ny][nx] == -1 || visited[ny][nx] > 0) continue;
                if (visited[node.y][node.x] + 1 >= fireVisited[ny][nx]) { // J가 이동할 타이밍이 불이 번진 상태라면
                    if (fireVisited[ny][nx] != 0) { // 불이 번지지 않은곳은 갈 수 있다.
                        continue;
                    }
                }
                visited[ny][nx] = visited[node.y][node.x] + 1;
                jQueue.add(new Node(ny, nx));
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static class Node {
        int x;
        int y;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
