package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_다리만들기_2 {
    static int n;
    static int m;
    static int[][] map;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static boolean[][] visited;
    static int islandCount = 0;
    static int[][] bridgeMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) continue; // 바다는 넘어감
                if (visited[i][j]) continue; // 방문섬은 넘어감
                islandCount++; // 섬의 갯수와 현재 섬의 번호를 나타냄
                checkIsland(j, i);
            }
        }

        bridgeMap = new int[islandCount + 1][islandCount + 1];
        for (int i = 1; i <= islandCount; i++) {
            for (int j = 1; j <= islandCount; j++) {
                bridgeMap[i][j] = Integer.MAX_VALUE;
            }
        }
        checkBridge(); // 연결될 수 있는 모든 다리 탐색
        List<Bridge> bridges = new ArrayList<>(); // bridge 객체를 담을 bridges
        for (int i = 1; i <= islandCount; i++) {
            // 시작점 <-> 도착점 이 중복되는 문제가 있음,,
            // bridgeMap[i][i]는 나올 수 없음
            // j가 i보다 작은 것 bridgeMap[i][j] 는 이미 bridgeMap[i][j]에서 확인함
            // 결론 : j의 시작점을 i + 1로
            for (int j = i + 1; j <= islandCount; j++) {
                if (bridgeMap[i][j] == Integer.MAX_VALUE) continue; // 연결 다리가 없음
                bridges.add(new Bridge(i, j, bridgeMap[i][j])); // 시작점, 끝점, 다리 크기
            }
        }
        bridges.sort((o1, o2) -> o1.val - o2.val); // 모든 섬을 연결 할 때 최소한의 다리만 사용해야하니 오름차순 정렬
        System.out.println(bridges);
    }

    public static void checkIsland(int x, int y) { // bfs 를 통해 모든 섬에 고유 번호를 붙인다.
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[y][x] = true;
        map[y][x] = islandCount;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (map[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                map[ny][nx] = islandCount;
                q.add(new Node(nx, ny));
            }
        }
    }

    public static void checkBridge() { // 연결될 수 있는 모든 다리 탐색
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) continue; // 첫 시작이 바다라면 안된다.
                int startIsland = map[i][j]; // 시작 섬
                for (int k = 0; k < 4; k++) { // 사방으로 다리를 놓을 수 있다.
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue; // 범위를 벗어남
                    if (map[ny][nx] == startIsland) continue; // 해당 방향 한칸 앞(map[ny][nx])이 육지라면 섬의 가장자리가 아님
                    // 통과한 map[ny][nx]는 바다를 가리킨다.
                    int bridgeCount = 0;
                    while (true) { // 한 방향으로만 갈 수 있기에 while 채택
                        if (nx < 0 || ny < 0 || nx >= m || ny >= n) break; // 범위 벗어나면 break
                        int next = map[ny][nx];
                        if (next != 0 && next != startIsland) { // next 가 육지이면서 처음시작한 섬과 다른 섬일 때
                            if (bridgeCount > 1) { // 사용한 다리가 2개 이상일 때
                                // startIsland -> nextIsland 최소 거리 갱신
                                bridgeMap[startIsland][next] = Math.min(bridgeMap[startIsland][next], bridgeCount);
                                // nextIsland -> startIsland 최소 거리 갱신
                                bridgeMap[next][islandCount] = Math.min(bridgeMap[next][islandCount], bridgeCount);
                            }
                            break;
                        } else if (startIsland == next) { // 시작 섬이랑 같아진 경우 - 즉 다시 돌아간 경우
                            break;
                        }
                        nx += dx[k];
                        ny += dy[k];
                        bridgeCount++;
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Bridge {
        int start;
        int end;
        int val;
        public Bridge(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
}
