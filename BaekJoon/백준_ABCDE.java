package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_ABCDE {

    static ArrayList<Integer>[] map;
    static int n;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (answer == 1) break;
            dfs(i, 1);
        }
        System.out.println(answer);
    }

    public static void dfs(int start, int depth) {
        if (depth == 5) { // 서로 연결된 인접 노드가 5개인 경우
            answer = 1;
            return;
        }
        if (answer == 1) return; // 탐색 중지

        visited[start] = true;
        for (Integer friend : map[start]) {
            if (visited[friend]) continue;
            dfs(friend, depth + 1);
        }
        visited[start] = false; // 탐색이 끝나면 다음 탐색을 위해 방문 제거
    }
}