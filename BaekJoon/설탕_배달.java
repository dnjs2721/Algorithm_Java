package BaekJoon;

import java.util.*;

public class 설탕_배달 {
    static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        check(n, 0);
        return answer;
    }

    public static void check(int n, int count) {
        if (n % 5 == 0) {
            answer = count + n / 5;
            return;
        }
        if (n < 0) {
            answer = -1;
            return;
        }
        check(n - 3, count + 1);
    }
}
