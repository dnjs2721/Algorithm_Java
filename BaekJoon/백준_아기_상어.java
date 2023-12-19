package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_아기_상어 {
    static int n; // 공간의 가로, 세로 크기
    static Node startNode = null; // 탐색 시작 지점
    static int[][] map; // 공간
    static boolean[][] visited; // 방문배열
    static int[] dx = {0, -1, 1, 0}; // 상, 좌, 우, 하 이동 정보
    static int[] dy = {-1, 0, 0, 1}; // 상, 좌, 우, 하 이동 정보

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) { // 공간의 상태가 9라면 아기 상어가 있는 지점
                    startNode = new Node(j, i, 0); // 아기 상어가 있는 지점을 처음 탐색 시작 지점으로 설정
                }
            }
        }

        System.out.println(bfs()); // 탐색을 시작하고 결과값을 출력
    }

    public static int bfs() {
        int sharkSize = 2; // 아기상어의 크기, 처음은 2이다.
        int ateCount = 0; // 아기상어가 현재 먹은 생선의 수
        int turn = 0; // 현재까지 소요한 시간

        // 아기 상어는 상화좌우로 이동하며, 자신과 가장 가까운 물고리에게 이동한다.
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->
                o2.time != o1.time // 탐생 시작 지점에서 부터 o1, o2 의 거리(도달 시간)을 비교한다.
                        ? o1.time - o2.time // 만약 두 위치의 거리가 같지 않다면 가까운 위치가 우선순위를 가진다.
                        : o1.y != o2.y // 만약 두 위치의 거리가 동일하다면 가장 위 쪽, 즉 y값이 낮은 위치가 우선순위를 가진다.
                        ? o1.y - o2.y : o1.x - o2.x // 만약 y 값 까지 같다면 가장 왼쪽, 즉 x값이 낮은 위치가 우선순위를 가진다.
        );
        map[startNode.y][startNode.x] = 0; // 처음 시작 지점은 상어가 있던 위치, 빈칸이 된다.

        while (true) { // 상어가 물고기를 먹지 못할 때 까지 반복
            visited = new boolean[n][n]; // 방문 배열, 상어가 물고기를 먹으면 초기화 된다.

            q.add(new Node(startNode.x, startNode.y, 0)); // 큐에 탐색 시작지점의 위치정보, 탐색지점으로 부터 도달 시간에 대한 정보를 가진 노드를 추가한다.
            visited[startNode.y][startNode.x] = true; // 탐색시작지점을 방문 체크한다.

            boolean flag = false; // 상어가 물고기를 먹지못하면 false, 상어가 물고기를 먹었다면 true

            while (!q.isEmpty()) { // 큐가 빌 때 까지 반복
                startNode = q.poll(); // 우선순위가 가장 높은 노드를 뽑아 탐색 시작 지점으로 지정한다.

                // 만약 탐색 지점이 0(빈칸)이 아니고 탐색 지점에 있는 물고기의 크기가 현재 상어의 크기보다 작다면 -> 상어가 물고기를 먹는다.
                if (map[startNode.y][startNode.x] != 0 && map[startNode.y][startNode.x] < sharkSize) {
                    map[startNode.y][startNode.x] = 0; // 물고기를 먹었기에 빈칸이 된다.
                    ateCount++; // 먹은 생선의 수 + 1
                    // 현재까지 소요한 시간에 탐색지점 노드의 시간을 더한다.
                    // 현재 startNode.time 은 해당 탐색에서 처음 상어가 있던 위치에서 startNode 의 위치까지 도달한 시간이다.
                    // 큐에서 우선순위를 가진 노드를 가지고 왔기 때문에 해당 로직에 처음 들어오는 노드가 가장 가까운 물고기이다.
                    turn += startNode.time;
                    // 물고기를 먹었다고 표시
                    flag = true;
                    break; // 현재 while 문을 빠져나간다.
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
            if (!flag) { // 만약 상어가 물고기를 먹지 못했다면 엄마 상어를 불러야한다.
                break; // 바깥 while 문을 빠져나간다.
            }

            // 아기상어가 물고기를 먹었다면
            if (sharkSize == ateCount) { // 현재 상어의 크기와 먹은 물고기의 수가 같다면
                sharkSize++; // 상어의 크기를 1 증가시킨다.
                ateCount = 0; // 먹은 물고기의 수를 0으로 초기화 한다.
            }
            // 다음 탐색을 위해 큐를 초기화 한다.
            // 이 때 큐는 초기화 되었지만 아기상어가 마지막으로 도달한 startNode 에 대한 정보는 아직 저장 되어 있기에
            // startNode 의 위치를 탐색 시작지점으로 설정하여 탐색을 이어나간다.
            q.clear();
        }

        return turn; // 엄마 상어를 불렀다면 지금까지 소요한 시간을 반환한다.
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