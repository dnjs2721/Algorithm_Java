package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_마인크래프트 {
    static int n, m, b;
    static int min = 0; // 주어진 최소 높이
    static int max = 255; // 주어진 최대 높이
    static int[][] map;
    static int minTime = Integer.MAX_VALUE; // 최소 시간이 필요하기에 초반 비교를 위한 Integer.MAX_VALUE
    static int maxHeight = 0; // 주어진 높이중 가장 낮은 높이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                min = Math.min(now, min); // 최소 높이
                max = Math.max(now, max); // 최대 높이
            }
        }

        search();

        System.out.println(minTime + " " + maxHeight);
    }

    public static void search() {
        int height = min - 1;
        while (height <= max) {
            height++; // min ~ max 까지의 높이
            int t = 0; // 현재 높이로 평탄화 하늩데 걸리는 시간
            int have = b; // 현재 높이로 평탄화 하면서 얻은 아이템

            for (int i = 0; i < n; i++) { // 맵 탐색 시작
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > height) { // 탐색 구역이 현재 높이보다 높을 경우
                        have += (map[i][j] - height); // 현재 높이의 차 만큼 가진 아이템 추가
                        t += 2 * (map[i][j] - height); // 현재 높이의 차 만큼 * 2 초 더하기
                    }
                    else if (map[i][j] < height) { // 탐색 구역이 현재 높이보다 낮을 경우
                        have -= (height - map[i][j]); // 현재 높이의 차 만큼 가진 아이템 사용
                        t += height - map[i][j]; // 현재 높이의 차 만큼 1초 더하기
                    } // 같은 높이의 경우 넘어간다.
                }
            }

            if (have < 0) { // 가진 아이템의 수가 0보다 작을경우 불가능한 상황이기에 넘어간다.
                continue;
            }
            // 답이 여러개일 경우 땅의 높이가 가장 높을 때를 채택한다.
            // 해당 while 문은 반복될수록 높이가 항상 높아지기에 이번 탐색에서 걸린 총 시간만 고려하면 된다.
            if (minTime >= t) { // 이번 탐색이 현재 기록된 최소 시간보다 짧을 때와, 같을 떄는 최대 높이를 고려해 값을 업데이트 한다.
                minTime = t;
                maxHeight = height;
            }
        }
    }
}
