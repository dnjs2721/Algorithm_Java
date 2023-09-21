package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_트리 {

    static List<List<Integer>> map;
    static Set<Integer> find = new TreeSet<>((o1, o2) -> o2 - o1); // 삭제를 위해 큰 인덱스 부터 나열

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
        for (int node : find) {
            map.remove(node);
        }

        if (map.size() == 1) { // 노드가 한개 남았다면 리프 노드
            System.out.println(1);
        } else {
            int count = 0;
            for (List<Integer> m : map) { // 루트가 지워졌다면 0을 출력
                if (m.isEmpty()) count++; // 자식이 없다면 리프노드
                if (m.size() == 1 && m.get(0) >= map.size()) count++; // 자식이 하나 있지만 지워진 자식이라면 리프노드
                // 자식이 두개 이상 이라면 한 자식이 지워져도 리프노드가 될 수 없다.
            }
            System.out.println(count);
        }
    }

    public static void dfs(int start) {
        find.add(start); // 자식 인덱스를 모두 찾아 보관
        for (int child : map.get(start)) {
            dfs(child);
        }
    }
}