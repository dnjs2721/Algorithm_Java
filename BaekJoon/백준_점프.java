package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 게임판의 가로 세로 길이

        int[][] map = new int[n][n]; // 게임판, map[i][j]에는 (i, j) 위치에서 이동해야하는 거리가 저장되어 있다.
        long[][] dp = new long[n][n]; // dp[i][j]에는 (i, j)에 도달 한 경우의 수를 나타낸다.

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 입략빋은 게임판의 정보를 저장한다.
            }
        }

        dp[0][0] = 1; // (0, 0) 에서 (n - 1, n - 1)로 이동하는것이 목적이기에 (0, 0)은 1이다.
        for (int i = 0; i < n; i++) { // 게임판 전체구역 탐색
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue; // 만약 게임판의 탐색지점이 0이라면 해당지점에서는 진헹이 불가능하다. continue
                int val = map[i][j]; // map[i][j]에서 이동해야하는 거리
                // 아래로 이동
                if (i + val < n) { // 만약 i + val 이 n보다 작다면 -> 게임판 범위 안
                    // i + val == n - 1 && j == n - 1 -> 이동지역이 도착지점이거나
                    // map[i + val][j] != 0 -> 이동지역이 0(종착지점)이 아니라면
                    // map[n - 1][n - 1]은 항상 0이기에 || 연산을 사용했다.
                    if ((i + val == n - 1 && j == n - 1) || map[i + val][j] != 0) {
                        // 탐색지역에 도달할 수 있는 모든 경우가 이동지역에 도달 할 수 있기에
                        dp[i + val][j] += dp[i][j]; // dp[이동지역] 에 dp[탐색지역] 의 값을 더한다.
                    }
                }

                // 오른쪽 이동
                if (j + val < n) { // 만약 j + val 이 n보다 작다면 -> 게임판 범위 안
                    // i == n - 1 && j + val == n - 1 -> 이동지역이 도착지점이거나
                    // map[i][j + val] != 0 -> 이동지역이 0(종착지점)이 아니라면
                    // map[n - 1][n - 1]은 항상 0이기에 || 연산을 사용했다.
                    if ((i == n - 1 && j + val == n - 1) || map[i][j + val] != 0) {
                        // 탐색지역에 도달할 수 있는 모든 경우가 이동지역에 도달 할 수 있기에
                        dp[i][j + val] += dp[i][j]; // dp[이동지역] 에 dp[탐색지역] 의 값을 더한다.
                    }
                }
            }
        }

        // 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 문제의 규칙에 맞게 갈 수 있는 경로의 개수를 출력한다.
        System.out.println(dp[n - 1][n - 1]);
    }
}