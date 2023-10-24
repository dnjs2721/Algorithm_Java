package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_숫자고르기 {
    static int n;
    static int[] map;
    static ArrayList<Integer> answer = new ArrayList<>();
    static boolean[] visited;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            start = i;
            visited[i] = true;
            dfs(i);
            visited[i] = false;
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (int num : answer) {
            System.out.println(num);
        }
    }

    public static void dfs(int idx) {
        if (!visited[map[idx]]) {
            visited[map[idx]] = true;
            dfs(map[idx]);
            visited[map[idx]] = false;
        }

        if (map[idx] == start) {
            answer.add(start);
        }
    }
}

//1234
//2341