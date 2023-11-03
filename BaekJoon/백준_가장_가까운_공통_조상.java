package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_가장_가까운_공통_조상 {
    static int n;
    static int[] map;
    static boolean[] visited;
    static BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());

            map = new int[n + 1];
            visited = new boolean[n + 1];

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                map[child] = parent;
            }

            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            checkToRootNode(node1);
            findingCommonAncestors(node2);
        }

        bw.close();
    }

    public static void checkToRootNode(int node) {
        int now = node;
        while (true) {
            visited[now] = true;
            if (map[now] == 0) break;
            now = map[now];
        }
    }

    public static void findingCommonAncestors(int node) throws IOException {
        int now = node;
        while (true) {
            if (visited[now]) {
                bw.write(now + "\n");
                break;
            }
            now = map[now];
        }
    }
}
