package Programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PCCP_기출문제_2번_석유_시추 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}}));
        System.out.println(solution(new int[][]{
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}}));
    }

    static int[] dx = {0, 0, -1, 1}; // 상하좌우 x에 대한 이동 값
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우 y에 대한 이동 값
    static int n, m; // 지도의 세로, 가로
    static int[][] map;
    static HashMap<Integer, Integer> hole = new HashMap<>(); // 넘버링된 구역의 석유의 양이 key, value형태로 저장
    static int holeIdx = 2; // 0 과 1은 각각 빈 땅, 석유 라는 뜻을 가지고 있기에 2부터 시작

    public static int solution(int[][] land) {
        int answer = 0;

        n = land.length;
        m = land[0].length;
        map = land;

        // 지도 전체 탐색
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 값이 1인 지역은 석유가 있는 지역
                // 0인 지역은 석유가 없으며 1보다 큰 지역은 이미 탐색을 완료한 구역
                if (map[j][i] == 1) { // 석유가 있는 지역에 한해 bfs 탐색
                    bfs(i, j); // bfs 탐색이 완료된 지역은 넘버링이 된다.
                }
            }
        }

        // 획득 가능한 석유 체크
        for (int i = 0; i < m; i++) {
            // 중복을 방지하기 위한 구덩이 방문 배열
            boolean[] visited = new boolean[holeIdx + 1]; // 열이 바뀔 때 마다 초기화
            int res = 0; // 해당 열에 시추관을 뚫었을 때 얻을 수 있는 석유의 양
            for (int j = 0; j < n; j++) {
                if (map[j][i] == 0) continue; // 탐색 지역이 석유가 없다면 continue

                int cur = map[j][i]; // 0이 아닌 지역의 구덩이 넘버
                if (visited[cur]) continue; // 만약 이번 시추관 탐색 중 이미 탐색한 구덩이라면 continue
                visited[cur] = true; // 구덩이 방문 체크
                res += hole.get(cur); // 해당 구덩이의 석유의 양을 res에 더한다.
            }

            // 위의 탐색이 끝이나면 res는 해당 시추관을 뚫었을 때 얻을 수 있는 석유의 양이 된다.
            answer = Math.max(answer, res); // 탐색을 통해 얻을 수 있는 최대 석유의 양을 도출한다.
        }

        return answer; // 정답 출력
    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>(); // LinkedList를 이용하여 큐 생성
        int count = 1; // 해당 탐색에서 발견한 석유의 양

        // 메모리 사용을 줄이기 위하여 방문을 위한 배열 생성 대신 입력 받은 지도를 수정한다.
        // 0, 1 : 미탐색 지역, 2 ~ : 탐색을 완료하고 넘버링 된 지역
        map[y][x] = holeIdx; // 탐색 지역 넘버링:방문처리
        q.add(new Node(x, y)); // 탐색을 위해 큐에 노드 추가

        while (!q.isEmpty()) { // 큐가 빌 때 까지 반복
            Node node = q.poll(); // 큐의 선입선출에 의해 먼저 들어간 Node 추출
            for (int i = 0; i < 4; i++) { // Node의 위치에서 상하좌우 탐색
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                // 탐색 지역이 범위를 벗어난 지역이라면 continue
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                // 탐색 지역이 빈 땅이라면 continue
                if (map[ny][nx] == 0) continue;
                // 탐색 지역이 1이 아닌 다른 수
                // 이미 넘버링 된 지역이기에 continue
                if (map[ny][nx] != 1) continue;
                // 탐색 지역 넘버링:방문처리
                map[ny][nx] = holeIdx;
                // 다음 탐색을 이어가기 위해 탐색지역을 큐에 추가
                q.add(new Node(nx, ny));
                // 발견한 석유의 양 증가
                count++;
            }
        }

        // hole에 holeIdx를 key, 탐색한 석유의 양을 value로 hashMap에 저장합니다.
        hole.put(holeIdx, count);
        // 다음 넘버링을 위해 holeIdx++
        holeIdx++;
    }

    // bfs 탐색을 위해 사용되는 클래스
    // 격자 모양의 지도의 특정 위치에 대한 위치정보를 담고있다.
    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}