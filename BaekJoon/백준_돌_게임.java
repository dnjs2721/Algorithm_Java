package BaekJoon;

import java.io.*;

public class 백준_돌_게임 {
    static String[] dp;
    static int[] x = new int[]{1, 3};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new String[n + 1];

        // 풀이 1) NO_DP
        if (n % 2 == 1) System.out.println("SK");
        else System.out.println("CY");

        // 풀이 2) USE_DP
        System.out.println(scan(n, true));
    }

    public static String scan(int n, boolean type) {
        if (n == 0) {
            if (type) return dp[0] = "CY";
            else return dp[0] = "SK";
        }

        if (dp[n] != null) {
            return dp[n];
        }

        for (int get : x) {
            if (n - get >= 0) dp[n] = scan(n - get, !type);
        }

        return dp[n];
    }
}
