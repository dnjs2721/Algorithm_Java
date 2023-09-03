package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_가장_긴_바이토닉_부분_수열 {

    static int[] arr;
    static Integer[] ldp;
    static Integer[] rdp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        ldp = new Integer[n + 1];
        rdp = new Integer[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS(n);
        LDS(n);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, ldp[i] + rdp[i] - 1);
        }

        System.out.println(answer);
    }

    // 오름차순 부분수열 만들기
    public static int LIS(int n) {
        for (int i = 1; i <= n; i++) {
            ldp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    ldp[i] = Math.max(ldp[i], ldp[j] + 1);
                }
            }
        }

        return ldp[n];
    }

    // 내림차순 부분수열 만들기 -> 오른쪽에서 왼쪽으로 진행하는 오름차순 부분수열
    public static int LDS(int n) {
        for (int i = n; i >= 1; i--) {
            rdp[i] = 1;
            for (int j = n; j > i; j--) {
                if (arr[i] > arr[j]) {
                    rdp[i] = Math.max(rdp[i], rdp[j] + 1);
                }
            }
        }

        return rdp[n];
    }
}

//1 5 2 1 4 3 4 5 2 1
//1 2 2 1 3 3 4 5 2 1
//[1]
//[1 5]
//[1 2]
//[1]
//[1 2 4]
//[1 2 3]
//[1 2 3 4]
//[1 2 3 4 5]
//[1 2]
//[1]
//
//dp[2] = 1;
//now = arr[2] = 5;
//before = arr[1] = 1
//
//if (now > before) {
//    dp[2] += 1
//}
//
//dp[3] = 1;
//now = arr[3] = 2;
//before = arr[2] = 5, arr[1] = 1
//if (now > before) {
//    dp[3] += 1;
//}
//
//LIS
//int n = 4;
//dp[n] = 1;
//for (int i = 1; i < n; i++) {\
//    if (arr[n] > arr[i] ) {
//        dp[n] = Math.max(dp[n], dp[i] + 1);
//    }
//}
//-> 만약 n이 4 일때는 arr[1 ~ 3] 중 arr[4] 보다 작은것이 몇개 있는지 찾는것이다.
//   arr[4] 보다 arr[3] 이 작은 경우 dp[3] 에는 arr[3] 의 LIS 가 들어있는 것이기에 dp[4] 는 dp[3] 에 + 1 이 된 값이 된다.
//   arr[2] 가 arr[3] 보다 크면서 arr[4] 보다 작아 dp[2] 가 가진 LIS 가 더 클 수 있기에 저장된 dp[4] 와 dp[2] + 1 을 비교하여 저장한다