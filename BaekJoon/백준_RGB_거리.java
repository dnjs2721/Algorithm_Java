package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_RGB_거리 {
    static int[][] cost;
    static int[][] dp;
    static int red = 0;
    static int green = 1;
    static int blue = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        cost = new int[t][3];
        dp = new int[t][3];

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            cost[i][red] = Integer.parseInt(st.nextToken());
            cost[i][green] = Integer.parseInt(st.nextToken());
            cost[i][blue] = Integer.parseInt(st.nextToken());
        }

        dp[0][red] = cost[0][red];
        dp[0][green] = cost[0][green];
        dp[0][blue] = cost[0][blue];

        System.out.println(Math.min(Math.min(cal(t - 1, red), cal(t - 1, green)), cal(t - 1, blue)));
    }

    public static int cal(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == red) {
                dp[n][red] = Math.min(cal(n - 1, green), cal(n - 1, blue)) + cost[n][red];
            } else if (color == green) {
                dp[n][green] = Math.min(cal(n - 1, red), cal(n - 1, blue)) + cost[n][green];
            } else {
                dp[n][blue] = Math.min(cal(n - 1, red), cal(n - 1, green)) + cost[n][blue];
            }
        }
        return dp[n][color];
    }
}
