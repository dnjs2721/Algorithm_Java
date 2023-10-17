package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_감시 {
    static Node[] move = new Node[]{new Node(0, -1), new Node(0, 1), new Node(-1, 0), new Node(1, 0)};
    static int[][] cam1 = new int[][]{{0}, {1}, {2}, {3}}; // 상하좌우
    static int[][] cam2 = new int[][]{{0, 1}, {2, 3}, {0, 1}, {2, 3}}; // 상하, 좌우
    static int[][] cam3 = new int[][]{{0, 3}, {3, 1}, {1, 2}, {2, 0}}; // 상우, 우하, 하좌, 좌상
    static int[][] cam4 = new int[][]{{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}}; // 상하좌, 상하우, 상좌우, 하좌우
    static int[][] cam5 = new int[][]{{0, 1, 2, 3}}; // 상하좌우
    static int n;
    static int m;
    static List<Node> cam = new ArrayList<>();
    static List<Node> five = new ArrayList<>();
    static int[][] map;
    static int[] output;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) continue;
                else if (map[i][j] <= 4) {
                    cam.add(new Node(j, i));
                } else if (map[i][j] == 5){
                    five.add(new Node(j, i));
                }
            }
        }

        for (Node node : five) {
            check(map, node, cam5[0]);
        }
        output = new int[cam.size()];
        permutation(0, cam.size());

        System.out.println(answer);
    }
    public static void permutation(int depth, int r) {
        if (depth == r) {
            int[][] copy = new int[n][m];
            for (int i = 0; i < n; i++) {
                copy[i] = Arrays.copyOf(map[i], m);
            }
            for (int i = 0; i < cam.size(); i++) {
                move(copy, cam.get(i), output[i]);
            }

            int res = 0;
            for (int[] c : copy) {
                for (int j = 0; j < m; j++) {
                    if (c[j] == 0) {
                        res++;
                    }
                }
            }
            answer = Math.min(answer, res);

            return;
        }
        for (int i = 0; i < 4; i++) {
            output[depth] = i;
            permutation(depth + 1, r);
        }
    }

    public static void move(int[][] copy, Node cctv, int dir) {
        int x = cctv.x;
        int y = cctv.y;
        int type = map[y][x];

        if (type == 1) {
            check(copy, cctv, cam1[dir]);
        } else if (type == 2) {
            check(copy, cctv, cam2[dir]);
        } else if (type == 3) {
            check(copy, cctv, cam3[dir]);
        } else if (type == 4) {
            check(copy, cctv, cam4[dir]);
        }
    }

    public static void check(int[][] copy, Node cctv, int[] dic) {
        for (int j : dic) {
            Node node = move[j];
            boolean flag = true;
            int nx = cctv.x + node.x;
            int ny = cctv.y + node.y;
            while (flag) {
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || copy[ny][nx] == 6) {
                    flag = false;
                } else {
                    if (copy[ny][nx] == 0) copy[ny][nx] = -1;
                    nx += node.x;
                    ny += node.y;
                }
            }
        }
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