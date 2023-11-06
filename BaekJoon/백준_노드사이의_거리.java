package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_노드사이의_거리 {
    static ArrayList<Node>[] map;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n -  1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            map[u].add(new Node(v, val));
            map[v].add(new Node(u, val));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            find(u, v, 0);
        }

        bw.close();
    }

    public static void find(int start, int end, int sum) throws IOException {
        if (start == end) {
            bw.write(sum + "\n");
            return;
        }

        visited[start] = true;
        ArrayList<Node> nodes = map[start];
        for (Node node : nodes) {
            if (visited[node.link]) continue;
            find(node.link, end, sum + node.val);
        }
        visited[start] = false;
    }

    public static class Node {
        int link;
        int val;
        public Node(int link, int val) {
            this.link = link;
            this.val = val;
        }
    }
}
