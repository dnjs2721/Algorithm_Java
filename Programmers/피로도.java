package Programmers;

public class 피로도 {
    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

    public static int answer = 0;

    public static int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        dfs(k, dungeons, visited, 0);

        return answer;
    }

    public static void dfs(int tired, int[][] dungeons,  boolean[] visited, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= tired) {
                visited[i] = true;
                dfs(tired - dungeons[i][1], dungeons, visited, cnt + 1);
                visited[i] =false;
            }
        }
        answer = Math.max(answer, cnt);
    }
}
