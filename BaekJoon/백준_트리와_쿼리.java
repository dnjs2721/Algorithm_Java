package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_트리와_쿼리 {
    static ArrayList<Integer>[] map; // 부모와 자식이 판별되지 않은 간선의 정보
    static int[] dp; // 각 노드에 대해 자신과 자식들을 포함한 정점의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u].add(v);
            map[v].add(u);
        }

        dp = new int[n + 1];
        dfs(r); // 루트 노드부터 탐색한다.

        for (int i = 0; i < q; i++) {
            bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
        }

        bw.close();
    }

    public static int dfs(int start) {
        dp[start] = 1; // 방문 체크 겸 자기자신 포함
        int count = 1; // 연결된 노드의 수를 나타낸다.
        ArrayList<Integer> nodes = map[start]; // 연결된 노드들
        for (int node : nodes) { // 순회
            // 트리이기 때문에 사이클이 없다. 즉 부모가 하나 이거나 없거나(루트노드) 둘 중 하나
            if (dp[node] != 0) { // 루트에서 내려오기 있기 때문에 이미 방문한 노드라면 자신보다 상위 즉 부모 노드라는 뜻
                continue;
            }
            // 부모가 아니라면 자식 노드
            count += dfs(node); // 방문하지 않은곳 == 자식노드
            // 자식노드를 탐색한 후 자식노드에 연결된 노드의 갯수를 현재 노드 count 에 추가
        }

        // 자신과 연결된 노드의 수를 저장하고 반환한다.
        return dp[start] = count;
    }
}

//         5
//       /   \
//     4      6
//    /    / | \
//   3    7  9  8
// /  \
//1    2