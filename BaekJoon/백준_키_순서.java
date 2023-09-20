package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_키_순서 {
    static ArrayList<Integer>[] big;
    static ArrayList<Integer>[] small;
    static boolean[] visited;
    static int bigRes;
    static int smallRes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        big = new ArrayList[n + 1];
        small = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            big[i] = new ArrayList();
            small[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            big[a].add(b);
            small[b].add(a);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            bigRes = 0;
            visited = new boolean[n + 1];
            bigDfs(i);

            smallRes = 0;
            visited = new boolean[n + 1];
            smallDfs(i);

            if (bigRes + smallRes == n - 1) answer++;
        }

        System.out.println(answer);
    }

    public static void bigDfs(int start) {
        visited[start] = true;
        for (int node : big[start]) {
            if (visited[node]) continue;
            bigRes++;
            bigDfs(node);
        }
    }

    public static void smallDfs(int start) {
        visited[start] = true;
        for (int node : small[start]) {
            if (visited[node]) continue;
            smallRes++;
            smallDfs(node);
        }
    }
}
