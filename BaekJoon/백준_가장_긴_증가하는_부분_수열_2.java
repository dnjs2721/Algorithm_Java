package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_가장_긴_증가하는_부분_수열_2 {
    static int[] arr;
    static int[] binary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        binary = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(LIS(n));
    }

    public static int LIS(int n) {
        int len = 0;
        int now;
        int before;

        for (int i = 0; i < n; i++) {
            now = arr[i];
            before = binary[len];

            if (now > before) {
                len++;
                binary[len] = now;
            } else {
                int idx = Arrays.binarySearch(binary, 1, len, now);
                // now 값이 binary 에 없다면 now 보다 최초로 큰 인덱스 번호에 -1 을 곱하고 -1 을 한 값을 리턴한다.
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                binary[idx] = now;
            }
        }
        return len;
    }
    // Arrays.binarySearch(binary, 0, len, now); 과 동일한 결과
    public static int binarySearch(int left, int right, int num) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (binary[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}