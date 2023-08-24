package BaekJoon;

import java.util.*;

public class 설탕_배달 {
    static int[] pack = new int[]{5, 3};
    static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        if (n % 5 == 0) {
            return n / 5;
        }
        dp(n, 0);
        return answer;
    }

    public static void dp(int n, int count) {
        if (n == 0) {
            if (answer == -1) {
                answer = count;
            } else {
                answer = Math.min(answer, count);
            }
            return;
        } else if (n < 3) {
            return;
        }
        for (int i : pack) {
            if (answer == -1) {
                dp(n - i, count + 1);
            } else {
                if (answer <= count + 1) {
                    return;
                } else {
                    dp(n - i, count + 1);
                }
            }
        }
    }
}
