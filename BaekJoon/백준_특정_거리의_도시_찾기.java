package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_특정_거리의_도시_찾기 {
    static int n, m, k, x;
    static ArrayList<Integer>[] map;
    static int[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 도시의 개수
        m = Integer.parseInt(st.nextToken()); // 도로의 개수
        k = Integer.parseInt(st.nextToken()); // 거리 정보
        x = Integer.parseInt(st.nextToken()); // 시작 도시

        res = new int[n + 1]; // res[i]는 시작 도시로 부터 거리
        map = new ArrayList[n + 1]; // map[i]는 i 도사에서 갈 수 있는 도시들
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b); // a에서 갈 수 있는 도시로 b 추가
        }

        bfs(x); // 탐색 시작

        if (map[0].size() == 0) { // k 거리의 도시가 없다면
            System.out.println(-1); // -1 출력
        } else {
            map[0].sort((o1, o2) -> o1 - o2); // k 거리의 도시를 오름 차순으로 정렬
            for (int num : map[0]) {
                System.out.println(num); // 순서대로 출력
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        res[start] = 1; // 시작 도시의 거리는 0이지만 방문 체크를 위해 1로 설정
        while (!q.isEmpty()) { // 큐가 빌때까지 반복
            Integer startNode = q.poll(); // 탐색 시작 도시
            for (Integer node : map[startNode]) { // 탐색 시작 도시에서 갈 수 있는 도시들
                if (res[node] == 0) { // 만약 아직 방문하지 않은 도시라면
                    int cost = res[startNode] + 1; // 시작 도시에서 해당 도시 까지의 거리(실제로 해당 값에 - 1 한 값이 실제 거리이다.)
                    if (cost - 1 == k) {
                        map[0].add(node); // cost - 1이 k 와 같다면 map[0]에 추가
                    }
                    res[node] = cost; // 해당 도시의 거리를 저장
                    q.add(node); // 큐에 추가
                }
            }
        }
    }
}