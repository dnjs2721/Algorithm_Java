package BaekJoon;

import java.io.*;

public class 일로_만들기 {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(solution(Integer.parseInt(reader.readLine())));
    }

    public static int solution(int n) {

        scan(n, 0);

        return answer;
    }

    public static void scan(int n, int count) {
        if (n == 1) {
            answer = Math.min(answer, count);
            return;
        }
        if (count + 1 >= answer) return;
        if (n % 3 == 0) {
            scan(n / 3, count + 1);
        }
        if (n % 2 == 0) {
            scan(n / 2, count + 1);
        }
        scan(n - 1, count + 1);
    }
}

//11
//5
//4
//2
//1