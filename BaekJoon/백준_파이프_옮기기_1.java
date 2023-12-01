package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_파이프_옮기기_1 {
    static int n;
    static int[][] map;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader를 통해 입력값을 전달 받는다.

        n = Integer.parseInt(br.readLine()); // 가로, 세로 크기 초기화
        map = new int[n + 1][n + 1]; // 1 부터 n 까지의 인덱스를 사용하기 위헤 n + 1 크기로 초기화

        StringTokenizer st; // StringTokenizer : 전달받은 문자열을 지정한 구분자로 문자열을 분리해주는 클래스
        for (int i = 1; i <= n; i++) { // 1 부터 n 까지
            st = new StringTokenizer(br.readLine()); // br을 통해 입력 받은 문자열을 분리, default 공백 문자들인 "\t\n\r\t"
            for (int j = 1; j <= n; j++) { // 1 부터 n 까지
                map[i][j] = Integer.parseInt(st.nextToken()); // 분리된 문자열은 token 이라 불리며 순서대로 정수형으로 변환 후 map[i][j]에 저장
            }
        }

        // 파이프의 오른쪽 끝부분의 위치 정보 y, x
        // 현재 파이프가 놓인 방향을 나타내는 type -> 0: 가로, 1: 세로, 2: 대각선
        // 처음 시작은 [1, 1] 과 [1, 2] 의 위치를 차지하고 있는 가로로 놓인 파이프이다.
        dfs(1, 2, 0); // dfs 탐색 시작

        System.out.println(answer);
    }

    public static void dfs(int y, int x, int type) {
        if (x == n && y == n) { // n, n 위치에 도달했다면
            answer++; // 도착 할 수 있는 경우의 수 + 1
            return; // 탐색 종료
        }

        switch (type) {
            case 0 : // 현재 파이프가 가로(→)로 놓여진 경우
                // 가로로 놓인 파이프는 →, ↘ 방항으로 이동 가능하다.
                // →, ↘ 방향 모두 [y][x + 1]의 위치가 포함되기에 [y][x + 1]의 위치가 탐색 가능한 지역이여야만 한다.
                if (x + 1 > n) return;  // x + 1이 범위 밖 이라면 이동할 방법이 없기에 해당 파이프에 대한 탐색을 종료한다.
                if (map[y][x + 1] == 1) return; // [y][x + 1]이 벽 이라면 이동할 방법이 없기에 해당 파이프에 대한 탐색을 종료한다.
                dfs(y, x + 1, 0); // [y][x + 1]의 위치가 탐색 가능한 지역이라면 가로 방향으로 재귀 탐색

                // ↘ 방향이 가능한지 겁사
                if (y + 1 > n) return; // y + 1이 범위 밖 이라면 ↘ 방향으로 탐색이 불가능 하기에 해당 파이프에 대한 탐색을 종료한다.
                if (map[y + 1][x] == 1 || map[y + 1][x + 1] == 1) return; // [y + 1][x], [y + 1][x + 1] 이 벽이라면 ↘ 방향으로 탐색이 불가능 하기에 해당 파이프에 대한 탐색을 종료한다.
                dfs(y + 1, x + 1, 2); // ↘ 방향으로 탐색이 가능하다면 ↘ 방향으로 재귀 탐색
                break;

            case 1 :  // 현재 파이프가 세로(↓)로 놓여진 경우
                // 세로로 놓인 파이프는 ↓, ↘ 방항으로 이동 가능하다.
                // ↓, ↘ 방향 모두 [y + 1][x]의 위치가 포함되기에 [y + 1][x]의 위치가 탐색 가능한 지역이여야만 한다.
                if (y + 1 > n) return; // y + 1이 범위 밖 이라면 이동할 방법이 없기에 해당 파이프에 대한 탐색을 종료한다.
                if (map[y + 1][x] == 1) return; // [y + 1][x]가 벽 이라면 이동할 방법이 없기에 해당 파이프에 대한 탐색을 종료한다.
                dfs(y + 1, x, 1); // [y + 1][x]의 위치가 탐색 가능한 지역이라면 세로 방향으로 재귀 탐색

                // ↘ 방향이 가능한지 겁사
                if (x + 1 > n) return; // x + 1이 범위 밖 이라면 ↘ 방향으로 탐색이 불가능 하기에 해당 파이프에 대한 탐색을 종료한다.
                if (map[y][x + 1] == 1 || map[y + 1][x + 1] == 1) return; // [y][x + 1], [y + 1][x + 1] 이 벽이라면 ↘ 방향으로 탐색이 불가능 하기에 해당 파이프에 대한 탐색을 종료한다.
                dfs(y + 1, x + 1, 2); // ↘ 방향으로 탐색이 가능하다면 ↘ 방향으로 재귀 탐색
                break;

            case 2 : // 현재 파이프가 대각선(↘)으로 놓아진 경우
                 if (x + 1 <= n && map[y][x + 1] == 0) { // [y][x + 1] 이 탐색 가능한 지역일 경우
                     dfs(y, x + 1, 0); // 가로 방향으로 재귀 탐색
                 }
                 if (y + 1 <= n && map[y + 1][x] == 0) { // [y + 1][x] 가 탐색 가능한 지역일 경우
                     dfs(y + 1, x, 1); // 세로 방향으로 재귀 탐색

                     if (x + 1 <= n && map[y][x + 1] == 0 && map[y + 1][x + 1] == 0) {  // 가로, 세로 방향 모두 가능 하고, map[y + 1][x + 1]가 빈 칸 인 경우
                         dfs(y + 1, x + 1, 2); // 대각선 방향으로 재귀 탐색
                     }
                 }
                 break;
        }
    }
}