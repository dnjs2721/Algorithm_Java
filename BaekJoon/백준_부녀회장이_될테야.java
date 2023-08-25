package BaekJoon;

import java.io.*;

public class 백준_부녀회장이_될테야 {
    static Integer[][] dp = new Integer[15][15];

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= 14; i++) {
            dp[0][i] = i;
        }

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(reader.readLine());
            int n = Integer.parseInt(reader.readLine());
            answer.append(scan(k, n)).append('\n');
        }
        System.out.println(answer);
    }

    public static Integer scan(int k, int n) {
        if (dp[k][n] != null) {
            return dp[k][n];
        }

        int people = 0;
        for (int room = 1; room <= n; room++) {
            if (dp[k - 1][room] == null) {
                people += scan(k - 1, room);
                continue;
            }
            people += dp[k - 1][room];
        }
        dp[k][n] = people;
        return dp[k][n];
    }
}