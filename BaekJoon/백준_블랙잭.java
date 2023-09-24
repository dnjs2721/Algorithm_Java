package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_블랙잭 {
    static int n;
    static int m;
    static int[] list;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 2; i++) {
            int first = list[i];
            for (int j = i + 1; j < n - 1; j++) {
                int second = list[j];
                for (int k = j + 1; k < n; k++) {
                    int sum = first + second + list[k];
                    if (sum  > m) continue;
                    answer = Math.max(answer, sum);
                }
            }
        }

        /** dfs **/
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            dfs(i, list[i], 1);
        }

        System.out.println(answer);
    }

    public static void dfs(int idx, int x, int depth) {
        if (depth == 3) {
            if (x <= m) answer = Math.max(answer, x);
            return;
        }
        visited[idx] = true;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(i, x + list[i], depth + 1);
        }
        visited[idx] = false;
    }
}