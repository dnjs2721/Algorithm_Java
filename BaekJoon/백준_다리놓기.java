package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_다리놓기 {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // M 개중 N개를 뽑는 경우 nCr 에서 n = m , r = n
            System.out.println(combination(m, n));
        }
    }

    public static int combination(int n, int r) {
        if (dp[n][r] != 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        // 파스칼의 법칙 점화식
        // n+1Cr+1 = nCr + nCr+1
        // nCr = n-1Cr-1 + n-1Cr
        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
