package BaekJoon;

import java.io.*;
public class 백준_이친수 {
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


//1
//10
//10 0, 10 1
//10 00, 10 01, 10 10
//10 000, 10 001, 10 010, 10 100, 10 101
//10 0000, 10 0001, 10 0010, 10 0100, 10 0101, 10 1000, 10 1001, 10 1010
//
//dp[1] = 1;
//dp[2] = 1;
//dp[3] = dp[1] + dp[2] = 2;
//dp[4] = dp[2] + dp[3] = 3
//dp[5] = dp[3] + dp[4] = 5