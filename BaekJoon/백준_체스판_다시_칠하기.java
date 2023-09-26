package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_체스판_다시_칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (arr[j] == 'W') map[i][j] = true;
            }
        }

        boolean[] wLine = new boolean[]{true, false, true, false, true, false, true, false};
        boolean[] bLine = new boolean[]{false, true, false, true, false, true, false, true};

        boolean[][] white = new boolean[8][8];
        boolean[][] black = new boolean[8][8];

        for (int i = 0; i < 8; i += 2) {
            white[i] = wLine;
            white[i + 1] = bLine;
            black[i] = bLine;
            black[i + 1] = wLine;
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int bCount = 0;
                int wCount = 0;

                int h = -1;
                for (int y = i; y < i + 8; y++) {
                    h++;
                    int w = -1;
                    for (int x = j; x < j + 8; x++) {
                        w++;
                        if (black[h][w] != map[y][x]) bCount++;
                        if (white[h][w] != map[y][x]) wCount++;
                    }
                }
                answer = Math.min(Math.min(bCount, wCount), answer);
            }
        }
        System.out.println(answer);
    }
}