package Programmers;

public class 점_찍기 {
    public static void main(String[] args) {
        System.out.println(solution(2, 4));
    }

    public static long solution(int k, int d) {
        long answer = 0;
        long maxD = (long) d * (long) d;

        for (long x = 0; x <= d; x += k) { // x 좌표를 k 배수만큼 증가
            // y^2 = d^2 - x^2
            long maxY = (long) Math.sqrt(maxD - (x * x)); // 피타고라스 정리를 통해 최대 y를 구한다. sqrt == 루트
            answer += (maxY / k) + 1; // 0부터 최대 y내에 k의 배수가 몇개가 있는지
        }
        return answer;
    }
}
