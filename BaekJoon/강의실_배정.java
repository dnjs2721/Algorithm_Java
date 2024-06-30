package BaekJoon;

import java.util.*;
import java.io.*;

public class 강의실_배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(s, t);
        }

        // 수업 시작 시간을 기준으로 오름차순 정렬
        // 시작 시간이 같다면 끝나는 시간으로 오름차순 정렬
        Arrays.sort(lectures, ((o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start));

        // 끝나는 시간을 저장하는 우선순위 큐
        // Integer 타입 우선순위 큐를 통해 작은 수가 더 높은 우선 순위이기에 앞에 위치한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && pq.peek() <= lectures[i].start) {
                // 가장 먼저 끝나는 수업의 끝나는 시간과 새로운 수업의 시작 시간을 비교
                // 같은 강의실을 사용할 수 있다면 이전 수업 정보를 제거
                pq.poll();
            }
            // 새로운 수업의 끝나는 시간을 저장
            pq.add(lectures[i].end);
        }

        System.out.println(pq.size());
    }

    static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}


// s 시간에 시작해 t 시간에 끝나는 수업 n 개가 주어진다
// 필요한 강의실의 개수를 출력하라

/*
8
1 8
9 16
3 7
8 10
10 14
5 6
6 11
11 12
*/

/*
시작시간 순으로 정렬, 시작 시간이 같다면 끝나는 시간으로 정렬
1 8
3 7
5 6
6 11
8 10
9 16
10 14
11 12
 */

/*
pq 내부 정렬되는 상태라고 가정
8 -> 16
7 -> 10 -> 14
6 -> 11 -> 12
 */