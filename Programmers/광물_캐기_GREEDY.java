package Programmers;

import java.util.*;

public class 광물_캐기_GREEDY {

    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(solution(picks, minerals));
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 그룹 초기화
        // 한 곡괭이당 5개의 광물을 캘 수 있기 때문에 광물을 5개씩 믂는다.
        int groupSize = minerals.length / 5 + 1;
        List<Mineral>[] group = new ArrayList[groupSize];
        for (int i = 0; i < groupSize; i++) {
            group[i] = new ArrayList<>();
        }


        int count = 0; // 광물 캔 횟수
        int pickSum = Arrays.stream(picks).sum(); // 전체 곡괭이의 수
        for (int i = 0; i < groupSize; i++) { // 그룹의 수 만큼 반복
            if (pickSum == 0) { // 남은 곡괭이가 없다면
                break;
            }
            for (int j = count; j < minerals.length; j++) { // 광물의 수 만큼 반복한다.
                count++;
                String mineral = minerals[j];

                // 돌 곡괭이 기준으로 자원 별 비용 정의
                int cost = switch (mineral) {
                    case "diamond" -> 25;
                    case "iron" -> 5;
                    case "stone" -> 1;
                    default -> 0;
                };

                // 그룹에 비용과 자원의 이름을 저장한다.
                group[i].add(new Mineral(cost, mineral));

                // 5번의 광질이 끝나면 곡괭이 수를 감소시키고 탈출
                if (count % 5 == 0) {
                    pickSum--;
                    break;
                }
            }
        }

        // 비용 저장(Node 에 index, cost 를 저장)
        List<Node> cost = new ArrayList<>();
        for (int i = 0; i < group.length; i++) {
            int sum = group[i].stream()
                    .mapToInt(Mineral::getCost)
                    .sum();
            cost.add(new Node(i, sum));
        }

        // 비용을 내림차순으로 정렬
        // Node 에 저장된 index 를 이용해서 group 에 있는 자원을 캔다.
        cost.sort((o1, o2) -> Integer.compare(o2.getTotalCost(), o1.getTotalCost()));

        // 그룰별로 비용이 비싼것 부터 cost 에 저장되어 있다.
        // 다이아 철 돌 순으로 캔다.
        for (Node value : cost) {

            // 다이아몬드 곡괭이 사용
            if (picks[0] > 0) {
                int node = value.getNode();
                for (Mineral m : group[node]) {
                    answer += 1;
                }
                picks[0]--;
            }

            // 찰 곡괭이 사용
            else if (picks[1] > 0) {
                int node = value.getNode();
                for (Mineral m : group[node]) {
                    if (m.getMineral().equals("diamond")) {
                        answer += 5;
                    } else {
                        answer += 1;
                    }
                }
                picks[1]--;
            }

            // 돌 곡괭이 사용
            else if (picks[2] > 0) {
                int node = value.getNode();
                for (Mineral m : group[node]) {
                    switch (m.getMineral()) {
                        case "diamond" -> answer += 25;
                        case "iron" -> answer += 5;
                        case "stone" -> answer += 1;
                    }
                }
                picks[2]--;
            }

            // 남은 곡괭이가 없으면 종료
            else {
                break;
            }
        }
        return answer;
    }

    static class Mineral {
        private int cost;
        private String mineral;

        public Mineral(int cost, String mineral) {
            this.cost = cost;
            this.mineral = mineral;
        }

        public int getCost() {
            return cost;
        }

        public String getMineral() {
            return mineral;
        }
    }

    static class Node {
        private int node;
        private int totalCost;

        public Node(int node, int totalCost) {
            this.node = node;
            this.totalCost = totalCost;
        }

        public int getNode() {
            return node;
        }

        public int getTotalCost() {
            return totalCost;
        }
    }
}