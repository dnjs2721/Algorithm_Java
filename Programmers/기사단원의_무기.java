package Programmers;

public class 기사단원의_무기 {
    public static void main(String[] args) {
        System.out.println(solution(5, 3, 2));
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;
        for (int n = 1; n < number + 1; n++) {
            int sqrt = (int) Math.sqrt(n);
            int count = 0;
            for (int i = 1; i <= sqrt; i++) {
                if (n % i == 0) {
                    count++;
                    if (n / i != i) {
                        count++;
                    }
                }
            }
            if (count > limit) {
                answer += power;
                continue;
            }
            answer += count;
        }
        return answer;
    }
}
