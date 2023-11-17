package etc;

import java.util.*;
import java.io.*;
public class 알리바바와_40인의_도둑 {

    static int n;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(scan());
    }

    public static int scan() {
        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};

        dp[1][1] = map[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < 2; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if (ny > n || nx > n) continue;
                    if (dp[ny][nx] == 0) {
                        dp[ny][nx] = dp[i][j] + map[ny][nx];
                    } else {
                        dp[ny][nx] = Math.min(dp[ny][nx], dp[i][j] + map[ny][nx]);
                    }
                }
            }
        }

        return dp[n][n];
    }
}