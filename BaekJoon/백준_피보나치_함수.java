package BaekJoon;

import java.io.*;

public class 백준_피보나치_함수 {
    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int t = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            fibonacci(n);
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append('\n');
        }
        System.out.println(sb);
    }

    public static Integer[] fibonacci(int n) {
        if (dp[n][0] == null || dp[n][1] == null) {
            Integer[] res1 = fibonacci(n - 1);
            Integer[] res2 = fibonacci(n - 2);
            dp[n][0] = res1[0] + res2[0];
            dp[n][1] = res1[1] + res2[1];
        }

        return dp[n];
    }
}
