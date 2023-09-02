package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_카드_구매하기 {

    static Integer[] dp;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        p = new int[n + 1];
        dp = new Integer[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        dp[0] = 0;

        System.out.println(scanDown(n));
        System.out.println(scanUp(n));
    }

    public static int scanDown(int idx) {
        if (dp[idx] == null) {
            int max = 0;
            for (int i = idx - 1; i >= 0; i--) {
                max = Math.max(scanDown(i) + p[idx - i], max);
            }
            dp[idx] = max;
        }

        return dp[idx];
    }

    public static int scanUp(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                max = Math.max(dp[i - j] + p[j], max);
            }
            dp[i] = max;
        }

        return dp[n];
    }
}

//n = 10
//5 10 11 12 13 30 35 40 45 47
//
//dp 는 장수 기준
//dp[1] = dp[0] + p[1];
//dp[2] = dp[1] + p[1], dp[0] + p[2]
//dp[3] = dp[2] + p[1], dp[1] + p[2], dp[0] + p[3]
//dp[4] = dp[3] + p[1], dp[2] + p[2], dp[1] + p[3], dp[0] + p[4]
//dp[5] = dp[4] + p[1], dp[3] + p[2], dp[2] + p[3], dp[1] + p[4], dp[0] + p[5]

//int a = 0;
//for (int i = idx - 1; i > 0; i--) {
//    a = Math.max(scan(i) + p[idx - i], a);
//}
//dp[idx] = Math.max(a, p[idx])

//for (int i = 1; i <= n; i++) {
//    int a = 0;
//    for (int j = 1; j <= i; j++) {
//        a = Math.max(dp[i - j] + p[j]);
//    }
//    dp[i] = a;
//}