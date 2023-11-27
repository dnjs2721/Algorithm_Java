package BaekJoon;

import java.io.*;

public class 백준_동물원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = mod(dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]);
            dp[i][1] = mod(dp[i - 1][0] + dp[i - 1][2]);
            dp[i][2] = mod(dp[i - 1][0] + dp[i - 1][1]);
        }

        System.out.println(mod(dp[n][0] + dp[n][1] + dp[n][2]));
    }

    public static long mod(long num) {
        return num % 9901;
    }
}