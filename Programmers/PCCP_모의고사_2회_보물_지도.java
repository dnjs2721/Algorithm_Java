package Programmers;

import java.util.*;
public class PCCP_모의고사_2회_보물_지도 {
    public static void main(String[] args) {
        System.out.println(solution(4, 4, new int[][]{{2, 3}, {3, 3}}));
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static int solution(int n, int m, int[][] hole) {
        // 구멍인 경우 true, 아닌경우 false
        boolean[][] map = new boolean[m + 1][n + 1];
        for (int[] h : hole) {
            map[h[1]][h[0]] = true;
        }
        // visited[][][1] = 점프를 하지 않고 방문, visited[][][0] = 점프 사용 이후 방문
        boolean[][][] visited = new boolean[m + 1][n + 1][2];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 1, 1, 0));

        visited[1][1][1] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == n && node.y == m) {
                return node.val;
            }

            for (int i = 0; i < 4; i++) {
                // 한 칸 이동
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 범위 초과
                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;

                // 구멍이 아닐경우
                if (!map[ny][nx]) {
                    // 점프 후 방문이면 visited[ny][nx][0], 점프를 하지 않았으면 visited[ny][nx][1]
                    if (visited[ny][nx][node.jump]) continue;

                    visited[ny][nx][node.jump] = true;
                    q.add(new Node(nx, ny, node.jump, node.val + 1));
                }

                // jump 를 사용해서 두칸 이동
                if (node.jump == 0) continue; // jump 가 불가능 할 경우 continue
                nx += dx[i];
                ny += dy[i];

                // 범위 초과
                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                // 점프를 했는데 구멍인 경우
                if (map[ny][nx]) continue;
                // 점프를 사용한 후 방문한 곳일 경우
                if (visited[ny][nx][0]) continue;

                visited[ny][nx][0] = true;
                q.add(new Node(nx, ny, 0, node.val + 1));
            }
        }

        return -1;
    }

    static class Node {
        int x;
        int y;
        int jump; // 1 = 가능, 0 = 불가능
        int val;

        Node(int x, int y, int jump, int val) {
            this.x = x;
            this.y = y;
            this.jump = jump;
            this.val = val;
        }
    }
}