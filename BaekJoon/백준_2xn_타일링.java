package BaekJoon;

import java.io.*;

public class 백준_2xn_타일링 {
    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(solution(Integer.parseInt(reader.readLine())));
    }

    public static int solution(int n) {
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        return dp[n];
    }
}