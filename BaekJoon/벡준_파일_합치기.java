package BaekJoon;

import java.util.*;
import java.io.*;

public class 벡준_파일_합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] files = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];
            st = new StringTokenizer(br.readLine());

            files[1] = Integer.parseInt(st.nextToken());
            for (int i = 2; i <= n; i++) {
                int val = Integer.parseInt(st.nextToken());
                files[i] = val + files[i - 1];
            }

            for (int bundle = 1; bundle < n; bundle++) {
                for (int start = 1; start + bundle <= n; start++) {
                    int end = start + bundle;
                    dp[start][end] = Integer.MAX_VALUE;

                    for (int middle = start; middle < end; middle++) {
                        dp[start][end] = Math.min(
                                dp[start][end],
                                dp[start][middle] + dp[middle + 1][end] + files[end] - files[start - 1]
                        );
                    }
                }
            }
            System.out.println(dp[1][n]);
        }
    }
}