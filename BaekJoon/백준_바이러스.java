package BaekJoon;

import java.io.*;
import java.util.*;

public class 백준_바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        List<List<Integer>> computer = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            computer.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            computer.get(com1).add(com2);
            computer.get(com2).add(com1);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int com = q.poll();
            for (int node : computer.get(com)) {
                if (visited[node]) continue;
                visited[node] = true;
                q.add(node);
                answer++;
            }
        }

        System.out.println(answer);
    }
}