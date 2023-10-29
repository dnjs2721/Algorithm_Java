package BaekJoon;

import java.util.*;
import java.io.*;

public class 깊이_우선_탐색_2 {
    static ArrayList<Integer>[] map;
    static int[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList();
        }
        visited = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u].add(v);
            map[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            map[i].sort((o1, o2) -> o2 - o1);
        }
        dfs(r);
        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void dfs(int start) {
        visited[start] = ++count;
        ArrayList<Integer> nodes = map[start];
        for (int next : nodes) {
            if (visited[next] != 0) continue;
            dfs(next);
        }
    }
}