package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_수들의_합_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] map = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < n; i ++) {
            int sum = map[i];
            int j = i + 1;
            while (true) {
                if (sum == m) {
                    answer++;
                    break;
                } else if (sum > m) {
                    break;
                }
                if (j == n) break;
                sum += map[j];
                j++;
            }
        }

        System.out.println(answer);
    }
}