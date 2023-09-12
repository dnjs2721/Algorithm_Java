package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_안전_영역 {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n]; // 높이의 정보를 가진다.
        visited = new boolean[n][n]; // 탐색 방문 기록을 담는다.

        Set<Integer> set = new HashSet<>(); // 높이의 종류를 담는 집합
        StringTokenizer st;
        for (int i = 0; i < n; i++) { // 높이의 정보와 종류를 입력한다.
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int h = Integer.parseInt(st.nextToken());
                map[i][j] = h;
                set.add(h);
            }
        }
        br.close();

        int answer = 0;
        for (Integer i : set) { // 높이의 종류를 순회하며 현재 침수 높이를 나타낸다.
            visited = new boolean[n][n]; // 높이가 변경될 때 마다 안전 영역 탐색이 필요하다.
            int res = 0; // 안전 영역의 갯수

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (map[y][x] > i) { // 해당 지역의 높이가 침수 높이보다 높다면
                        if (visited[y][x]) continue; // 방문한 지역은 통과한다.
                        dfs(x, y, i); // 깊이 우선 탐색, 탐색이 끝나며 침수가 되지 않았고 인접한 지역들은 방문체크 된다.
                        res++; // 안전 영역 카운트
                    }
                }
            }
            answer = Math.max(answer, res);
        }

        if (answer == 0) {  // answer 이 0인 경우는 높이의 종류가 하나밖에 없을 때 이다.
            System.out.println(1);  // 높이의 종류가 하나밖에 없기에 해당 높이 전까지는 안전 영역이 1이다.
            return;
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int h) {
        visited[y][x] = true; // 방문 체크
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; // 지도의 범위를 벗어나면 안된다.
            if (visited[ny][nx]) continue; // 방문한 지역은 제외한다.
            if (map[ny][nx] <= h) continue; // 해당 지역의 높이가 침수되었으면 제외한다.
            dfs(nx, ny, h);
        }
    }
}