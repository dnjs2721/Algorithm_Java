package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_아기_상어 {
    static int n;
    static Node startNode = null;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    startNode = new Node(j, i, 0);
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int sharkSize = 2;
        int ateCount = 0;
        int turn = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->
                o2.time != o1.time
                        ? o1.time - o2.time
                        : o1.y != o2.y
                        ? o1.y - o2.y : o1.x - o2.x
        );
        map[startNode.y][startNode.x] = 0;

        while (true) {
            visited = new boolean[n][n];

            q.add(new Node(startNode.x, startNode.y, 0));
            visited[startNode.y][startNode.x] = true;

            boolean flag = false;

            while (!q.isEmpty()) {
                startNode = q.poll();

                if (map[startNode.y][startNode.x] != 0 && map[startNode.y][startNode.x] < sharkSize) {
                    map[startNode.y][startNode.x] = 0;
                    ateCount++;
                    turn += startNode.time;
                    flag = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = startNode.x + dx[i];
                    int ny = startNode.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (visited[ny][nx]) continue;
                    if (map[ny][nx] > sharkSize) continue;
                    q.add(new Node(nx, ny, startNode.time + 1));
                    visited[ny][nx] = true;
                }
            }
            if (!flag) {
                break;
            }

            if (sharkSize == ateCount) {
                sharkSize++;
                ateCount = 0;
            }
            q.clear();
        }

        return turn;
    }

    public static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}

//n X n 그기의 공간 -> 물고기 m 마리, 상어 1마리
// 처음 아기 상어의 크기는 2
// 상어는 1초에 상하좌우 이동
// 상어는 자신의 크기보다 작거나 같은 크기의 물고기가 있는 칸은 지나갈 수 있다,
// 자신의 크기보다 작은 물고기만 먹을 수 있다.
// 물고기를 먹는 시간은 없다,
// 먹을 수 있는 물고기가 여러마리라면 가까운 물고기 부터 먹는다.
// 먹을 수 없는 물고기가 없다면 엄마 상어 호출