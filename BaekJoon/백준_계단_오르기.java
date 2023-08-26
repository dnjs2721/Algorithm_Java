package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_계단_오르기 {

    static int[] stair;
    static Integer[] dp;
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(reader.readLine());
        stair = new int[t + 1];
        dp = new Integer[t + 1];
        for (int i = 1; i <= t; i++) {
            stair[i] = Integer.parseInt(reader.readLine());
        }

        dp[0] = 0;
        dp[1] = stair[1];

        if (t >= 2) {
            dp[2] = stair[2] + stair[1]; // 0에서 2 보다 무조건 큼
        }

        System.out.println(scan(t));
    }

    public static int scan(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(scan(n - 2), scan(n - 3) + stair[n - 1]) + stair[n];
        }

        return dp[n];
    }
}

