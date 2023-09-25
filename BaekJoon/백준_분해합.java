package BaekJoon;

import java.io.*;

public class 백준_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            int res = search(i);
            if (res == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    public static int search(int x) {
        int num = x;
        char[] arr = String.valueOf(x).toCharArray();
        for (char c : arr) {
            num += Integer.parseInt(String.valueOf(c));
        }
        return num;
    }
}