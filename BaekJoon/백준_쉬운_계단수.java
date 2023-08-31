package BaekJoon;

import java.io.*;

public class 백준_쉬운_계단수 {
    static Long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new Long[n + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1L;
        }

        long answer = 0;
        for (int i = 1; i <= 9; i++) {
            answer += scan(n, i);
        }

        System.out.println(answer % 1000000000);
    }

    public static long scan(int n, int idx) {
        if (n == 1) {
            return dp[n][idx];
        }
        if (dp[n][idx] == null) {
            if (idx == 0) {
                return dp[n][idx] = scan(n - 1, 1);
            } else if (idx == 9) {
                return dp[n][idx] = scan(n - 1, 8);
            } else {
                dp[n][idx] = scan(n - 1, idx - 1) + scan(n - 1, idx + 1);
            }
        }
        return dp[n][idx] % 1000000000;
    }
}

//1
//2
//3
//4
//5
//6
//7
//8
//9
//
//10 12
//21 23
//32 34
//43 45
//54 56
//65 67
//76 78
//87 89
//98
//
//101 121 123
//210 212 232 234
//321 323 343 345
//432 434 454 456
//543 545 565 567
//654 656 676 678
//765 767 787 789
//876 878 898
//987 989
//
//for (int i = 1; i <= 9; i++) {
//    dp[n][i] = dp[n-1][i - 1] + dp[n-1][i+1]
//}
//
//dp[2][1] = dp[1][0] + dp[1][2]
//        = 1 + 2
//dp[2][2] = dp[1][1] + dp[1][3]
//        = 2 + 2