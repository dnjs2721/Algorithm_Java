package Programmers;

import java.util.*;

public class 배달 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3));
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        ArrayList<Node>[] map = new ArrayList[N + 1];
        PriorityQueue<Node> q = new PriorityQueue<>();

        for (int[] r : road) {
            int start = r[0], end = r[1], cost = r[2];

            if (map[start] == null) {
                map[start] = new ArrayList<>();
            }
            map[start].add(new Node(end, cost));

            if (map[end] == null) {
                map[end] = new ArrayList<>();
            }
            map[end].add(new Node(start, cost));
        }

        int[] dist = new int[N + 1];
        dist[1] = 0;
        for (int i = 2; i <= N; i++) {
            dist[i] = 500001;
        }

        q.add(new Node(1, 0));
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int weight = poll.getWeight(), end = poll.getEnd();

            for (Node node : map[end]) {
                int w = node.getWeight(), e = node.getEnd();

                if (weight + w < dist[e]) {
                    dist[e] = weight + w;
                    q.add(new Node(e, weight + w));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Node o){
            if(this.weight > o.weight)
                return 1;
            return -1;
        }
    }
}
