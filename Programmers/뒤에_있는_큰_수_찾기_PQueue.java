package Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 뒤에_있는_큰_수_찾기_PQueue {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 3, 3, 5})));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1); // 배열을 -1 로 채운다.

        PriorityQueue<Integer> pQ = new PriorityQueue<>(); // 우선 순위 큐 생성
        for (int i = numbers.length - 1; i > -1; i--) { // numbers 의 뒤에서 부터 탐색한다.
            int val = numbers[i]; // 현재 값

            while (!pQ.isEmpty()) { // 큐에 값이 존재한다면
                int poll = pQ.poll(); // 우선 순위가 제일 큰 값(수가 가장 작은 값)
                if (val < poll) { // 만약 현재이 큐의 값보다 작다면
                    answer[i] = poll; // 정답 배열을 수정한다.
                    pQ.add(poll); // 큐애 다시 추가
                    break;
                }
            }

            pQ.add(val); // 현재 값 추가
        }

        return answer;
    }
}
