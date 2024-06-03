package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_상어_초등학교 {
    static int n;
    static int[][] map;
    static Map<Integer, Integer[]> friendsMap = new HashMap<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());

            int friend1 = Integer.parseInt(st.nextToken());
            int friend2 = Integer.parseInt(st.nextToken());
            int friend3 = Integer.parseInt(st.nextToken());
            int friend4 = Integer.parseInt(st.nextToken());

            friendsMap.put(number, new Integer[]{friend1, friend2, friend3, friend4}); // 현재 학생과 그 학생과 친한 친구 리스트를 Map 에 저장
            search(number); // 해당 입력에 대한 탐색 시작
        }

        System.out.println(satisfaction()); // 전체 만족도 조사 출력
    }

    public static void search(int number) {
        Integer[] friends = friendsMap.get(number); // 현재 학생과 친한 친구 리스트

        ArrayList<Integer[]> list = new ArrayList<>(); // 전체 자리에서 현재 학생에 대한 인접 친한 친구 수, 빈 자리 수, 행, 열을 가지는 리스트

        for (int y = 1; y <= n; y++) { // 전체 탐색
            for (int x = 1; x <= n; x++) {
                int friendsCount = 0;
                int emptyCount = 0;
                for (int i = 0; i < 4; i++) { // 상하좌우
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx > n || ny > n || nx <= 0 || ny <= 0) continue;

                    int now = map[ny][nx];
                    for (int friend : friends) if (now == friend) friendsCount++; // 상하좌우 자리에 친한 친구가 있다면 친한 친구 수 추가
                    if (now == 0) emptyCount++; // 비어있는 자리라면 빈 자리 수 추가
                }
                list.add(new Integer[] {friendsCount, emptyCount, y, x}); // 리스트에 해당 정보들 저장
            }
        }
        sorting(list); // 해당 학생에 대한 정보가 저장된 리스트를 정렬
        seat(list, number); // 정렬된 리스트를 통해 학생 배치
    }

    public static void sorting(ArrayList<Integer[]> list) {
        list.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] < o2[0]) return 1; // 친한 친구 수 비교
                else if (o1[0].equals(o2[0])) { // 친한 친구 수가 같을 경우
                    if (o1[1] < o2[1]) return 1; // 빈 자리 수 비교
                    else if (o1[1].equals(o2[1])) { // 빈 자리 수도 같을 경우
                        if (o1[2] > o2[2]) return 1; // 행 비교
                        else if (o1[2].equals(o2[2])) { // 행도 같을 경우
                            if (o1[3] > o2[3]) return 1; // 열 비교
                        }
                    }
                }
                return -1;
            }
        });
    }

    public static void seat(ArrayList<Integer[]> list, int number) {
        // 정렬된 리스트를 처음부터 순회 하면서 y, x 자리에 0이 존재한다면 그 학생의 자리
        // 정렬된 리스트이기 때문에 0이 처음 나온자리가 해당 학생의 자리
        for (Integer[] integers : list) {
            int y = integers[2];
            int x = integers[3];
            if (map[y][x] == 0) {
                map[y][x] = number;
                return;
            }
        }
    }

    public static int satisfaction() { // 만족도 조사
        int sum = 0;
        for (int y = 1; y <= n; y++) { // 학생들 자리 전체 탐색
            for (int x = 1; x <= n; x++) {
                int count = 0;
                Integer[] friendList = friendsMap.get(map[y][x]); // 현재 학생의 친한 친구 리스트 조회
                for (int i = 0; i < 4; i++) { // 현재 학생에서 상하좌우 학생들 탐색
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx > n || ny > n || nx <= 0 || ny <= 0) continue;

                    int now = map[ny][nx]; // 현재 탐색중인 학생의 상하좌우에 앉아있는 학생

                    for (int j = 0; j < 4; j++) { // 현재 탐생죽인 학생의 친한 친구 리스트에 상하좌우 학생이 있다면 count 증가
                        if (now == friendList[j]) count++;
                    }
                }
                switch (count) { // 카운트를 통해 선호도 조사
//                    case 0 -> sum += 0;
//                    case 1 -> sum += 1;
//                    case 2 -> sum += 10;
//                    case 3 -> sum += 100;
//                    case 4 -> sum += 1000;
                    case 0:
                        sum += 0;
                        break;
                    case 1:
                        sum += 1;
                        break;
                    case 2:
                        sum += 10;
                        break;
                    case 3:
                        sum += 100;
                        break;
                    case 4:
                        sum += 1000;
                        break;
                }
            }
        }

        return sum;
    }
}

/**
 * N * N 크기
 * 학생은 N^2, 1부터 N^2 의 번호가 매겨져있다.
 * (r, c) 는 r행 c열을 의미
 * 가장 윈쪽 칸 (1,1),가장 오른쪽 아랫칸 (N, N)
 * 선생이 학생의 순서를 정한다.
 * 각 학생이 좋아하는 학생 4명도 조사
 * 한 칸에는 학생 한명의 자라만 있다.
 * |r1 - r2| + |c1 - c2| = 1 을 만족하는 두 칸이 인접, 즉 상하좌우
 * 비어있는 칸 중에서 좋아하는 학생이 인전한 칸에 가장 많은 칸으로 자리를 정한다.
 * 1을 만족하는 칸이 여러개라면 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다
 * 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러개라면 여러개이면 열의 번호가 가장 작은 칸
 *
 */