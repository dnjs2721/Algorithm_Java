package BaekJoon;

import java.io.*;

public class 백준_오르막_수 {
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 1][10];
        long[] res = new long[n + 1];
        res[0] = 1;

        long answer = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (res[i - 1] + 10007 - dp[i - 1][j - 1] + dp[i][j - 1]) % 10007;
            }
            res[i] = dp[i][9];
            answer += res[i];
        }
        System.out.println(answer % 10007);
    }
}

//0 1 2 3 4 5 6 7 8 9
//\
//sum[0] = 0
//sum[1] = 9
//        DP[1][1]  = 1
//        1
//        DP[1][2]  = 2
//        2
//        DP[1][3]  = 3
//        3
//        DP[1][4]  = 4
//        4
//        DP[1][5]  = 5
//        5
//        DP[1][6]  = 6
//        6
//        DP[1][7]  = 7
//        7
//        DP[1][8]  = 8
//        8
//        DP[1][9]  = 9
//        9
//
//sum[2] = 45
//        DP[2][1] = sum[1] = 9
//        11 12 13 14 15 16 17 18 19
//        DP[2][2] = sum[1] - DP[1][1] = 8 + DP[2][1] = 17
//        22 23 24 25 26 27 28 29
//        DP[2][3] = sum[1] - DP[1][2] = 7 + DP[2][2] = 24
//        33 34 35 36 37 38 39
//        DP[2][4] = sum[1] - DP[1][3] = 30
//        44 45 46 47 48 49
//        DP[2][5] = sum[1] - DP[1][4] = 35
//        55 56 57 58 59
//        DP[2][6] = sum[1] - DP[1][5] = 39
//        66 67 68 69
//        DP[2][7] = sum[1] - DP[1][6] = 42
//        77 78 79
//        DP[2][8] = sum[1] - DP[1][7] = 44
//        88 89
//        DP[2][9] = sum[1] - DP[1][8] = 45
//        99
//
//dp[3]   DP[3][1] = sum[2] = 45
//        110 111 112 113 114 115 116 117 118 ~ 199
//        DP[3][2] = sum[2] - DP[2][1] = 36 + DP[3][1] = 81
//        DP[3][3] = sum[2] - DP[2][2] = 28 + DP[3][2] = 109
//        DP[3][4] = sum[2] - DP[2][3] = 21 + DP[3][3] = 130
//        DP[3][5] = sum[2] - DP[2][4] = 15 + DP[3][4] = 145
//        DP[3][6] = sum[2] - DP[2][5] = 10 + DP[3][5] = 155
//        DP[3][7] = sum[2] - DP[2][6] =  6 + DP[3][6] = 161
//        DP[3][8] = sum[2] - DP[2][7] =  3 + DP[3][7] = 164
//        DP[3][9] = sum[2] - DP[2][8] =  1 + DP[3][8] = 165
//
//
//for (int i = 1; i <= n; i++) {
//    dp[i][1] = dp[i - 1][9];
//    for (int j = 2; j <= 9; j++) {
//        dp[i][j] = dp[i][1] - dp[i - 1][j - 1]
//    }
//}