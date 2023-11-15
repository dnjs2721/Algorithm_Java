package BaekJoon;

import java.io.*;

public class 백준_제곱수의_합 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 2; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}