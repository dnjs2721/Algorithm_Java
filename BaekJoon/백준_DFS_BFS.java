package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_DFS_BFS {
    static int n;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int point1 = Integer.parseInt(st.nextToken());
            int point2 = Integer.parseInt(st.nextToken());

            if (!map.containsKey(point1)) map.put(point1, new ArrayList<>());
            if (!map.containsKey(point2)) map.put(point2, new ArrayList<>());
            map.get(point1).add(point2);
            map.get(point2).add(point1);
        }

        visited = new boolean[n + 1];
        visited[v] = true;

        dfs(v);
        bfs(v);

        bw.flush();
    }

    public static void dfs(int start) throws IOException {
        bw.write(start + " ");

        if (!map.containsKey(start)) return;

        List<Integer> nodes = map.get(start);
        Collections.sort(nodes);

        for (Integer node : nodes) {
            if (visited[node]) continue;
            visited[node] = true;
            dfs(node);
        }
    }

    public static void bfs(int v) throws IOException {
        bw.write("\n");
        visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);

        while (!q.isEmpty()) {
            int start = q.poll();
            bw.write(start + " ");

            if (!map.containsKey(start)) continue;

            List<Integer> nodes = map.get(start);
            Collections.sort(nodes);

            for (Integer node : nodes) {
                if (visited[node]) continue;
                visited[node] = true;
                q.add(node);
            }
        }
    }
}