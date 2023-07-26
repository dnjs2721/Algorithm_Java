package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"XXXXL", "XOOSX", "XXXXX", "XXXOO", "EXXXX", "XXXXX"}));
    }

    public static int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    return bfs(n, m, j, i, maps);
                }
            }
        }
        return -1;
    }

    public static int bfs(int n, int m, int sx, int sy, String[] maps) {

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sy, sx});

        int[][] visited = new int[n][m];
        visited[sy][sx] = 1;
        boolean lever = false;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] > 0 || maps[ny].charAt(nx) == 'X') {
                    continue;
                }
                if (maps[ny].charAt(nx) == 'L') {
                    q = new LinkedList<>();
                    q.add(new int[]{ny, nx});
                    int cost = visited[y][x];
                    visited = new int[n][m];
                    visited[ny][nx] = cost;
                    lever = true;
                    break;
                } else if (maps[ny].charAt(nx) == 'E' && lever) {
                    return visited[y][x] + 1;
                }
                visited[ny][nx] = visited[y][x] + 1;
                q.add(new int[]{ny, nx});
            }
        }

        return -1;
    }
}
