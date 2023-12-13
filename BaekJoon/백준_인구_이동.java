package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_인구_이동 {
    static int N; // 땅의 가로, 세로 크기
    static int L; // 인구 이동을 해야하는 범위
    static int R; // 인구 이동을 해야하는 범위
    static int[][] A; // 각 나라별 인구수를 저장하는 배열
    static int[][] association; // 각 나라별 연합 번호를 나타내는 배열
    static int[] dx = {0, 0, -1, 1}; // 상하좌우 이동에 대한 x좌표 값
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우 이동에 대한 y좌표 값
    static Map<Integer, Integer> map; // 엽합별 평균 인구수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        // N * N 땅에 각 나라의 인구수를 입력받아 저장한다.
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0; // 인구 이동이 발생한 일 수
        // checkUnion == 인구 이동이 가능한 국가가 있는지 검사
        while (checkUnion()) { // 인구 이동이 가능하다면
            answer++; // 인구 이동이 발생한 일 수 + 1
            for (int i = 0; i < N; i++) { // 전체 국가 탐색
                for (int j = 0; j < N; j++) { // 전체 국가 탐색
                    if (association[i][j] == 0) continue; // 만약 연합국이 아니라면 continue
                    else { // 연합에 소속된 국가라면
                        // 해당 국가의 인구수를 연합의 인구 평균으로 변경한다.
                        A[i][j] = map.get(association[i][j]);
                    }
                }
            }
        }

        // 인구 이동이 발생한 일 수 출력
        System.out.println(answer);
    }

    /**
     * 인구 이동이 가능한 국가가 있는지 확인하는 메서드
     * @return true -> 인구 이동이 가능하다.
     * @return false -> 인구 이동이 불가능하다.
     */
    public static boolean checkUnion() {
        association = new int[N][N]; // 연합을 나타내며, 0이 아닌 수는 소속된 연합의 번호를 나타낸다.
        map = new HashMap<>(); // key 는 연합의 번호이며, value 로 연합의 평균 인구수를 가진다.

        boolean flag = false; // 인구 이동이 가능한지 확인하는 flag
        int countryNum = 1; // 연합 넘버링을 위한 countryNum

        for (int i = 0; i < N; i++) { // 전체 국가 탐색
            for (int j = 0; j < N; j++) { // 전체 국가 탐색
                if (association[i][j] != 0) continue; // 이미 연합국에 소속된 국가라면 continue
                else { // 엽합에 소속되지 않은 국가라면
                    // checkAssociation -> 연합국이 있는지 검사
                    // 연합국이 있다면 true 를 반환하며 연합국이 있다는 뜻은 인구이동이 가능하다는 뜻이다.
                    if (checkAssociation(j, i, countryNum)) flag = true;
                    countryNum++; // 다음 연합 넘버링을 위해 + 1
                }
            }
        }

        return flag;
    }

    /**
     * 엽합국이 있는지 검사하고 있다면 넘버링을 하는 메서드
     * @return true -> 연합국이 있다.
     * @return false -> 연합국이 없다.
     */
    public static boolean checkAssociation(int x, int y, int countryNum) {
        boolean flag = false; // 연합국이 있는지 확인하는 flag
        int count = 1; // 연합국의 수, 1은 자기 자신을 나타낸다.
        int sum = A[y][x]; // 연합국의 총 인구수

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y)); // 큐에 시작 국가를 넣는다.
        association[y][x] = countryNum; // 시작 국가의 연합 넘버를 설정한다.

        while (!q.isEmpty()) { // 큐가 빌 때 까지 반복
            Node node = q.poll(); // 탐색 시작 국가의 위치
            for (int i = 0; i < 4; i++) { // 상하좌우 이동
                int nx = node.x + dx[i]; // 탐색할 위치의 x 좌표
                int ny = node.y + dy[i]; // 탐색할 위치의 y 좌표

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 땅의 범위를 벗어났을 때 continue
                if (association[ny][nx] != 0) continue; // 탐색 국가가 이미 연합국에 소속되어 있을 때 continue

                // 탐색 시작 국가와 탐색하는 국가의 인구 수 차이
                // 절대값을 사용해 음수를 방지한다.
                int diff = Math.abs(A[ny][nx] - A[node.y][node.x]);
                if (L <= diff && diff <= R) { // 만약 두 국가의 인구 수 차이가 L아성 R이하 라면
                    association[ny][nx] = countryNum; // 탐색하는 국가를 같은 연합으로 설정
                    sum += A[ny][nx]; // 해당 연합에 대한 전체 인구수에 탐색하는 국가의 인구수를 더한다.
                    count++; // 해당 연합에 소속된 국가의 수 + 1
                    flag = true; // 연합이 형성 됐기 때문에 flag 를 true 로 변경
                    q.add(new Node(nx, ny)); // q에 탐색한 국가를 넣어 탐색을 이어간다.
                }
            }
        }

        // countryNum 연합에 대한 탐색이 끝이 났다면
        map.put(countryNum, sum / count); // map 에 countryNum 연합의 평균 인구수를 추가한다.
        return flag;
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


// n * n
// 각 땅에는 나라가 하나씩 존재
// map[i][j] 는 i 행 j열에 사는 사람
// 모든 국경선은 정사각형 -> 이동가능 상하좌우
// 아래 방법에 의해 인구 이동이 없을 때까지 반복
// 1. 인접한 두 구역의 차가 L <= num <= R 이라면 국경을 연다.
// 2. 인접한 국가들을 모두 검사하고 국경을 연다.
// 3. 국경이 열려 이동할 수 있는 국가들을 연합이라 칭하고, 해당 국가들의 인구수는 모든 연합의 인구수/연합에 속한 나라의 수
// 4. 연합을 해제하고 국경을 닫는다.