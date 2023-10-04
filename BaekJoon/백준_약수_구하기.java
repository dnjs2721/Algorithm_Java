package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_약수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (++count == k) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}