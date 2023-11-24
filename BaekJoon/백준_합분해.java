package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_합분해 {
    static int inputN;
    static int inputK;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        inputN = Integer.parseInt(st.nextToken());
        inputK = Integer.parseInt(st.nextToken());

        dp = new long[inputK + 1][inputN + 1];

        for (int k = 1; k <= inputK; k++) { // k 가 0이면 숫자를 만들 수 없다.
            for (int i = 0; i <= inputN; i++) {
                if (k == 1) { // k가 1 -> 어떤 숫자든 1개로 자신을 만들려면 자기자신 1개 밖에 없다,
                    dp[k][i] = 1;
                    continue;
                }
                for (int j = 0; j <= i; j++) {
                    // dp[k][i] -> k개의 수를 합해서 i 를 만들수 있는 방법
                    dp[k][i] += dp[k - 1][i - j];
                    dp[k][i] %= 1000000000;
                }
            }
        }

        System.out.println(dp[inputK][inputN]);
        dp = new long[inputK + 1][inputN + 1];
        System.out.println(scan(inputK, inputN));
    }

    public static long scan(int depth, int num) {
        if (depth == 1) {
            return dp[depth][num] = 1;
        }

        if (dp[depth][num] != 0) {
            return dp[depth][num];
        }

        for (int i = num; i >= 0; i--) {
//        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= i; j++) {
                dp[depth][i] += scan(depth - 1, i - j);
                dp[depth][i] %= 1000000000;
            }
        }

        return dp[depth][num];
    }
}