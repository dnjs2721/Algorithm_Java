package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_케빈_베이컨의_6단계_법칙 {
    static int n; // 유저의 수
    static ArrayList<Integer>[] map; // 유저의 친구 관계를 나타내는 지도
    static int[] visited; // 친구가 된 사람들 체크, 각 인덱스에는 친구가 되기까지의 단계가 저장된다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 유저의 수 저장
        int m = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        map = new ArrayList[n + 1]; // 유저의 수 + 1만큼 List 배열 생성
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>(); // map[i] = i번 유저의 친구들
        }

        for (int i = 0; i < m; i++) { // 친구 관계의 수 만큼 반복
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // a, b 는 친구
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b); // a 의 친구 목록에 b 추기
            map[b].add(a); // b 의 친구 목록에 a 추가
        }

        int count = Integer.MAX_VALUE; // 현재 까지 가장 적은 케빈 베이컨의 수, min 비교를 위해 초기값은 MAX_VALUE
        int answer = 0; // 가장 적은 케빈 베이컨의 수를 가진 유저의 번호
        for (int i = 1; i <= n; i++) { // 1번 유저부터 n번 유저까지 반복
            int res = bfs(i); // i 유저의 케빈 베이컨의 수
            if (count > res) { // 현재 까지의 가장 적은 케빈 베이컨의 수 보다 i 유저의 케빈 베이컨의 수가 적다면
                count = res; // count 값을 i 유저의 케빈 베이컨의 수로 변경
                answer = i; // 가장 적은 케빈 베이컨의 수를 가진 유저의 번호를 i로 변경
            }
        }

        System.out.println(answer); // 가장 적은 케빈 베이컨의 수를 가진 유저의 번호 출력
    }

    public static int bfs(int start) {
        visited = new int[n + 1]; // 친구가 된 사람들 체크 배열 초기화
        visited[start] = -1; // 시작 유저의 친구 단계 -1로 설정, 0은 친구 아님, 그 이외는 친구로 간주

        Queue<Integer> q = new LinkedList<>(); // 큐 생성
        for (Integer node : map[start]) { // 시작 유저의 친구 목록을 탐색
            q.add(node); // 큐에 친구 추가
            visited[node] = 1; // 해당 node 유저는 1단계만에 친구가 된다.
        }

        while (!q.isEmpty()) { // 큐가 빌 때 까지 반복, 큐가 비었다는 뜻은 모든 유저가 친구가 됐다는 뜻이다.
            Integer startNode = q.poll(); // 큐에서 유저를 가지고 온다.
            for (Integer node : map[startNode]) { // 큐에서 가지고 온 유저의 친구 목록을 탐색
                if (visited[node] == 0) { // 만약 node 유저가 친구가 아니라면
                    q.add(node); // 큐에 친구 추가
                    visited[node] = visited[startNode] + 1; // 해당 node 유저의 친구 단계는 startNode 의 친구 단계 + 1 단계이다.
                }
            }
        }

        // 모든 친구 단계를 더한 뒤 반환
        return Arrays.stream(visited).sum() + 1; // 제일 처음 시작했던 유저의 친구 단계가 -1이었기에 + 1을 해준다.
        // 모든 시작 유저가 -1을 가지기에 사실상 + 1을 안해줘도 된다.
    }
}

// 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지