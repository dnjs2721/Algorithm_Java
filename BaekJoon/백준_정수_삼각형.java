package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_정수_삼각형 {
    static Integer[][] triangle;
    static Integer[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        triangle = new Integer[n][];

        StringTokenizer st;
        Integer[] tmp;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            tmp = new Integer[i + 1];
            for (int j = 0; j < i + 1; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
            }
            triangle[i] = tmp;
        }

        System.out.println(dpUp()); // 아래에서 부터 위로
        System.out.println(dpDown()); // 위에서 아래로 - 인터넷 참조
    }

    public static int dpUp () { // 삼각형의 옆면을 채우고 아래에서 시작
        dp = new Integer[n][n];

        dp[0] = triangle[0];
        if (n == 1) {
            return dp[0][0];
        }
        dp[1][0] = triangle[1][0] + dp[0][0];
        dp[1][1] = triangle[1][1] + dp[0][0];

        for (int i = 1; i < n; i ++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        int answer = 0;
        for (int num : scanUp(n - 1, 1)) {
            answer = Math.max(num, answer);
        }
        return answer;
    }

    public static Integer[] scanUp(int now, int x) {
        if (dp[now][x] == null) {
            for (int i = 1; i < now; i++) {
                int a = scanUp(now - 1, i - 1)[i - 1];
                int b = scanUp(now - 1, i)[i];
                dp[now][i] = Math.max(a, b) + triangle[now][i];
            }
        }

        return dp[now];
    }

    public static int dpDown() { // 삼각형의 아랫면 채우고 위에서 시작
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n-1][i];
        }
        return scanDown(0, 0);
    }

    public static int scanDown(int now, int x) {
        if (dp[now][x] == null) {
            int a = scanDown(now + 1, x);
            int b = scanDown(now + 1, x + 1);
            dp[now][x] = Math.max(a, b) + triangle[now][x];
        }

        return dp[now][x];
    }
}