package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 무인도_여행_DFS {

    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
    }

    public static int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[][] visited = new int[n][m];  // 방문 여부 확인 배열 생성 초기화

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && visited[i][j] == 0) { //maps 를 돌며 X 아니면서 방문하지 않은곳
                    res.add(0); // 결과 List 에 0 추가
                    dfs(i, j, maps, visited); // dfs 실행
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

    public static void dfs(int sy, int sx, String[] maps, int[][] visited) {

        // 지도의 범위, 바다, 방문 여부 체크
        if (sy < 0 || sy >= maps.length || sx < 0 || sx >= maps[0].length() ||
                maps[sy].charAt(sx) == 'X' || visited[sy][sx] > 0) {
            return;
        }

        visited[sy][sx] = 1; // 방문 체크
        int val = res.get(res.size() - 1); // 결과 리스트의 마지막 값을 가지고 온다.
        val += Integer.parseInt(String.valueOf(maps[sy].charAt(sx))); // 가지고 온 값에 현재 섬의 식략 수를 더한 후
        res.set(res.size() - 1, val); // 다시 리스트의 마지막에 추가한다.

        dfs(sy - 1, sx, maps, visited); // 상
        dfs(sy + 1, sx, maps, visited); // 하
        dfs(sy, sx - 1, maps, visited); // 좌
        dfs(sy, sx + 1, maps, visited); // 우
    }
}
