package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_뱀과_사다리_게임 {
    static int n, m; // 사다리와 뱀의 수
    static Map<Integer, Integer> map = new HashMap<>(); // 사다리와 뱀의 위치 정보
    static int[] visited; // 방문 배열 겸 해당칸에 도달 하기 위한 최소 주사위 갯수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 모든 칸은 최대 하나의 사다리 또는 뱀을 가지고 있다.
        // 즉 사다리로 이어진 두 칸 에는 뱀의 시작 과 끝이 있을 수 없으며, 그 반대도 동이라하다.
        // 이 말은 사다리와 뱀이 겹치지 않으니 구분하지 않아도 된다는 뜻이다.
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x, y); // x 칸에 도착하면 y 칸으로 이동한다.
        }

        visited = new int[101]; // 1부터 100까지의 방문 배열 초기화
        bfs(1); // 1부터 탐색 시작

        // 항상 100번칸에 도착한다.
        System.out.println(visited[100] - 1); // 100번칸의 최소 주사위를 출력한다.
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1; // 원래 시작은 0이지만 편의를 위해 1로 저장, 후에 -1 처리
        while (!q.isEmpty()) { // 큐가 빌 때 까지 탐색
            Integer now = q.poll(); // 현재 위치
            for (int i = 1; i <= 6; i++) { // 1부터 6까지의 주사위 눈금, 해당 수 만큼 이동한다
                int next = now + i; // 주사위 눈금과 현재 위치를 더한 값
                if (next > 100) continue; // 만약 next 가 100을 넘는다면 이동이 불가능하다.
                // map 의 getOrDefault 를 통해 만약 해당칸에 사다리나 뱀이 있다면 사다리나 뱀을 통해 이동한 뒤의 위치를 반환
                // 사다리가 없다면 next 의 값을 가진다.
                Integer afterRolling = map.getOrDefault(next, next); // 이동 후 위치
                // 만약 이동 후 위치가 방문한 곳이라면 최소 주사위가 아니기에 넘어간다.
                if (visited[afterRolling] == 0) {  // 이동 후 위치가 방문한적 없는 위치라면
                    visited[afterRolling] = visited[now] + 1; // 주사위를 굴리기 전의 위치의 주사위 수 + 1을 한 값을 저장한다.
                    q.add(afterRolling); // 큐에 추가하여 탐색을 이어간다.
                }
            }
        }
    }
}

// 주사위의 각 면에는 1부터 6까지 수가 하나씩 있다.
// 게임의 크기는 10x10, 1 ~ 100
// 주사위의 수만큼 이동해야 한다.
// 100번 칸을 넘어가면 이동 불가능
// 도착 칸이 사다리라면 사다리를 타고 이동
// 뱀이 있는 칸에 도착하면 뱀을 따라 내려감
// 1번 칸에서 시작해 100번 칸에 도착하자.
// 최소한으로 주사위를 굴려서!
