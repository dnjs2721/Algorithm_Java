package Programmers;

import java.util.Arrays;

public class PCCP_모의고사_1회_유전법칙 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{3, 5}})));
    }
    public static String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 1) { // n 이 0이면 무조건 Rr
                answer[i] = "Rr";
            } else{
                answer[i] = scan(queries[i][0], queries[i][1]); // scan(n, p)
            }
        }

        return answer;
    }

    public static String scan(int n, int p) {
        int total = (int) Math.pow(4, n - 1); // 세대별 전체 개체의 수는 4^세대 - 1 이다.
        if (p <= total / 4) return "RR"; // n 세대 중 1/4 이하 개체는 무조건 "RR"
        if (p > total / 4 * 3) return "rr"; // n 세대 중 3/4 초과 개체는 무조건 "rr"
        if (n == 2) return "Rr"; // 위 두 조건에 부합하지 않을때 2세대 라면 "Rr"
        // n 세대 중 1/4 초과 2/4 이하 개체군과 n 세대 중 2/4 초과 3/4 이하 개체군은 n - 1 세대의 전체 개체 가계도랑 동일하다.
        if (p > total / 4 && p <= total / 2) { // 1/4 초과 2/4 이하 개체군일 경우
            return scan(n - 1, p - (total / 4)); // n - 1 세대의 p - (total / 4) 개체와 동일하다.
        } //  2/4 초과 3/4 이하 개체군일 경우
        return scan(n - 1, p - (total / 2)); // n - 1 세대의 p - (total / 2) 개체와 동일하다.
    }
}
