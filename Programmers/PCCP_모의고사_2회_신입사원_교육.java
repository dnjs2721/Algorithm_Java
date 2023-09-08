package Programmers;

import java.util.*;
public class PCCP_모의고사_2회_신입사원_교육 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 3, 7, 2}, 2));
    }
    public static int solution(int[] ability, int number) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int n : ability) {
            heap.add(n);
        }

        for (int i = 0; i < number; i++) {
            int sum = heap.poll() + heap.poll();
            heap.add(sum);
            heap.add(sum);
        }

        for (Integer n : heap) {
            answer += n;
        }

        return answer;
    }
}

// 신입사원 중 2명 선발
// 능력치는 정수로 표현
// 두 신입 사원의 능력치는 공부 전 두 사람의 능력치 합
// ex) a = 3, b = 7 -> a = 10, b = 10
// 선발한 2인의 교육이 끝나면 다시 2인 선발 가능
// 같은 사원이 다시 선발 될 수 있음

// 목표 = 교육 후 모든 신입사원들의 능력치의 합을 최소화
// 매 시행마다 가장 작은값 2개를 선택하여 갱신
// 작은 값 2개를 선택하기위해 매번 정렬하면 시간초과 가능성
// heap 사용