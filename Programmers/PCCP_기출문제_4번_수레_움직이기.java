package Programmers;

public class PCCP_기출문제_4번_수레_움직이기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 4}, {0, 0}, {2, 3}}));
        System.out.println(solution(new int[][]{{1, 0, 2}, {0, 0, 0}, {5, 0, 5}, {4, 0, 3}}));
    }

    static int n, m;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Node goalRed;
    static Node goalBlue;
    static int answer;

    // visited[0] 사용하지 않음
    // visited[1] 빨간 수레의 방문 기록
    // visited[2] 파란 수레의 방문 기록
    static boolean[][][] visited;

    public static int solution(int[][] maze) {

        n = maze.length;
        m = maze[0].length;
        map = maze;
        visited = new boolean[3][n][m];
        answer = Integer.MAX_VALUE;

        Node startRed = null, startBlue = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) startRed = new Node(j, i);
                else if (map[i][j] == 2) startBlue = new Node(j, i);
                else if (map[i][j] == 3) goalRed = new Node(j, i);
                else if (map[i][j] == 4) goalBlue = new Node(j, i);
            }
        }

        dfs(startRed, startBlue, false, false, 0);

        if (answer == Integer.MAX_VALUE) return 0;
        else return answer;
    }

    public static void dfs(Node startRed, Node startBlue, boolean redFlag, boolean blueFlag, int depth) {
        if (redFlag && blueFlag) {
            answer = Math.min(answer, depth);
        }

        else if (redFlag) {
            for (int i = 0; i < 4; i++) {
                int nextBlueX = startBlue.x + dx[i];
                int nextBlueY = startBlue.y + dy[i];
                if (nextBlueX == startRed.x && nextBlueY == startRed.y) continue;
                if (!isItPossible(nextBlueX, nextBlueY, 2)) continue;

                if (nextBlueX == goalBlue.x && nextBlueY == goalBlue.y) {
                    answer = Math.min(answer, depth + 1);
                    return;
                }
                visited[2][nextBlueY][nextBlueX] = true;
                dfs(startRed, new Node(nextBlueX, nextBlueY), true, false, depth + 1);
                visited[2][nextBlueY][nextBlueX] = false;
            }
        }

        else if (blueFlag) {
            for (int i = 0; i < 4; i++) {
                int nextRedX = startRed.x + dx[i];
                int nextRedY = startRed.y + dy[i];
                if (nextRedX == startBlue.x && nextRedY == startBlue.y) continue;
                if (!isItPossible(nextRedX, nextRedY, 1)) continue;

                if (nextRedX == goalRed.x && nextRedY == goalRed.y) {
                    answer = Math.min(answer, depth + 1);
                    return;
                }

                visited[1][nextRedY][nextRedX] = true;
                dfs(new Node(nextRedX, nextRedY), startBlue, false, true, depth + 1);
                visited[1][nextRedY][nextRedX] = false;
            }
        }

        else {
            for (int i = 0; i < 4; i++) {
                int nextRedX = startRed.x + dx[i];
                int nextRedY = startRed.y + dy[i];
                if (!isItPossible(nextRedX, nextRedY, 1)) continue;

                for (int j = 0; j < 4; j++) {
                    int nextBlueX = startBlue.x + dx[j];
                    int nextBlueY = startBlue.y + dy[j];
                    if (!isItPossible(nextBlueX, nextBlueY, 2)) continue;

                    if (nextBlueX == nextRedX && nextBlueY == nextRedY) continue;
                    if ((nextBlueX == startRed.x && nextBlueY == startRed.y)
                            && (nextRedX == startBlue.x && nextRedY == startRed.y)) continue;

                    boolean tmpRedFlag = false;
                    boolean tmpBlueFlag = false;
                    if (nextRedX == goalRed.x && nextRedY == goalRed.y) tmpRedFlag = true;
                    if (nextBlueX == goalBlue.x && nextBlueY == goalBlue.y) tmpBlueFlag = true;

                    visited[1][nextRedY][nextRedX] = true;
                    visited[2][nextBlueY][nextBlueX] = true;

                    dfs(new Node(nextRedX, nextRedY), new Node(nextBlueX, nextBlueY), tmpRedFlag, tmpBlueFlag, depth + 1);

                    visited[1][nextRedY][nextRedX] = false;
                    visited[2][nextBlueY][nextBlueX] = false;
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public static boolean isItPossible(int x, int y, int redOrBlue) {
        if (!checkRange(x, y)) return false;
        if (map[y][x] == 5) return false;
        if (visited[redOrBlue][y][x]) return false;
        return true;
    }


    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

// 0 빈칸
// 1 빨간 수레의 시작 칸
// 2 파란 수레의 시작 칸
// 3 빨간 수레의 도착 칸  1의 도착 목표
// 4 파란 수레의 도착 칸  2의 도착 목표
// 5 벽

// 수레는 상하자좌우로 한 칸 씩 움직임
// 벽이나 지도 밖으로는 불가능
// 재방문 불가능
// 목표에 도착한 수레는 고정
// 수레는 같은 칸에 존재할 수 없음
// 1의 위치와 2의 위치를 바꾸는건 할 수 없음
// 각 턴마다 모든 수레를 이동 시켜야 함