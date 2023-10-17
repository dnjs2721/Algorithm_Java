package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_카잉_달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            boolean flag = true;
            for (int j = x; true; j += m) { // x 가 나오는 순번
                int k = j % n; // j % n 을 하면 현재 <x, k> 가 니온다.
                if (y == n && k == 0) { // k가 0일때 y가 n 이라면
                    bw.write(j + "\n");
                    break;
                }
                if (k == y) { // <x, k> == <x, y>
                    bw.write(j + "\n");
                    break;
                }
                // j + (m - x) 순서는 <m, > 일 떄 를 말한다. 이 순서에 % n 이 0이라면 <m, n>을 뜻한다.
                // x의 범위를 n 과 m의 최소 공배수까지로 설정하면 필요없음
                else if ((j + (m - x)) % n == 0) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                bw.write(-1 + "\n");
            }
        }
        bw.close();
    }
}