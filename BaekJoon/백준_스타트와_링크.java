package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_스타트와_링크 {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        team(0, 0);
        System.out.println(answer);
    }

    public static void team(int idx, int depth) {
        if (depth == n / 2) {
            cal();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                team(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void cal() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        int res = Math.abs(start - link);

        if (res == 0) {
            System.out.println(0);
            System.exit(0);
        }

        answer = Math.min(answer, res);
    }
}