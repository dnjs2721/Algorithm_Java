package Programmers;
import java.util.*;
public class PCCP_모의고사_1회_운영체제 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new int[][]{{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}})));
        System.out.println(Arrays.toString(solution(new int[][]{{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}})));
    }
    public static long[] solution(int[][] program) {
        long[] answer = new long[11];
        Arrays.sort(program, (o1, o2) -> o1[1] - o2[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int index = 0;
        int cnt = 0;
        long t = 0L;
        while(cnt < program.length){
            while(index < program.length && program[index][1] <= t){
                pq.add(program[index]);
                index++;
            }
            if(pq.isEmpty()){
                t = program[index][1];
            } else{
                int[] cur = pq.poll();
                answer[cur[0]] += t - cur[1];
                t += cur[2];
                cnt++;
            }
        }
        answer[0] = t;
        return answer;
    }
}
