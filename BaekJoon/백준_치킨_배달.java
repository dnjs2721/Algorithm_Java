package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_치킨_배달 {
    static int n, m;
    static int[][] map;
    static boolean[] visited;
    static List<Node> list;
    static List<Node> house;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        list = new ArrayList<>();
        house = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) list.add(new Node(j, i));
                else if (map[i][j] == 1) house.add(new Node(j, i));
            }
        }

        visited = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            visited[i] = true;
            search(i, 1);
            visited[i] = false;
        }

        System.out.println(answer);
    }

    public static void search(int idx, int depth) {
        if (depth == m) {
            cal();
            return;
        }
        for (int i = idx + 1; i < list.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            search(i,depth + 1);
            visited[i] = false;
        }
    }

    public static void cal() {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                nodes.add(list.get(i));
            }
        }

        int sum = 0;
        for (Node h : house) {
            int dis = Integer.MAX_VALUE;
            for (Node node : nodes) {
                dis = Math.min(Math.abs(h.y - node.y) + Math.abs(h.x - node.x), dis);
            }
            sum += dis;
        }

        answer = Math.min(answer, sum);
    }

    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}