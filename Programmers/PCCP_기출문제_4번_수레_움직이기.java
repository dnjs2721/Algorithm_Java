package Programmers;

public class PCCP_기출문제_4번_수레_움직이기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 4}, {0, 0}, {2, 3}}));
        System.out.println(solution(new int[][]{{1, 0, 2}, {0, 0, 0}, {5, 0, 5}, {4, 0, 3}}));
        System.out.println(solution(new int[][]{{1, 5}, {2, 5}, {4, 5}, {3, 5}}));
    }

    static int n, m; // 퍼즐판의 세로, 가로
    static int[][] map; // 퍼즐판
    static int[] dx = {0, 0, -1, 1}; // 가로에 대한 상하좌우 이동 값
    static int[] dy = {-1, 1, 0, 0}; // 세로에 대한 상하좌우 이동 값
    static Node goalRed; // 빨간 수레의 목표 지점
    static Node goalBlue; // 파란 수레의 목표 지점
    static int answer; // 정답

    // visited[0] 사용하지 않음
    // visited[1] 빨간 수레의 방문 기록
    // visited[2] 파란 수레의 방문 기록
    static boolean[][][] visited;

    public static int solution(int[][] maze) {

        n = maze.length;
        m = maze[0].length;
        map = maze;
        visited = new boolean[3][n][m];
        answer = Integer.MAX_VALUE; // 탐색 후 최소값 비교를 위해 Integer.MAX_VALUE 로 초기화

        Node startRed = null, startBlue = null; // 빨간 수레, 파란 수레의 시작 지점
        for (int i = 0; i < n; i++) { // 전달받은 퍼즐판에서 필요한 정보 탐색
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) { // 빨간 수레
                    startRed = new Node(j, i); // 빨간 수레 위치정보 저장
                    visited[1][i][j] = true; // 빨간 수레의 시작점 방문 체크
                }
                else if (map[i][j] == 2) { // 파란 수레
                    startBlue = new Node(j, i); // 파란 수레 위치정보 저장
                    visited[2][i][j] = true; // 파란 수레의 시작점 방문 체크
                }
                else if (map[i][j] == 3) goalRed = new Node(j, i); // 빨간 수레에 대한 목표 지점의 위치정보 저장
                else if (map[i][j] == 4) goalBlue = new Node(j, i); // 파란 수레에 대한 목표 지점의 위지정보 저장
            }
        }

        // 빨간 수레의 시작 저점, 파란 수레의 시작 지점, 빨간 수레 도착 여부, 파란 수레 도착 여부, 사용한 턴의 수
        dfs(startRed, startBlue, false, false, 0); // dfs 탐색 시작

        // 만약 dfs 탐색을 마쳤는데도 answer 이 MAXVALUE 란 뜻은 퍼즐을 풀 수 없는 경우를 뜻한다.
        if (answer == Integer.MAX_VALUE) return 0; // 0을 반환
        else return answer; // 퍼즐을 푸는데 필요한 턴의 최솟값을 리턴
    }

    public static void dfs(Node startRed, Node startBlue, boolean redFlag, boolean blueFlag, int depth) {
        if (redFlag && blueFlag) { // 만약 두 수레 모두 목표에 도착했다면
            answer = Math.min(answer, depth); // 최솟값 비교를 통해 가장 적은 턴에 성공한 턴 도출
        }

        else if (redFlag) { // 만약 빨간 수레만 도착 지점에 도착했다면, 빨간 수레는 고정하고 파란 수레만 움직인다.
            for (int i = 0; i < 4; i++) { // 파란 수레에 대한 상하좌우 탐색 시작
                int nextBlueX = startBlue.x + dx[i]; // 다음 파란 수레의 가로 위치
                int nextBlueY = startBlue.y + dy[i]; // 다음 파란 수레의 세로 위치
                // 만역 파란 수레의 다음 위치가 빨간 수레와 겹친다면 continue
                if (nextBlueX == startRed.x && nextBlueY == startRed.y) continue;
                // 파란 수레의 다음 위치에 대한 범위, 벽, 방문에 대한 적합성 검사
                // false 를 반환한다면 불가능한 탐색 지역
                if (!isItPossible(nextBlueX, nextBlueY, 2)) continue;

                // 빨간 수레가 이미 도착한 상태에서 파란 수레가 목표 지점에 도달 했다면
                if (nextBlueX == goalBlue.x && nextBlueY == goalBlue.y) {
                    // 다음 탐색은 필요 없기에 현재 턴에 + 1
                    answer = Math.min(answer, depth + 1); // 최솟값 비교를 통해 가장 적은 턴에 성공한 턴 도출
                    return; // return 을 통해 해당 dfs 탐색을 종료한다.
                }

                // 파란 수레가 목표 지점에 도달하지 못했다면
                visited[2][nextBlueY][nextBlueX] = true; // 파란 수레의 방문 배열에 방문 체크
                // 고정된 빨간 수레의 정보, 파란 수레의 현재 탐색 지점에 대한 정보
                // 빨간 수레는 이미 도달 한 상태이기에 true, 파란 수레는 도달하지 못했기 때문에 false
                // 다음 턴을 의미하는 현재 턴(depth) + 1
                // 위 정보를 이용해 재귀 탐색
                dfs(startRed, new Node(nextBlueX, nextBlueY), true, false, depth + 1);
                visited[2][nextBlueY][nextBlueX] = false; // 다음 탐색을 위한 방문 해제 : 백트래킹
            }
        }

        else if (blueFlag) { // 만약 파란 수레만 도착 지점에 도착했다면, 파란 수레는 고정하고 빨간 수레만 움직인다.
            for (int i = 0; i < 4; i++) { // 빨간 수레에 대한 상하좌우 탐색 시작
                int nextRedX = startRed.x + dx[i]; // 다음 빨간 수레의 가로 위치
                int nextRedY = startRed.y + dy[i]; // 다음 빨간 수레의 세로 위치
                // 만역 빨간 수레의 다음 위치가 파란 수레와 겹친다면 continue
                if (nextRedX == startBlue.x && nextRedY == startBlue.y) continue;
                // 빨간 수레의 다음 위치에 대한 범위, 벽, 방문에 대한 적합성 검사
                // false 를 반환한다면 불가능한 탐색 지역
                if (!isItPossible(nextRedX, nextRedY, 1)) continue;

                // 파란 수레가 이미 도착한 상태에서 빨간 수레가 목표 지점에 도달 했다면
                if (nextRedX == goalRed.x && nextRedY == goalRed.y) {
                    // 다음 탐색은 필요 없기에 현재 턴에 + 1
                    answer = Math.min(answer, depth + 1); // 최솟값 비교를 통해 가장 적은 턴에 성공한 턴 도출
                    return; // return 을 통해 해당 dfs 탐색을 종료한다.
                }

                // 빨간 수레가 목표 지점에 도달하지 못했다면
                visited[1][nextRedY][nextRedX] = true; // 빨간 수레의 방문 배열에 방문 체크
                // 빨간 수레의 현재 탐색 지점에 대한 정보, 고정된 파란 수레의 정보
                // 빨간 수레는 도달하지 못했기 때문에 false, 파란 수레는 이미 도달 한 상태이기에 true
                // 다음 턴을 의미하는 현재 턴(depth) + 1
                // 위 정보를 이용해 재귀 탐색
                dfs(new Node(nextRedX, nextRedY), startBlue, false, true, depth + 1);
                visited[1][nextRedY][nextRedX] = false; // 다음 탐색을 위한 방문 해제 : 백트래킹
            }
        }

        else { // 빨간 수레, 파란 수레 모두 도착 지점에 도달 하지 못했다면, 두 수레 모두 움직여야만 한다.
            for (int i = 0; i < 4; i++) { // 빨간 수레에 대한 상하좌우 탐색 시작
                int nextRedX = startRed.x + dx[i]; // 다음 빨간 수레의 가로 위치
                int nextRedY = startRed.y + dy[i]; // 다음 빨간 수레의 세로 위치
                // 빨간 수레의 다음 위치에 대한 범위, 벽, 방문에 대한 적합성 검사
                // false 를 반환한다면 불가능한 탐색 지역
                if (!isItPossible(nextRedX, nextRedY, 1)) continue;

                for (int j = 0; j < 4; j++) { // 파란 수레에 대한 상하좌우 탐색 시작
                    int nextBlueX = startBlue.x + dx[j]; // 다음 파란 수레의 가로 위치
                    int nextBlueY = startBlue.y + dy[j]; // 다음 파란 수레의 세로 위치
                    // 파란 수레의 다음 위치에 대한 범위, 벽, 방문에 대한 적합성 검사
                    // false 를 반환한다면 불가능한 탐색 지역
                    if (!isItPossible(nextBlueX, nextBlueY, 2)) continue;
                    // 다음 수레들이 동시에 같은 위치에 있다면 continue
                    if (nextBlueX == nextRedX && nextBlueY == nextRedY) continue;
                    // 수레끼리 자리를 바꾼거라면 continue
                    if ((nextBlueX == startRed.x && nextBlueY == startRed.y)
                            && (nextRedX == startBlue.x && nextRedY == startBlue.y)) continue;

                    boolean tmpRedFlag = false; // 이번 탐색에서 빨간 수레의 목표지점 도달 여부
                    boolean tmpBlueFlag = false; // 이번 탐색에서 파란 수레의 목표지점 도달 여부
                    // 만약 빨간 수레가 목표에 도달 하였다면, true
                    if (nextRedX == goalRed.x && nextRedY == goalRed.y) tmpRedFlag = true;
                    // 만약 파란 수레가 목표에 도달 하였다면, true
                    if (nextBlueX == goalBlue.x && nextBlueY == goalBlue.y) tmpBlueFlag = true;


                    visited[1][nextRedY][nextRedX] = true; /// 빨간 수레의 방문 배열에 방문 체크
                    visited[2][nextBlueY][nextBlueX] = true; // 파란 수레의 방문 배열에 방문 체크

                    // 빨간 수레의 현재 탐색 지점에 대한 정보, 파란 수레의 현재 탐색 지점에 대한 정보
                    // 빨간 수레의 목표지점 도달 여부, 파란 수레의 목표지점 도달 여부
                    // 다음 턴을 의미하는 현재 턴(depth) + 1
                    // 위 정보를 이용해 재귀 탐색
                    dfs(new Node(nextRedX, nextRedY), new Node(nextBlueX, nextBlueY), tmpRedFlag, tmpBlueFlag, depth + 1);

                    visited[1][nextRedY][nextRedX] = false; // 다음 탐색을 위한 탐색한 빨간 수레 방문 해제 : 백트래킹
                    visited[2][nextBlueY][nextBlueX] = false; // 다음 탐색을 위한 탐색한 파란 수레 방문 해제 : 백트래킹
                }
            }
        }
    }

    public static boolean isItPossible(int x, int y, int redOrBlue) { // 해당 위치가 탐색 가능한 지점인지 확인하는 메서드
        if (x < 0 || y < 0 || x >= m || y >= n) return false; // 퍼즐판의 범위에서 벗어나는지
        if (map[y][x] == 5) return false; // 탐색지역이 벽인지
        if (visited[redOrBlue][y][x]) return false; // 이미 탐색한 지점인지
        return true; // 위 조건들을 제외하고는 탐색 가능한 지점
    }


    public static class Node { // 수레의 위치 정보를 나타내는 클래스
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