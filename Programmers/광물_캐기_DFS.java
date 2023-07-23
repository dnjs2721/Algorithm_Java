package Programmers;

public class 광물_캐기_DFS {

    static int answer = Integer.MAX_VALUE;
    static int total = 0;
    static int[] visited;

    public static int solution(int[] picks, String[] minerals) {
        visited = new int[picks.length];

        // total -> 모든 곡괭이의 수
        for (int pick : picks) {
            total += pick;
        }

        for (int i = 0; i < picks.length; i++) { // 다이아몬드, 철, 돌 곡괭이 순으로 깊이 탐색한다.
            if (picks[i] == visited[i]) { // 만약 해당 곡괭이를 다 사용하였다면
                continue;
            }
            visited[i]++; // 해당 곡괭이 사용
            dfs(1, 0, i, 0, picks, minerals); // 사용 곡괭이 수, 채굴 대상 광물의 인덱스 번호, 곡괭이 종류, 피로도 0, 곡괭이들, 광물들
            visited[i]--; // 다음 탐색을 위해 차감
        }

        return answer;
    }

    public static void dfs(int count, int startMineralsIdx, int pickIdx, int sum, int[] picks, String[] minerals) {
        if (answer <= sum || startMineralsIdx >= minerals.length) {
            return;
        }

        int add = 0;

        // 곡괭이 하나가 수행하는 부분
        // startMineralsIdx -> 채굴을 시작할 광물의 인덱스 번호
        for (int i = startMineralsIdx; i < startMineralsIdx + 5; i++) { // i < startMineralsIdx + 5 -> 각 곡괭이는 광물 상관없이 5개만 캘 수 있다.
            if (i >= minerals.length) { // 광물 채굴이 끝났을 때
                break;
            }

            String mineral = minerals[i];

            if (pickIdx == 0) { // 곡괭이가 다이아몬드일때는 모든 광물의 피로도가 1이다.
                add++;
            } else if (pickIdx == 1) { // 곡괭이가 철일때 광물이 다이아몬드라면 피로도가 5, 나머지는 1이다.
                add += mineral.equals("diamond") ? 5 : 1;
            } else if (mineral.equals("diamond")) { // 곡괭이가 돌일때 광물이 다이아몬드라면 피로도가 25
                add += 25;
            } else { // 곡괭이가 돌일때 광물이 철이라면 피로도가 5, 돌이라면 1
                add += mineral.equals("iron") ? 5 : 1;
            }
        }

        // count -> 현재까지 사용한 전체 곡괭이의 수
        if (count >= total || startMineralsIdx + 5 >= minerals.length) { // 곡괭이를 모두 사용하였거나, 더이상 채굴할 광물이 없을경우
            answer = Math.min(answer, sum + add);
            return;
        }

        for (int i = 0; i < picks.length; i++) { // 곡괭이 배열 0, 1, 2 를 탐색한다. 순서대로 다이아몬드, 철, 돌 곡괭이
            if (picks[i] == 0 || picks[i] == visited[i]) { // 만약 해당 곡괭이의 수가 0이거나 이미 다 사용하였다면
                continue;
            }
            visited[i]++; // 해당 곡괭이 사용
            dfs(count + 1, startMineralsIdx + 5, i, sum + add, picks, minerals); // 재귀 -> 전체 사용 곡괭이 수 + 1, 다음 채굴할 광물 인덱스 번호, 곡괭이 종류, 현재까지의 피로도, 곡괭이들, 광물들
            visited[i]--; // 다음 탐색을 위해 차감
        }
    }

    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(solution(picks, minerals));
    }
}
