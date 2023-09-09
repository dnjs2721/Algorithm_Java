package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_연결_요소의_개수 {
    static List<List<Integer>> map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;

        map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.get(u).add(v);
            map.get(v).add(u);
        }

        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            dfs(i);
            answer++;
        }

        System.out.println(answer);
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (Integer node : map.get(start)) {
            if (visited[node]) continue;
            dfs(node);
        }
    }
}
