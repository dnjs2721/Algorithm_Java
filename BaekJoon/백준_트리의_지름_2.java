package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_트리의_지름_2 { // 1167

    static ArrayList<Node>[] map;
    static boolean[] visited;
    static int max = 0;
    static int node = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        map = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            while (true) {
                int node2 = Integer.parseInt(st.nextToken());
                if (node2 == -1) break;
                int cost = Integer.parseInt(st.nextToken());

                map[node1].add(new Node(node2, cost));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    public static void dfs(int start, int dis) {
        if (dis > max) {
            node = start;
            max = dis;
        }

        visited[start] = true;
        for (Node n : map[start]) {
            if (visited[n.x]) continue;
            dfs(n.x, dis + n.cost);
        }
    }

    static class Node{
        int x;
        int cost;
        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
}