package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_동전_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // dp[i] 는 i원을 만들 수 있는 최소한의 동전 갯수를 나타낸다.
        int[] dp = new int[k + 1];  // k원까지 탐색을 하기 위해 k + 1의 크기로 생성
        Arrays.fill(dp, 100001); // 만약 dp[i] 가 100001 이라면 아직까지 만들수 없는 금액이라는 뜻이다.

        for (int i = 0; i < n; i++) { // n번 반복
            int val = Integer.parseInt(br.readLine()); // 동전의 가치 저장
            if (val > k) continue; // 만약 동전의 가치가 k 보다 크다면 탐색할 필요 없다.

            dp[val] = 1; // 전달받은 동전의 가치를 만드는 돈전의 최소 개수는 자기 자신을 사용하는 것
            for (int won = val; won <= k; won++) { // 전달 받은 가치에서 + 1원씩 k 원 까지 탐색한다.
                if (dp[won - val] == 100001) continue; // dp[won - val] 가 100001 이라면 아직까지 만들수 없는 금액이라는 뜻이다.
                // 이전에 dp[won]을 만들 수 있던 동전의 최소 개수와
                // val 가치의 동전을 사용했을 때 만들 수 있는 동전의 개수를 비교한다.
                dp[won] = Math.min(dp[won], dp[won - val] + 1);
            }
        }

        if (dp[k] == 100001) { // 만약 dp[k] 가 100001 이라면 만들수 없는 금액이라는 뜻이다.
            System.out.println(-1); // -1 출력
        } else {
            System.out.println(dp[k]); // k원을 만드는데 사용한 동전의 최소 개수를 출력
        }
    }
}

// 가치의 합이 k원이 되도록
// 각각의 동전은 몇 개라도 사용가능
// 최소한의 동전을 사용하자.

// 2 15
// 1
// 2
// 12
// 라는 입력이 들어왔을 때

// 1 입력 ->  dp[1 ~ 15] 의 값은 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 이다.

// 2 입력 ->
// dp[2] = Math.min(dp[2], dp[0] + dp[2]) -> Math.min(2, 0 + 1) : 1 (2동전 1개)
// dp[3] = Math.min(dp[3], dp[1] + dp[2]) -> Math.min(3, 1 + 1) : 2 (1동전 1개, 2동전 1개)
// dp[4] = Math.min(dp[4], dp[2] + dp[2]) -> Math.min(4, 1 + 1) : 2 (2동전 1개, 2동전 1개)
// dp[5] = Math.min(dp[5], dp[3] + dp[2]) -> Math.min(5, 2 + 1) : 3 (1동전 1개, 2동전 1개, 2동전 1개)
// ......
// dp[1 ~ 15] 의 값은 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8 이다.

// 12 입력 ->
// dp[12] = Math.min(dp[12], dp[0] + dp[12]) -> Math.min(6, 0 + 1) : 1 (12동전 1개)
// dp[13] = Math.min(dp[13], dp[1] + dp[12]) -> Math.min(7, 1 + 1) : 2 (1동전 1개, 12동전 1개)
// dp[14] = Math.min(dp[14], dp[2] + dp[12]) -> Math.min(7, 1 + 1) : 2 (2동전 1개, 12동전 1개)
// dp[15] = Math.min(dp[15], dp[3] + dp[12]) -> Math.min(8, 2 + 1) : 3 (1동전 1개, 2동전 1개, 12동전 1개)
