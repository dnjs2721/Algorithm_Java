package Programmers;

public class 콜라_문제 {
    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20));
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;
        while (true) {
            if (n / a > 0) {
                answer += (n / a) * b;
                n = n / a * b  + (n % a);
            } else {
                break;
            }
        }
        return answer;
    }
}
