package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1_2_3_더하기 {

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            answer = 0;
            System.out.println(solution(Integer.parseInt(reader.readLine())));
        }
    }

    public static int solution(int n) {
        scan(n, n);
        return answer;
    }

    public static void scan(int number, int now) {
        if (now < 0) return;
        if (now == 0) {
            answer++;
            return;
        }
        scan(number, now - 1);
        scan(number, now - 2);
        scan(number, now - 3);
    }
}
