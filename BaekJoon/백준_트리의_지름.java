package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_트리의_지름 { // 1967

    static ArrayList<Node>[] map;
    static boolean[] visited;
    static int max = 0;
    static int node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[parent].add(new Node(child, cost));
            map[child].add(new Node(parent, cost));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if (len > max) {
            max = len;
            node = x;
        }

        visited[x] = true;
        for (Node n : map[x]) {
            if (visited[n.point]) continue;
            dfs(n.point, n.cost + len);
        }
    }

    static class Node {
        int point;
        int cost;
        public Node(int child, int cost) {
            this.point = child;
            this.cost = cost;
        }
    }
}
