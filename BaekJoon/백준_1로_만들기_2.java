package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_1로_만들기_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sol1(n);
        sol2(n);
    }

    public static void sol1(int n) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer>[] dp = new ArrayList[n + 1]; // dp[idx] 에는 idx 를 1로 최소한의 연산을 사용해 만들 때 포함되어 있는 수를 가진다.

        dp[1] = new ArrayList<>(); // 1을 1로 만들 때
        dp[1].add(1); // 1만 포함된다.

        for (int i = 2; i <= n; i++) { // 2부터 n을 1로 만들 때
            // i - 1 연산은 항상 수헹되기에 dp[i - 1]을 가지고 온다.
            ArrayList<Integer> tmp = new ArrayList<>(dp[i - 1]); // List 에 i를 추가해 주기 위해 new 를 통해 가지고 온다.
            if (i % 3 == 0) { // i가 3으로 나누어 떨어질 때
                if (tmp.size() > dp[i / 3].size()) { // tmp 의 크기가 dp[i / 3]의 크기보다 클 때
                    // i 를 1로 만들 때 이전 연산 보다 i / 3 의 연산이 적은 연산을 사용하기 때문에 tmp 값을 바꿔준다.
                    tmp.clear(); // 이전 값을 지운다.
                    tmp.addAll(dp[i / 3]); // dp[i / 3]의 값으로 수정한다.
                }
            }
            if (i % 2 == 0) {  // i가 3로 나누어 떨어질 때
                if (tmp.size() > dp[i / 2].size()) { // tmp 의 크기가 dp[i / 2]의 크기보다 클 때
                    tmp.clear();  // i 를 1로 만들 때 이전 연산 보다 i / 2 의 연산이 적은 연산을 사용하기 때문에 tmp 값을 바꿔준다.
                    tmp.addAll(dp[i / 2]); // dp[i / 2]의 값으로 수정한다.
                }
            }
            tmp.add(i); // tmp 에 i를 추가해 연산에 포함된 수를 추가해 준다.
            dp[i] = tmp; // dp[i]를 tmp 로 설정한다.
        }

        bw.write(dp[n].size() - 1 + "\n"); // 자기 자신은 연산 횟수에 포함되지 않기에 -1을 한 뒤 연산 횟수를 BufferedWriter 에 저징한다.
        for (int i = dp[n].size() - 1; i >= 0; i--) { // dp[n]에는 오름차순으로 수가 저장되어 있기에 반대로 순환한다.
            bw.write(dp[n].get(i) + " "); // BufferedWriter 에 순서대로 저장
        }
        bw.write("\n"); // 줄 바꿈 저장
        bw.flush(); // BufferedWriter 에 저장된 문자들을 한번에 출력
    }

    public static void sol2(int n) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[n + 1]; // dp[idx] 에는 idx 를 1로 만들 때 필요한 최소한의 연산 횟수를 가진다.
        int[] route = new int[n + 1]; // route[idx] 에는 idx 를 1로 최소한의 연산을 사용해 만들 때 참고한 idx 를 가진다.

        route[1] = -1; // 1에서 1을 만들 때는 연산이 필요없기에 -1이란 특정 값을 가진다.

        for (int i = 2; i <= n; i++) { // 2부터 n을 1로 만들 때
            dp[i] = dp[i - 1] + 1; // i - 1 연산은 항상 수헹되기에 dp[i - 1]을 가지고 온 뒤 연산 횟수를 추가해 dp[i]에 저장한다.
            route[i] = i - 1; // dp[i]의 최소연산 횟수를 구하기 위해 dp[i - 1]을 참고 했기에 route[i]에 i - 1을 저장한다.

            // i가 3로 나누어 떨어지고 dp[i] 의 연산횟수가 dp[i / 3]에 1을 더한 연산횟수 보다 클 때
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1; // dp[i / 3]을 가지고 온 뒤 연산 횟수를 추가해 dp[i]에 저장한다.
                route[i] = i / 3; // dp[i]의 최소연산 횟수를 구하기 위해 dp[i / 3]을 참고 했기에 route[i]에 i / 3을 저장한다.
            }

            // i가 2로 나누어 떨어지고 dp[i] 의 연산횟수가 dp[i / 2]에 1을 더한 연산횟수 보다 클 때
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1; // dp[i / 2]을 가지고 온 뒤 연산 횟수를 추가해 dp[i]에 저장한다.
                route[i] = i / 2; // dp[i]의 최소연산 횟수를 구하기 위해 dp[i / 2]을 참고 했기에 route[i]에 i / 2를 저장한다.
            }
        }

        // 연산 횟수를 BufferedWriter 에 저징한다.
        bw.write(dp[n] + "\n");

        int check = n; // n 부터 1로 만들 때 포함되어 있는 수
        while (route[check] != -1) { // root[check] 가 -1이 될 떄 까지 반복 -> check 가 1이면 -1이다.
            bw.write(check + " "); // BufferedWriter 에 check 와 공백을 저장한다.
            check = route[check]; // check 를 root[check]의 값으로 변경한다.
        }

        bw.write("1"); // 마지막에 1을 BufferedWriter 에 추가한다.
        bw.close(); // BufferedWriter 를 종료하고 저장된 문자들을 한번에 출력
    }
}