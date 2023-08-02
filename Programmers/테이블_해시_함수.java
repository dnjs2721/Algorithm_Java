package Programmers;

import java.util.Arrays;

public class 테이블_해시_함수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3));
    }

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (o1, o2) -> o1[col-1] != o2[col-1] ? o1[col-1]-o2[col-1] : o2[0]-o1[0]);

        for (int i = row_begin - 1; i < row_end; i++) {
            int tmp = 0;
            for (int n : data[i]) {
                tmp += n % (i+1);
            }
            answer = answer ^ tmp;
        }

        return answer;
    }
}
