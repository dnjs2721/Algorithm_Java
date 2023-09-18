package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_이분_그래프 {

    static List<List<Integer>> map;
    static int[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            visited = new int[V + 1];

            map = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                map.add(new ArrayList<>());
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                map.get(u).add(v);
                map.get(v).add(u);
            }

            flag = false;
            for (int node = 1; node <= V; node++) {
                if (flag) break; // 이분 그래프가 아님이 판명 되었을 경우
                if (visited[node] == 0) { // 방문하지 않은 경우
                    dfs(node, 1); // 1그룹으로 해당 node 탐색
                }
            }
            if (flag) bw.write("NO\n");
            else bw.write("YES\n");
        }
        bw.close();
    }

    public static void dfs(int start, int check) {
        if (flag) return; // 이분 그래프가 아님이 판명 되었을 경우
        visited[start] = check; // check 그룹으로 할당 (1 혹은 -1)
        for (int node : map.get(start)) { // start 인접 node 들
            if (visited[node] == 0) { // 방문하지 않은 경우
                dfs(node, -check); // 현재 그룹과 반대 되는 그룹(1 혹은 -1)으로 node 탐색
            } else if (visited[node] == visited[start]) { // start 와 node 의 그룹이 같은 경우, 즉 인접 노드의 그룹이 같은 경우
                flag = true; // 이분 그래프가 아니다.
                return;
            }
        }
    }
}