package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_퇴사 {
    static int[][] arr;
    static Integer[] dp;
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 2][2];
        dp = new Integer[N + 2];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        dp[N + 1] = 0;
        scan(N);
        System.out.println(answer);
    }

    public static void scan(int day) {
        int t = arr[day][0];
        if (day + t - 1 > N) {
            dp[day] = dp[day + 1];
            scan(day - 1);
        } else {
            if (dp[day] == null) {
                dp[day] = Math.max(arr[day][1] + dp[day + t], dp[day + 1]);
                answer = Math.max(answer, dp[day]);
                scan(day - 1);
            }
        }
    }
}

//7
//6
//5 -> dp[5] = 15 + dp[7] = 15
//4 -> dp[4] = 20 + dp[5] = 35
//3 -> dp[3] = 10 + dp[4] = 45
//2 -> dp[2] = 10 + dp[7] = 10
//1 -> dp[1] = 10 + dp[4] = 45

//1  2  3  4  5  6  7  8  9  10
//5  4  3  2  1  1  2  3  4  5
//50 40 30 20 10 10 20 30 40 50

