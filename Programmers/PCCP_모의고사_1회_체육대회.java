package Programmers;

public class PCCP_모의고사_1회_체육대회 {
    static int answer = 0;
    static int[][] arr;
    static int n;
    static int m;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}}));
    }

    public static int solution(int[][] ability) {
        n = ability.length;
        m = ability[0].length;
        arr = ability;

        dfs(0, new boolean[n], 0);

        return answer;
    }

    public static void dfs(int current, boolean[] check, int depth) {
        if (depth == m) {
            answer = Math.max(current, answer);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(current + arr[i][depth], check, depth + 1);
                check[i] = false;
            }
        }
    }
}
