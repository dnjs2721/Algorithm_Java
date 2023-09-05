package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_이항_계수_2 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][k + 1];

        System.out.println(scan(n, k));
    }
    public static int scan(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = (scan(n - 1, r - 1) + scan(n - 1, r)) % 10007;
    }
}
//\
//nCr
//( n )   (n - 1)   (n - 1)
//(   ) = (     ) + (     )
//( r )   (r - 1)   (  r  )
//
//1 0 0
//1 1 0
//1 2 1
//1 3 3
//1 4 6
//1 5 10
//
//dp[i][j] = d[i - 1][j - 1] + d[i - 1, j]