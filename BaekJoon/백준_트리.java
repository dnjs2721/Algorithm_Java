package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_트리 {

    static List<List<Integer>> map;
    static Set<Integer> find = new TreeSet<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) continue;
            map.get(parent).add(i);
        }

        dfs(Integer.parseInt(br.readLine()));
        System.out.println(map);
        for (int node : find) {
            map.remove(node);
        }
        System.out.println(map);

        if (map.size() == 1) {
            System.out.println(1);
        } else {
            int count = 0;
            for (List<Integer> m : map) {
                if (m.isEmpty()) count++;
                if (m.size() == 1 && m.get(0) >= map.size()) count++;
            }
            System.out.println(count);
        }
    }

    public static void dfs(int start) {
        find.add(start);
        for (int child : map.get(start)) {
            dfs(child);
        }
    }
}