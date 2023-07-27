package Programmers;

import java.util.*;

public class 뒤에_있는_큰_수_찾기_Stack {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 3, 3, 5})));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1); // 배열을 -1 로 채운다.

        Stack<Integer> stack = new Stack<>(); // Stack 생성
        stack.push(0); // stack 에 index 0 추가

        for (int i = 1; i < numbers.length; i++) { // idx 1부터 시작
            int val = numbers[i]; // 현재 값
            while (!stack.isEmpty()) { // stack 에 값이 존재한다면
                Integer stackIdx = stack.pop(); // stack 의 제일 최근 값
                if (val > numbers[stackIdx]) { // 만약 현재 값이 numbers[stack] 의 값 보다 클 경우
                    answer[stackIdx] = val; // answer 배열 수정
                } else { // 만약 현재 값이 numbers[stack] 의 값 이랑 같거나 작을경우
                    stack.push(stackIdx);  // stack 에서 꺼냈던 idx 를 다시 추가.
                    break;
                }
            }
            stack.push(i); // stack 에 현재 idx 추가
        }

        return answer;
    }

}
