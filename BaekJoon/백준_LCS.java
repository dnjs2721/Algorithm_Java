package BaekJoon;

import java.io.*;

public class 백준_LCS {
    static char[] str1;
    static char[] str2;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new Integer[str1.length][str2.length];

        System.out.println(scan(str1.length - 1, str2.length - 1));
        br.close();
    }

    public static int scan(int x, int y) {
        if (x == -1 || y == -1) {
            return 0;
        }

        if (dp[x][y] == null) {
            if (str1[x] == str2[y]) {
                dp[x][y] = scan(x - 1, y - 1) + 1;
            } else {
                dp[x][y] = Math.max(scan(x - 1, y), scan(x, y - 1));
            }
        }

        return dp[x][y];
    }
}

//  A C A Y K P
//C 0 1 1 1 1 1
//A 1 1 2 2 2 2
//P 1 1 2 2 2 3
//C 1 2 2 2 2 3
//A 1 2 3 3 3 3
//K 1 2 3 3 4 4

//x 혹은 y 가 0 보다 작다면 0
//만약 str1[x] == str2[y] 면 dp[x - 1][y - 1] + 1
//다르다면 dp[x - 1, y] 와 dp[x][y - 1] 중 큰 거