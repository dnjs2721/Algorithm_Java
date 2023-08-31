package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_포도주_시식 {

    static Integer dp[];
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int [n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1];
        if (n >= 2) dp[2] = arr[1] + arr[2];

        System.out.println(scan(n));
    }

    public static int scan(int n) {
        if (dp[n] == null) {
            int a = scan(n - 3) + arr[n - 1];
            int b = scan(n - 2);
            dp[n] = Math.max(scan(n - 1), Math.max(a, b) + arr[n]);
        }
        return dp[n];
    }
}
