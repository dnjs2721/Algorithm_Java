package BaekJoon;

import java.io.*;

public class 백준_한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer;
        if (n <= 99) answer = n;
        else {
            answer = 99;
            for (int num = 100; num <= n; num++) {
                int first = num / 100;
                int second = num % 100 / 10;
                int third = num % 10;
                if (first - second == second - third) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
