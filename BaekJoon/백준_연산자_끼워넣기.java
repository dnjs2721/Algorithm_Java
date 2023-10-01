package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_연산자_끼워넣기 {
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arr;
    static int[] op = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int sum, int depth) {
        if (depth == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;
            op[i]--;
            switch (i) {
                case 0 :
                    dfs(sum + arr[depth], depth + 1);
                    break;
                case 1 :
                    dfs(sum - arr[depth], depth + 1);
                    break;
                case 2 :
                    dfs(sum * arr[depth], depth + 1);
                    break;
                case 3 :
                    dfs(sum / arr[depth], depth + 1);
                    break;
            }
            op[i]++;
        }
    }
}