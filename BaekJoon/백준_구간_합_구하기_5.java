package BaekJoon;

import java.io.*;
import java.util.*;
public class 백준_구간_합_구하기_5 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            bw.write(scan(x1, y1, x2, y2) + "\n");
        }

        bw.flush();
    }

    public static int scan(int x1, int y1, int x2, int y2) {
        int res = 0;
        for (int i = x1; i <= x2; i++) {
            res += (dp[i][y2] - dp[i][y1 - 1]);
        }
        return res;
    }
}

//1  3  6  10         DP[1]
//2  5  9  14         DP[2]
//3  7  12 18         DP[3]
//4  9  15 22         DP[4]
//\
//[x1, y1] = [2, 2]
//[x2, y2] = [3, 4]
//
//DP[2][4] - DP[2][1] + DP[3][4] + DP[3][1]
//    = 14 - 2 + 18 - 3
//    = 12 + 15
//    = 27
//DP[X1][Y2] - DP[X1][Y1 - 1] + DP[X2][Y2] - DP[X2][Y1 - 1]
//
//[x1, y1] = [3, 4]
//[x2, y2] = [3, 4]
//
//IF (X1 == X2 && Y1 == Y2) arr[x1][y1]
//
//[x1, y1] = [1, 1]
//[x2, y2] = [4, 4]
//
//DP[1][4] - DP[1][0] + DP[2][4] - DP[2][0] + DP[3][4] - DP[3][0] + DP[4][4] - DP[4][0]
//    = 10 - 0 + 14 - 0 + 18 - 0 + 22 - 0
//    = 10 + 14 + 18+ 22
//    = 24 + 40
//    = 64
//
//int res = 0;
//for (int i = x1; i <= x2; i++) {\
//    res += (DP[i][Y2] - DP[i][Y1 - 1])
//}