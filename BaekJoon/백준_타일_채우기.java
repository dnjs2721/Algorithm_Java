package BaekJoon;

import java.io.*;

public class 백준_타일_채우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n + 1];
        dp[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            // i 를 크기가 [i - 2]와 [2] 인 두 구역으로 나눈 경우.
            dp[i] = (dp[i - 2] * dp[2]); // i - 2에서 가능한 경우의 수 X 2 에서 가능한 경우의 수

            // n이 4 이상 일 때 n - 2와 상관없는 n에 대한 예외 모양 2개가 나온다.
            dp[i] += 2; // i에 대한 예외 모양 2개

            // i 를 크기가 [j] 와 [i - j] 인 두 구역으로 나눈 경우
            // [j] 가 [i - 2] 와 같은 경우는 위에서 탐색한 부분이기에 [j] 가 [i - 4] 와 같을 때 까지만 탐색한다.
            for (int j = 2; j <= i - 4; j += 2) {
                dp[i] += dp[j] * 2; // j 에서 가능한 경우의 수 X i - j 에 대한 예외 모양 2개
            }
        }

        System.out.println(dp[n]);
    }
}