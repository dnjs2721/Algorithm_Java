package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_회장뽑기 {
    static int n;
    static ArrayList<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new ArrayList[n + 1]; // 친구 정보를 저장할 리스트 배열, map[i] 는 i의 친구들을 나타낸다.
        for (int i = 1; i <= n; i++) { // 1부터 n까지
            map[i] = new ArrayList<>(); // 리스트 초기화
        }

        StringTokenizer st;
        while (true) { // a, b 가 둘 다 -1 이면 입력 종료
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 사람 A
            int b = Integer.parseInt(st.nextToken()); // 사람 B
            if (a == -1 && b == -1) break; // a, b 둘 다 -1일 경우 입력 종료
            map[a].add(b); // a에 친구 b를 추가
            map[b].add(a); // b에 친구 a를 추가
        }

        int minScore = Integer.MAX_VALUE; // 현재까지의 최소 점수
        ArrayList<Integer> chairMans = new ArrayList<>(); // 회장 후보를 담는 리스트
        for (int i = 1; i <= n; i++) { // 1 부터 n 까지 탐색
            int res = bfs(i); // i 번째 사람을 기준으로 회장 점수를 계산한다.
            if (res <= minScore) { // 만약 회장 점수가 이전 minScore 보다 작거나 같을 때
                if (res < minScore) { // 작을 경우
                    minScore = res; // minScore 를 현재 회장 점수로 변경
                    chairMans.clear(); // 현재 회장 후보를 삭제한다.
                }
                chairMans.add(i); // 회장 후보에 i 추가
            }
        }
        System.out.printf("%d %d\n", minScore, chairMans.size()); // 회소 점수와 회장 후보의 수를 출력
        chairMans.sort((o1, o2) -> o1 - o2); // 회장 후보를 오름 차순으로 정렬
        for (int chairMan : chairMans) {
            System.out.print(chairMan + " "); // 회장 후보 출력
        }
    }

    public static int bfs(int start) {
        int[] visited = new int[n + 1]; // 방문배열 겸 각 인덱스가 몇다리 친구인지 저장하는 배열
        Queue<Integer> q = new LinkedList<>();
        q.add(start); // 큐에 시작 번호를 넣는다.
        // 방문배열[시작번호] 에는 1을 넣는다.
        // 1을 넣으면 1다리를 거쳐 친구가 된다는 말이지만 방문체크를 위해 1을 넣어야만 한다.
        // 후에 나온 결과에 -1을 해주면 올바를 결과를 얻을 수 있다.
        visited[start] = 1;
        while (!q.isEmpty()) { // 큐가 빌 때 까지 반복
            Integer startNode = q.poll(); // 탐색 시작 노드
            for (int node : map[startNode]) { // 탐색 시작 노드와 친구들인 노드들을 탐색
                if (visited[node] != 0) continue; // 만약 친구 노드가 0이 아니라면, 즉 이미 방문한 노드라면 통과
                // 친구 노드의 방문 값은 탐색 시작 노드의 방문 값 + 1이다.
                visited[node] = visited[startNode] + 1; // 탐색 시작 노드에서 한다리 걸쳐야지만 알 수 있는 노드라는 뜻
                q.add(node); // 큐에 친구 노드를 추가하고 탐색을 이어간다.
            }
        }

        // 방문 배열중 최대 값을 구한다.
        // 이 값이 start 번호를 기준으로 했을 때 start 의 회장 점수가 된다.
        // 방문배열[시작번호] 에 1을 넣었기 때문에 -1을 해준다.
        return Arrays.stream(visited).max().orElse(0) - 1; // orElse 가 동작하는 일은 없지만 하지 않으면 OptionalInt 를 반환햐야 한다.
    }
}