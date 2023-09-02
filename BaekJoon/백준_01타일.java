package BaekJoon;

import java.io.*;

public class 백준_01타일 {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        if (n >= 2) dp[2] = 2;

        System.out.println(scan(n));
    }

    public static int scan(int n) {
        if (dp[n] == null) {
            dp[n] = (scan(n - 2) + scan(n - 1)) % 15746;
        }
        // scan(n - 2) -> n 자리 수의 앞자리가 00 일 때 남은자리(n - 2)의 경우의 수를 구한다. dp[n - 2]
        // scan(n - 1) -> n 자리 수의 앞자리가 1 일 때 남은자리(n - 1)의 경우의 수를 구한다. dp[n - 1]
        // n >= 3 일 떄 dp[n] = dp[n - 2] + dp[n - 1] 이다.

        return dp[n];
    }
}

//1 1
//2 00 11
//3 00 1, 1 00, 1 11
//4 00 00, 00 11, 1 001, 1 100 1 111
//5 00 001, 00 100, 00 111, 1 0000, 1 0011, 1 0001, 1 100, 1 1111
//
//dp[1] = 1;
//dp[2] = 2;
//dp[3] = 3;
//dp[4] = 5;
//
//dp[5] = dp[3] + dp[4]
//dp[4] = dp[2] + dp[3]
//dp[3] = dp[1] + dp[2]