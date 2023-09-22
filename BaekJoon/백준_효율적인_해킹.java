package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_효율적인_해킹 {

    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            map[com1].add(com2);
        }

        res = new int[n + 1];
        for (int com = 1; com <= n; com++) {
            visited = new boolean[n + 1];
            dfs(com);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, res[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (res[i] == max) {
                bw.write(i + " ");
            }
        }
        bw.close();
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int com : map[start]) {
            if (visited[com]) continue;
            res[com]++; // start 를 통해서 com 으로 간다는 것은 com 을 해킹하면 start 를 해킹할 수 있다는 뜻. com 에서 해킹할 수 있는 컴퓨터의 수를 ++
            dfs(com);
        }
    }
}