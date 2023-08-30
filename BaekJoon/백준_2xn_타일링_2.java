package BaekJoon;

import java.io.*;
public class 백준_2xn_타일링_2 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        dp[1] = 1;
        if (n >= 2) dp[2] = 3;

        System.out.println(scan(n));
    }

    public static int scan(int n) {
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
        }
        // dp[i - 1] -> i 블럭이 세로 1 * 2 인 경우
        // dp[i - 2] * 2 -> i 블럭이 2 * 1 2개 혹은 2 * 2 인 경우

        return dp[n];
    }
}
