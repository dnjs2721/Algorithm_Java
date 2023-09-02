package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_평범한_배낭 {

    static Integer[][] dp;
    static int[][] arr;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        dp = new Integer[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(scan(n, k));
    }

    public static int scan(int i, int k) {
        if (i == 0) {
            return 0;
        }
        if (dp[i][k] == null) {
            if (arr[i][0] > k) {
                dp[i][k] = scan(i - 1, k);
            } else {
                dp[i][k] = Math.max(scan(i - 1, k), scan(i - 1, k - arr[i][0]) + arr[i][1]);
            }
        }

        return dp[i][k];
    }
}
