package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_부분수열의_합 {
    static int[] arr;
    static int n;
    static int s;
    static int answer = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            search(i, arr[i], 1);
        }
        System.out.println(answer);
    }

    public static void search(int start, int sum, int depth) {
        if (sum == s) {
            answer++;
        }
        if (depth == n) {
            return;
        }
        visited[start] = true;
        for (int i = start; i < n; i++) {
            if (start == i) continue;
            if (visited[i]) continue;
            search(i, sum + arr[i], depth + 1);
        }
        visited[start] = false;
    }
}