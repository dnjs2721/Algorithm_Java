package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_트리의_부모_찾기 {
    static List<List<Integer>> map = new ArrayList<>();
    static boolean[] visited;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        res = new int[n];

        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map.get(a).add(b);
            map.get(b).add(a);
        }

        dfs(0);
        for (int i = 1; i < n; i++) {
            bw.write(res[i] + "\n");
        }
        bw.flush();
    }

    public static void dfs(int node) {
        visited[node] = true;
        List<Integer> connect = map.get(node);
        for (Integer c : connect) {
            if (visited[c]) continue;
            res[c] = node + 1;
            dfs(c);
        }
    }
}