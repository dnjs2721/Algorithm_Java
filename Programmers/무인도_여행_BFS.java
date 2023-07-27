package Programmers;

import java.util.*;

public class 무인도_여행_BFS {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
    }

    public static int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        List<Integer> res = new ArrayList<>();
        int[][] visited = new int[n][m];  // 방문 여부 확인 배열 생성 초기화

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && visited[i][j] == 0) { //maps 를 돌며 X 아니면서 방문하지 않은곳
                    res.add(bfs(n, m, i, j, maps, visited)); // bfs 결과 저장
                }
            }
        }

        if (res.isEmpty()) { // res 가 비어있다면 지낼 수 있는 무인도가 없다는 뜻
            return new int[]{-1};
        }

        int[] answer = res.stream().mapToInt(Integer::intValue).toArray(); // List<Integer> 를 int[] 로 변환
        Arrays.sort(answer); // answer 를 오름차순으로 정렬

        return answer;
    }

    public static int bfs(int n, int m, int sy, int sx, String[] maps, int[][] visited) {
        int[] dy = {-1, 1, 0, 0}; // 상, 하
        int[] dx = {0, 0, -1, 1}; // 좌, 우

        visited[sy][sx] = 1; // 방문 체크

        Queue<int[]> q = new LinkedList<>(); // 큐 생성
        q.add(new int[]{sy, sx}); // 시작 지점 q에 삽입

        int bfsResult = Integer.parseInt(String.valueOf(maps[sy].charAt(sx))); // 시작 섬의 식량 수

        while (!q.isEmpty()) { // 큐에 값이 없을 때 까지
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                // 지도의 범위, 바다, 방문 여부 체크
                if (ny < 0 || ny >= n || nx < 0 || nx >= m || maps[ny].charAt(nx) == 'X' || visited[ny][nx] > 0) {
                    continue;
                }
                visited[ny][nx] = 1; // 방문 체크
                bfsResult += Integer.parseInt(String.valueOf(maps[ny].charAt(nx))); // 섬의 식량 추가
                q.add(new int[]{ny, nx});
            }
        }
        return bfsResult;
    }
}
