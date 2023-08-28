package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_연속합 {

    public static void main(String[] args) throws IOException{
        int answer = Integer.MIN_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i];
            answer = Math.max(answer, arr[i]);
        }
        dp[1] = tmp;

        for (int i = 2; i <= n; i++) {
            tmp = new int[n - i + 1];
            for (int j = 0; j <= n - i; j++) {
                tmp[j] = dp[i - 1][j] + dp[1][i + j - 1];
                answer = Math.max(answer, tmp[j]);
            }
            dp[i] = tmp;
        }

        System.out.println(answer);
    }
}

//9                 45
//8               36  44
//7             28  35  41
//6           21  27  32  39
//5         15  20  25  30  35
//4       10  14  18  22  26  30
//3      6   9  12  15  18  21  30
//2    3   5   7   9  11  13  14  17
//1  1   2   3   4   5   6   7   8   9
//
//dp[2][0] = dp[1][0] + dp[1][1]
//dp[2][1] = dp[1][1] + dp[1][2]
//dp[2][7] = dp[1][7] + dp[1][8]
//
//dp[3][0] = dp[2][0] + dp[1][2]
//dp[3][1] = dp[2][1] + dp[1][3]
//dp[3][2] = dp[2][2] + dp[1][4]
//dp[3][3] = dp[2][3] + dp[1][5]
//dp[3][4] = dp[2][4] + dp[1][6]
//dp[3][5] = dp[2][5] + dp[1][7]
//dp[3][6] = dp[2][6] + dp[1][8]
//
//dp[4][0] = dp[3][0] + dp[1][3];

//dp[i][j] = dp[i - 1][j] + dp[1][i + j - 1];