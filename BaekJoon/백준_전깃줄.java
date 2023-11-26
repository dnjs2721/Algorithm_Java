package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] map = new int[501]; // map[i]의 값은 A 전봇대 i 번째와 연결된 B 전봇대의 번호를 가리킨다.

        StringTokenizer st;
        int maxN = 0; // A, B 전봇대의 연결 가능한 최대 위치
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a] = b;
            maxN = Math.max(Math.max(a, maxN), b); // a와 b 둘 다 비교를 해야지 최대 위치값을 찾을 수 있음.
        }

        int[] dp = new int[maxN + 1]; // 1부터 최대 위치값까지 배열 생성
        // 해당 dp[i]의 값은 A 전봇대에서 1부터 i 번째 인덱스 까지 연결했을 때의 가로지르는 전선이 없는 전선 최대 연결수를 나타낸다.

        int res = 0; // 가로지르는 전선이 없는 전체 전선 최대 연결 수
        for (int i = 1; i <= maxN; i++) { // A 전봇대의 1 ~ maxN 까지
            if (map[i] == 0) continue; // map[i]가 0이라면 A의 i 번째는 연결된 전선이 없는거기에 탐색을 하지 않는다.
            dp[i] = 1; // 전선이 연결되 모든 위치는 1개의 전선을 가지고 있다.
            for (int j = i - 1; j >= 1; j--) { // A의 i 번째 보다 전의 위치를 탐색한다.
                if (map[j] == 0) continue; // map[j]가 0이라면 A의 j 번째는 연결된 전선이 없는거기에 탐색을 하지 않는다.
                if (map[i] > map[j]) { // A의 i 번이랑 연결된 B(이하 ib)의 위치와 A의 j 번이랑 연결된 B(이하 jb)의 위치를 비교한다.
                    // j는 항상 i보다 낮은 수의 번호이다.
                    // 만약 ib 보다 jb가 크다면 j에 연결된 전선은 i에 연결된 전선을 가로질러 연결된다는 뜻이다. 이는 최대 연결수에 해당되지 않는다.
                    // 같은 위치에 전선이 연결될 수 없기에 ib 와 jb가 같은 경우는 고려하지 않는다.
                    // ib 기 jb 보다 크다면 이는 가로지르는 전선이 아니다.

                    // dp[i] 는 i번째 연결된 전선과 (1 ~ j)번째에 연결가능한 최대 전선의 수를 갖게 된다.
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            res = Math.max(res, dp[i]); // A의 i 번째를 연결 했을 경우 전체 전선 최대 연결수가 아니게 될 수 있다.
        }

        System.out.println(n - res); // 전체 전선 - (가로지르는 전선이 없는 전체 전선 최대 연결 수) = 제거 해야 하는 최소 전선의 수
    }
}

