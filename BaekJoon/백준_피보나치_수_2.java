package BaekJoon;

import java.io.*;
public class 백준_피보나치_수_2 {
    static Long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Long[n + 1];
        dp[0] = 0L;
        dp[1] = 1L;
        System.out.println(scan(n));
    }

    public static long scan(int n) {
        if (dp[n] == null) {
            dp[n] = scan(n - 2) + scan(n - 1);
        }

        return dp[n];
    }
}
