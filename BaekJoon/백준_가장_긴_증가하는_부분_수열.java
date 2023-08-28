package BaekJoon;

import java.io.*;
import java.util.*;
public class 백준_가장_긴_증가하는_부분_수열 {
    static int[] A;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        A = new int[t];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < t; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dynamic(t));
        System.out.println(binarySearch(t));
    }

    public static int dynamic(int n) {
        int[] dp = new int[n];

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(dp[i], answer);
        }

        return answer;
    }

    public static int binarySearch(int n) {
        int[] memo = new int[n + 1];
        int len = 0;
        int idx;
        for (int i = 0; i < n; i++) {
            if (A[i] > memo[len]) {
                len++;
                memo[len] = A[i];
            } else {
                idx = bs(0, len, A[i], memo);
                memo[idx] = A[i];
            }
        }
        return len;
    }

    public static int bs(int left, int right, int key, int[] memo) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (memo[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
