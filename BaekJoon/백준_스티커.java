package BaekJoon;

import java.io.*;
import java.util.*;
public class 백준_스티커 {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st1;
        StringTokenizer st2;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[n + 1][2];
            dp = new int[n + 1][2];

            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                arr[j][0] = Integer.parseInt(st1.nextToken());
                arr[j][1] = Integer.parseInt(st2.nextToken());
            }

            sb.append(scan(n) + "\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static int scan(int n) {
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + arr[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + arr[i][1];
        }

        return Math.max(dp[n][0], dp[n][1]);
    }
}


//scan(i)
//
//int a = dp[i - 1][1]
//int b = dp[i - 1][0]
//int c = Math.max(dp[i - 2][0], dp[i - 2][1])
//dp[i][0] = Math.max(a, c) + arr[i][0];
//dp[i][1] = Math.max(b, c) + arr[i][1];
//위 점화식도 정답
//
//i - 2 의 두 개를 비교하는것은 의미가 없다.
//dp[i][0] 을 구할 때 dp[i - 2][1] 보다 dp[i - 1][0] 이 항상 이득이기에 dp[i - 1][0] 과 dp[i - 2][0] 을 비교하면 된다.
//따라서 수정된 점화식은
//dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + arr[i][0];
//dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + arr[i][1];
//이다.