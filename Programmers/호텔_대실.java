package Programmers;

import java.util.*;

public class 호텔_대실 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
    }

    public static int solution(String[][] book_time) {
        int answer = 0;

        int[][] time = new int[book_time.length][2];

        // 시작, 종료 시간을 분 단위로 변환 후 time 배열에 저장
        for (int i = 0; i < book_time.length; i++) {
            String[] startSplit = book_time[i][0].split(":");
            int startMinute = Integer.parseInt(startSplit[0]) * 60 + Integer.parseInt(startSplit[1]);

            String[] endSplit = book_time[i][1].split(":");
            int endMinute = Integer.parseInt(endSplit[0]) * 60 + Integer.parseInt(endSplit[1]);

            time[i] = new int[]{startMinute, endMinute};
        }

        // time 배열의 시작 시간을 기준으로 정렬
        Arrays.sort(time, Comparator.comparing((int[] o) -> o[0]));

        // 우선순위 큐로 최소 Heap 구현
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] t : time) {
            int startMinute = t[0];
            int endMinute = t[1];

            // peek 을 통해 가장 빨리 끝나는 시간과 예약의 시작 시간을 비교
            // 시작 시간이 가장 빨리 끝나는 시간 보다 같거나 클시 기존 예약의 방을 사용
            if (!minHeap.isEmpty() && minHeap.peek()<= startMinute) {
                minHeap.poll(); // 가장 빨리 끝나는 시간을 삭제
                minHeap.add(endMinute  + 10); // 새로운 예약의 끝나는 시간을 등록
            } else { // 첫 예약 혹은 새로운 방이 필요할 시
                minHeap.add(endMinute + 10); // 새로운 예약의 끝나는 시간을 등록
                answer++; // 새로운 방 추가
            }
        }

        return answer;
    }
}
