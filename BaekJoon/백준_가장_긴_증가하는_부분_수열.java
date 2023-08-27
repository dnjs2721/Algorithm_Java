package BaekJoon;

import java.io.*;
import java.util.*;
public class 백준_가장_긴_증가하는_부분_수열 {
    static int[] A;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        A = new int[t];
        dp = new int[t];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < t; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < t; i++) {
            dp[i] = 1;
            for (int j = 0; j < t; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < t; i++) {
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}
