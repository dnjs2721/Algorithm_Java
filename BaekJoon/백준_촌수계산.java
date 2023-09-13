package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_촌수계산 {
    static List<List<Integer>> map = new ArrayList<>();
    static boolean[] visited;
    static int target2;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.get(x).add(y);
            map.get(y).add(x);
        }

        dfs(target1, 0);
        System.out.println(answer);
    }

    public static void dfs(int start, int depth) {
        if (start == target2) {
            answer = depth;
            return;
        }
        visited[start] = true;
        for (int node : map.get(start)) {
            if (visited[node]) continue;
            dfs(node, depth + 1);
        }
    }
}
