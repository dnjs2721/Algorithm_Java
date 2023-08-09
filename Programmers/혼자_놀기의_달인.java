package Programmers;

import java.util.*;
public class 혼자_놀기의_달인 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{8,6,3,7,2,5,1,4}));
    }
    public static int solution(int[] cards) {
        int[] visited = new int[cards.length];
        ArrayList<Integer> res = new ArrayList<>();

        for (int idx = 0; idx < cards.length; idx++){
            if (visited[idx] == 1) {
                continue;
            }
            visited[idx] = 1;
            int count = 1;
            int nextIdx = cards[idx] - 1;

            while (visited[nextIdx] == 0) {
                visited[nextIdx] = 1;
                count++;
                nextIdx = cards[nextIdx] - 1;
            }
            if (count == cards.length) {
                return 0;
            }
            res.add(count);
        }

        Collections.sort(res, (o1, o2) -> o2 - o1);

        return res.get(0) * res.get(1);
    }
}
