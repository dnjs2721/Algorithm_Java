package BaekJoon;

import java.io.*;

public class 백준_파도반_수열 {
    static Long[] dp = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        long[] tmp = new long[]{1, 1, 1, 2, 2, 3, 4, 5, 7};

        for (int i = 1; i <= 9; i++) {
            dp[i] = tmp[i - 1];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n <= 9) {
                System.out.println(dp[n]);
            } else { // n 이 10 이상일 때
                System.out.println(scan(n));
            }
        }
    }

    public static long scan(int n) {
        if (dp[n] == null) {
            dp[n] = scan(n - 1) + scan(n - 5);
        }
        return dp[n];
    }
}