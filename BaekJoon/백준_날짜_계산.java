package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_날짜_계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] year = new int[3];
        for (int i = 0; i < 3; i++) {
            year[i] = Integer.parseInt(st.nextToken());
        }

        int[] map = new int[3];
        Arrays.fill(map, 1); // 1, 1, 1
        int answer = 1; // 1년

        while (!Arrays.equals(map, year)) {
            if (++map[0] == 16) map[0] = 1; // 최대 15
            if (++map[1] == 29) map[1] = 1; // 최대 28
            if (++map[2] == 20) map[2] = 1; // 최대 19
            answer++;
        }

        System.out.println(answer);
    }
}