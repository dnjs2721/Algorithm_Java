package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_차이를_최대로 {
    static int n;
    static int[] arr;
    static int answer = Integer.MIN_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int[] map = new int[n];
            visited[i] = true;
            map[0] = arr[i];
            dfs(map, 1);
            visited[i] = false;
        }

        System.out.println(answer);
    }

    public static void dfs(int[] map, int depth) {
        if (depth == n) {
            int res = 0;
            for (int i = 0; i < n - 1; i++) {
                res += Math.abs(map[i] - map[i + 1]);
            }
            answer = Math.max(answer, res);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            map[depth] = arr[i];
            dfs(map, depth + 1);
            visited[i] = false;
        }
    }
}