package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_2048_Platinum {
    static int n;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(Integer.parseInt(br.readLine()));
            return;
        }

        int[][] map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 4; i++) { // 처음 시작 상하좌우
            dfs(dx[i], dy[i], map, 0);
        }

        System.out.println(answer);
    }

    public static void dfs(int nx, int ny, int[][] map, int depth) {
        if (depth == 10) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res = Math.max(res, map[i][j]);
                }
            }
            answer = Math.max(answer, res);
            return;
        }

        int[][] tmp = new int[n][n];
        if (ny == 0) {
            for (int i = 0; i <= n - 1; i++) {
                int before = 0;
                if (nx == -1) {
                    int idx = 0;
                    for (int j = 0; j <= n - 1; j++) {
                        if (map[i][j] == 0) continue;
                        else if (before == 0) {
                            before = map[i][j];
                        } else  {
                            if (before != map[i][j]) {
                                tmp[i][idx] = before;
                                before = map[i][j];
                                idx++;
                            } else {
                                tmp[i][idx] = before * 2;
                                before = 0;
                                idx++;
                            }
                        }
                    }
                    tmp[i][idx] = before;
                } else {
                    int idx = n - 1;
                    for (int j = n - 1; j >= 0; j--) {
                        if (map[i][j] == 0) continue;
                        else if (before == 0) {
                            before = map[i][j];
                        } else  {
                            if (before != map[i][j]) {
                                tmp[i][idx] = before;
                                before = map[i][j];
                                idx--;
                            } else {
                                tmp[i][idx] = before * 2;
                                before = 0;
                                idx--;
                            }
                        }
                    }
                    tmp[i][idx] = before;
                }
            }
        } else {
            for (int j = 0; j <= n - 1; j++) {
                int before = 0;
                if (ny == -1) {
                    int idx = 0;
                    for (int i = 0; i <=n - 1; i++) {
                        if (map[i][j] == 0) continue;
                        else if (before == 0) {
                            before = map[i][j];
                        } else  {
                            if (before != map[i][j]) {
                                tmp[idx][j] = before;
                                before = map[i][j];
                                idx++;
                            } else {
                                tmp[idx][j] = before * 2;
                                before = 0;
                                idx++;
                            }
                        }
                    }
                    tmp[idx][j] = before;
                } else {
                    int idx = n - 1;
                    for (int i = n - 1; i >= 0; i--) {
                        if (map[i][j] == 0) continue;
                        else if (before == 0) {
                            before = map[i][j];
                        } else  {
                            if (before != map[i][j]) {
                                tmp[idx][j] = before;
                                before = map[i][j];
                                idx--;
                            } else {
                                tmp[idx][j] = before * 2;
                                before = 0;
                                idx--;
                            }
                        }
                    }
                    tmp[idx][j] = before;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            dfs(dx[i], dy[i], tmp, depth + 1);
        }
    }
}