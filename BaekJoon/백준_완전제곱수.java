package BaekJoon;

import java.io.*;

public class 백준_완전제곱수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = -1;
        for (int i = m; i <= n; i++) {
            if (Math.sqrt(i) % 1 == 0) {
                if (min == -1) min = i;
                sum += i;
            }
        }

        if (sum == 0) {
            System.out.println(min);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}