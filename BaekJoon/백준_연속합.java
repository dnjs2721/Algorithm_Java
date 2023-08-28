package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_연속합 {

    static int answer;
    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        answer = dp[0];

        scan(n - 1);

        System.out.println(answer);
    }

    public static int scan(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(scan(n - 1) + arr[n], arr[n]);
            answer = Math.max(answer, dp[n]);
        }

        return dp[n];
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