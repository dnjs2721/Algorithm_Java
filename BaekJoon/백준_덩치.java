package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int kg = Integer.parseInt(st.nextToken());
            int cm = Integer.parseInt(st.nextToken());
            map[i][0] = kg;
            map[i][1] = cm;
        }

        for (int i = 0; i < n; i++) {
            int kg = map[i][0];
            int cm = map[i][1];
            int score = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (map[j][0] > kg && map[j][1] > cm) score++;
            }
            bw.write(score + " ");
        }
        bw.close();
    }
}