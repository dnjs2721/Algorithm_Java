package BaekJoon;

import java.io.*;
import java.util.*;
public class 백준_가장_긴_감소하는_부분_수열 {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(LDS(n));
    }

    public static int LDS(int n) {
        int answer = 0;
        for (int i = n; i >= 1; i--) {
            dp[i] = 1;
            for (int j = n; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
