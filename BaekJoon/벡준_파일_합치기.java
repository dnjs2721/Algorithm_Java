package BaekJoon;

import java.util.*;
import java.io.*;

public class 벡준_파일_합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] files = new int[n + 1]; // files[i] = 1번 부터 i번 까지의 합
            int[][] dp = new int[n + 1][n + 1]; // dp[s][e] = s 부터 e까지 합할 때 최소한의 비용

            st = new StringTokenizer(br.readLine());

            files[1] = Integer.parseInt(st.nextToken()); // 1번까지의 합은 1번이랑 같다.
            for (int i = 2; i <= n; i++) { // 2번 부터 n번 까지
                int val = Integer.parseInt(st.nextToken()); // 현재 번호의 값
                files[i] = val + files[i - 1]; // 현재번호의 값과 이전 번호까지의 누적합을 더하면 현재 번호까지의 누적합
            }

            for (int bundle = 1; bundle < n; bundle++) { // 시작 번호부터 몇장을 묶을 것인가?
                for (int start = 1; start + bundle <= n; start++) { // 시작 번호가 몇번인가?
                    int end = start + bundle;
                    // bundle 이 증가하기 때문에 똑같은 [start][end]를 탐색할 일은 없다.
                    dp[start][end] = Integer.MAX_VALUE; // min 비교를 위해 [start][end] 는 최대값

                    // 시작 번호부터 끝 번호 사이의 범위
                    for (int middle = start; middle < end; middle++) { // middle 지점을 기준으로 나눈다.
                        dp[start][end] = Math.min( // start ~ end 구간의 최소 비용을 구한다.
                                dp[start][end], // 이미 저장된 start ~ end 구간의 비용
                                dp[start][middle] + dp[middle + 1][end] + (files[end] - files[start - 1])
                                // middle 을 기준으로 나눠서 계산 후 start ~ end 의 부분합을 더한다.
                        );
                    }
                }
            }
            System.out.println(dp[1][n]);
        }
    }
}

// 주어진 소설 파일들은 연속적인 장이다. 그러므로 정렬해서 푸는 방식은 불가능, 무조건 연속된 두 파일을 합쳐야한다.
// 마지막으로 파일을 합칠 때는 전체 합이랑 동일한 값

// 1번 예제 40 30 30 50
// 40 + ((30 + 30) + 50)
// 40 + (30 + (30 + 50))
// (40 + 30) + (30 + 50)
// ((40 + 30) + 30) + 50

// 40 30 30 3개로 가정
// 40 + (30 + 30) -> DP[1][1] + DP[2][3]
// (40 + 30) + 30 -> DP[1][2] + DP[3][3]
// DP[1][3] = Math.min(DP[1][1] + DP[2][3], DP[1][2] + DP[3][3])

// 40 30 30 50
// 40 + ((30 + 30) + 50) -> DP[1][1] + DP[2][4]
// 40 + (30 + (30 + 50)) -> DP[1][1] + DP[2][4]
    // DP[2][4] = 30 + 30 + 50
    // 30 + (30 + 50) -> DP[2][2] + DP[3][4]
    // (30 + 30) + 50 -> DP[2][3] + DP[4][4]
    // DP[2][4] = Math.min(DP[2][2] + DP[3][4], DP[2][3] + DP[4][4])

// (40 + 30) + (30 + 50) -> DP[1][2] + DP[3][4]

// (40 + (30 + 30)) + 50 -> DP[1][3] + DP[4][4]
// ((40 + 30) + 30) + 50 -> DP[1][3] + DP[4][4]
    // 40 + (30 + 30) -> DP[1][1] + DP[2][3]
    // (40 + 30) + 30 -> DP[1][2] + DP[3][3]
    // DP[1][3] = Math.min(DP[1][1] + DP[2][3], DP[1][2] + DP[3][3])

// m = 1; m < e; m++
// DP[s][e] = Math.min(DP[s][e], DP[s][m] + DP[m + 1][e])

// 최적의 방법으로 파일을 묶는 점화식은 찾았는데... 비용은 어쩌지
// f[n + 1] : f[1] = 40, f[2] = 70, f[3] = 100, f[4] = 150
// 1번에서 2번까지의 합은 f[2] = 70
// 1번에서 3번까지의 합은 f[3] = 100
// 2번에서 3번까지의 합은 f[3] - f[1] = 60
// 2번에서 4번까지의 합은 f[4] - f[1] = 110

// DP[1][4]
// DP[1][1] + DP[2][4] -> 1부터 4까지의 합 f[4]가 필요 -> f[4] - f[0]
    // DP[1][1]
        // 1부터 1까지 = f[1] - f[0]
    // DP[2][4]
        // DP[2][2] + DP[3][4]
            // 2부터 4까지 = f[4] - f[1]
        // DP[2][3] + DP[4][4]
            // 2부터 4까지 = f[4] - f[1]
// DP[1][2] + DP[3][4]
// DP[1][3] + DP[4][4]

// m = 1; m < e; m++
// DP[s][e] = Math.min(DP[s][e], DP[s][m] + DP[m + 1][e] + (f[e] - f[s - 1]))