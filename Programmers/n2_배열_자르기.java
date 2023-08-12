package Programmers;

import java.util.ArrayList;
import java.util.List;

public class n2_배열_자르기 {
    public static void main(String[] args) {
        System.out.println(solution(3, 2, 5));
    }

    public static List<Long> solution(int n, long left, long right) {
        List<Long> answer = new ArrayList<>();

        for (long i = left; i < right + 1; i++) {
            long y = i / n;
            long x = i % n;
            if (y >= x) {
                answer.add(y + 1);
            } else {
                answer.add(x + 1);
            }
        }

        return answer;
    }
}
