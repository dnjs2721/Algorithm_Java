package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 처음엔 dfs 를 사용하여 문제를 풀려고 하였지만 메모리 제한이 4MB다.
        // 사용할 수 있는 메모리가 작기 때문에 재귀를 이용한 풀이는 힘들다고 판단.
        // dp - 파텀업 채택

        // dp[0][i][j] 는 [i][j] 위치에 도달 했을 때 얻을 수 있는 최대 점수
        // dp[1][i][j] 는 [i][j] 위치에 도달 했을 때 얻을 수 있는 최소 점수
        int[][][] dp = new int[2][n][3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) { // n 줄 만큼 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) { // 가로의 크기는 3으로 정해져있다.
                // 메모리 사용을 줄이기 위해 dp 배열만 사용한다.
                int now = Integer.parseInt(st.nextToken());
                if (i == 0) { // i == 0 이란 뜻은 처음 시작 지점을 뜻한다.
                    dp[0][i][j] = now; // 처음 시작 지점이기에 자신의 값이 최대 점수다.
                    dp[1][i][j] = now; // 처음 시작 지점이기에 자신의 값이 최소 점수다.
                } else { // 1 <= i < n
                    if (j == 0) { // i 줄의 첫번째 칸
                        // 첫번째 칸에 도달 하기 위에서는 이전 줄의 첫번째 칸, 두번째 칸 중에서 출발하여야 한다.
                        // 이전 줄의 출발 지점 중 최대, 최소 점수에서 출발 할 때 현재 위치의 점수가 최대, 최소 점수가 된다,
                        dp[0][i][j] = now + Math.max(dp[0][i - 1][0], dp[0][i - 1][1]);
                        dp[1][i][j] = now + Math.min(dp[1][i - 1][0], dp[1][i - 1][1]);
                    } else if (j == 1) { // i 줄의 두번째 칸
                        // 두번째 칸에 도달 하기 위에서는 이전 줄의 첫번째 칸, 두번째 칸, 세번째 칸 중에서 출발하여야 한다.
                        // 이전 줄의 출발 지점 중 최대, 최소 점수에서 출발 할 때 현재 위치의 점수가 최대, 최소 점수가 된다,
                        dp[0][i][j] = now + Math.max(dp[0][i - 1][0], Math.max(dp[0][i - 1][1], dp[0][i - 1][2]));
                        dp[1][i][j] = now + Math.min(dp[1][i - 1][0], Math.min(dp[1][i - 1][1], dp[1][i - 1][2]));
                    } else { // i 줄의 세번째 칸
                        // 세번째 칸에 도달 하기 위에서는 이전 줄의 두번째 칸, 세번째 칸 중에서 출발하여야 한다.
                        // 이전 줄의 출발 지점 중 최대, 최소 점수에서 출발 할 때 현재 위치의 점수가 최대, 최소 점수가 된다,
                        dp[0][i][j] = now + Math.max(dp[0][i - 1][1], dp[0][i - 1][2]);
                        dp[1][i][j] = now + Math.min(dp[1][i - 1][1], dp[1][i - 1][2]);
                    }
                }
            }
        }

        int max = Arrays.stream(dp[0][n - 1]).max().orElse(0);
        // 마지막 줄 중 가장 작은 점수
        int min = Arrays.stream(dp[1][n - 1]).min().orElse(0);

        System.out.printf("%d %d", max, min);
    }

    // 가장 적은 메모리와 가장 빠른 시간
    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[2][3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int n0 = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            int max0 = n0 + Math.max(dp[0][0], dp[0][1]);
            int min0 = n0 + Math.min(dp[1][0], dp[1][1]);

            int max1 = n1 + Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));
            int min1 = n1 + Math.min(dp[1][0], Math.min(dp[1][1], dp[1][2]));

            int max2 = n2 + Math.max(dp[0][1], dp[0][2]);
            int min2 = n2 + Math.min(dp[1][1], dp[1][2]);

            dp[0][0] = max0;
            dp[0][1] = max1;
            dp[0][2] = max2;
            dp[1][0] = min0;
            dp[1][1] = min1;
            dp[1][2] = min2;
        }


        int max = Arrays.stream(dp[0]).max().orElse(0);
        int min = Arrays.stream(dp[1]).min().orElse(0);

        System.out.printf("%d %d", max, min);
    }
}