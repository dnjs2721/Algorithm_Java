package BaekJoon;

import java.io.*;

public class 백준_동물원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][3];

        // dp[n][0] = n 번째 줄에 사자를 한마리도 안 넣을 경우
        // dp[n][1] = n 번째 줄의 첫번째 칸에 사자를 넣을 경우
        // dp[n][2] = n 번째 줄의 두번째 칸에 사자를 넣을 경우

        // 1번째 줄에는 첫번째 칸에 사자를 넣거나, 두번째 칸에 사자를 넣거나, 사자를 넣지 않는 경우 3가지가 있다.
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            // i 번째에 사자를 넣지 않을 경우에는 i - 1 줄에 사자가 있던 없던 상관이 없다.
            dp[i][0] = mod(dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]);
            // i 번째의 첫번째에 사자를 넣을 경우 i - 1에 사자가 없거나, i - 1의 두번째 칸에 사자가 있는 경우만 가능하다.
            dp[i][1] = mod(dp[i - 1][0] + dp[i - 1][2]);
            // i 번째의 두번째에 사자를 넣을 경우 i - 1에 사자가 없거나, i - 1의 첫번째 칸에 사자가 있는 경우만 가능하다.
            dp[i][2] = mod(dp[i - 1][0] + dp[i - 1][1]);
        }

        // n 번째의 모든 경우의 수의 합
        System.out.println(mod(dp[n][0] + dp[n][1] + dp[n][2]));
    }

    public static long mod(long num) {
        return num % 9901;
    }
}