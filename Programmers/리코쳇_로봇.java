package Programmers;

import java.util.*;

public class 리코쳇_로봇 {


    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution(board));
    }


    public static int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();

        int rx = 0;
        int ry = 0;
        int gx = 0;
        int gy = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    ry = i;
                    rx = j;
                } else if (board[i].charAt(j) == 'G') {
                    gy = i;
                    gx = j;
                }
            }
        }
        return bfs(rx, ry, gx, gy, board, n, m);
    }

    public static int bfs(int rx, int ry, int gx, int gy, String[] board, int n, int m) {
        int[][] visited = new int[n][m];

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ry, rx});
        visited[ry][rx] = 1;

        while (!(q.isEmpty())) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];

            if (y == gy && x == gx) {
                return visited[gy][gx] - 1;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || board[ny].charAt(nx) == 'D') {
                    continue;
                }

                while (true) {
                    ny += dy[i];
                    nx += dx[i];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || board[ny].charAt(nx) == 'D') {
                        if (visited[ny - dy[i]][nx - dx[i]] > 0) {
                            break;
                        }
                        visited[ny - dy[i]][nx - dx[i]] = visited[y][x] + 1;
                        q.offer(new int[]{ny - dy[i], nx - dx[i]});
                        break;
                    }
                }
            }
        }
        return -1;
    }
}