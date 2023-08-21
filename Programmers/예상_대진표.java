package Programmers;

public class 예상_대진표 {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    public static int solution(int n, int a, int b) {
        int answer = 0;

        while (n != 1) {
            answer++;
            if (Math.min(a, b) % 2 == 1 && Math.abs(a - b) == 1) {
                return answer;
            }
            a = cal(a);
            b = cal(b);

            n /= 2;
        }

        return answer;
    }

    public static int cal (int target) {
        int res = target / 2;
        if (target % 2 != 0) {
            res++;
        }
        return res;
    }
}
