package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_동전_1 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[k + 1];
        dp[0] = 1;

        for (int idx = 1; idx <= n; idx++) {
            int coin = Integer.parseInt(br.readLine());
            for (int won = coin; won <= k; won++) {
                dp[won] = dp[won - coin] + dp[won];
            }
        }

        System.out.println(dp[k]);
    }
}

//1 원 짜리로 1 ~ 10원 만들기
//
//1 -> dp[1] = dp[1] + dp[0] -> 0 + 1 = 1
//1 1 -> dp[2] = dp[2] + dp[1] -> 0 + 1 = 1
//1 11 -> dp[3] = dp[3] + dp[2] -> 0 + 1 = 1
//1 111
//1 1111
//
//2 원 짜리로 2 ~ 10원 만들기
//
//1
//11, 2 -> dp[2] = dp[2] + dp[0] -> 1 + 1 = 2
//111, 2 1 -> dp[3] = dp[3] + dp[1] -> 1 + 1 = 2
//1111, 2 11, 2 2 -> dp[4] = dp[4] + dp[2]; -> 1 + 2 -> 3
//11111, 2 111, 2 21
//111111, 2 1111, 2 211, 2 22
//
//5 원 짜리로 5 ~ 10원 만들기
//
//1
//11, 2
//111, 21
//1111, 211, 22
//11111, 2111, 221, 5 -> dp[5] = dp[5] + dp[0] -> 3 + 1 = 4
//111111, 21111, 2211, 222, 5 1 -> dp[6] = dp[6] + dp[1] -> 4 + 1 = 5
//1111111, 211111, 22111, 2221, 5 11, 5 2 -> dp[7] = dp[7] + d[2] -> 4 + 2 = 6
//
//dp[i] = dp[i] + dp[i - coin];