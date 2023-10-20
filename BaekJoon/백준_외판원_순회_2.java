package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_외판원_순회_2 {
    static int n;
    static int[][] w;
    static boolean[] cities;
    static int first;
    static long answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            cities = new boolean[n + 1];
            first = i;
            dfs(i, 0, 0);
        }

        System.out.println(answer);
    }

    public static void dfs(int start, long sum, int depth) {
        if (depth == n) {
            answer = Math.min(answer, sum);
            return;
        }

        cities[start] = true;
        if (depth == n - 1) {
            if (w[start][first] != 0) {
                dfs(start, sum + w[start][first], depth + 1);
            }
            cities[start] = false;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (cities[i]) continue;
            if (w[start][i] == 0) continue;
            dfs(i, sum + w[start][i], depth + 1);
        }
        cities[start] = false;
    }
}