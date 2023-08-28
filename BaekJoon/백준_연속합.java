package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_연속합 {

    static int answer;
    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        answer = dp[0];

        scan(n - 1);

        System.out.println(answer);
    }

    public static int scan(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(scan(n - 1) + arr[n], arr[n]);
            answer = Math.max(answer, dp[n]);
        }

        return dp[n];
    }
}

//10 -4 3 1 5 6 -35 12 21 -1
//10
//6
//9
//10
//15
//21
//-14
//12
//33
//32

//2 1 -4 3 4 -4 6 5 -5 1
//2
//max(2 + 1, 1) -> 3
//max(3 - 4, -4) -> -1
//max(-1 + 3, 3) -> 3
//max(3 + 4, 4) -> 7
//max(7 - 4, -4) -> 3
//max(3 + 6, 6) -> 9
//max(9 + 5, 5) -> 14 ✅
//max(14 - 5, -5) -> 9
//max(9 + 1, 1) -> 10
//
//dp[i] = Math.max(dp[i - 1] + arr[i], arr[i])