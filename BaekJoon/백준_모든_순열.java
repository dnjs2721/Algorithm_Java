package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_모든_순열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            map[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            int[] arr = new int[n];
            arr[0] = map[i];
            visited[i] = true;
            dfs(arr, 1);
            visited[i] = false;
        }

        bw.close();
    }

    public static void dfs(int[] arr, int depth) throws IOException {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            arr[depth] = map[i];
            visited[i] = true;
            dfs(arr, depth + 1);
            visited[i] = false;
        }
    }
}
