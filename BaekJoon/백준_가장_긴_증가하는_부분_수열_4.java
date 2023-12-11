package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_가장_긴_증가하는_부분_수열_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수열의 크기

        int[] map = new int[n]; // 수열 저장 배열
        Node[] dp = new Node[n]; // dp[i] 는 map[i] 를 포함한 가징 긴 증가하는 부분 수열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken()); // 주어진 수열을 저장
            dp[i] = new Node();
            dp[i].add(map[i]); // dp[i] 의 초기값으로 map[i]를 가진다.
        }

        int maxLen = 1; // 수열의 크기가 최소 1부터 시작
        int maxIdx = 0; // dp 중 부분 수열의 길이가 가장긴 idx

        for (int i = 1; i < n; i++) { // dp[0] 은 map[0] 밖에 없기에 따로 탐색하지 않고 1 ~ n-1 까지 탐색한다.
            for (int j = 0; j < i; j++) { // i 보다 작은 인덱스들을 탐색한다.
                if (map[i] > map[j]) { // map[i] 가 map[j] 보다 클 때
                    if (dp[i].getSize() < dp[j].getSize() + 1) { // 현재 dp[i]의 길이보다 dp[j] + 1의 길이가 크다면
                        dp[i].update(dp[j]); // dp[i]의 값을 dp[j]의 값으로 변경
                        dp[i].add(map[i]); // dp[i]에 map[i] 추가
                    }
                }
            }
            if (dp[i].getSize() > maxLen) { // 만약 dp[i]의 길이가 maxLen 보다 크다면
                maxLen = dp[i].getSize(); // maxLen 변경
                maxIdx = i; // maxIdx 변경
            }
        }

        System.out.println(maxLen);
        for (int num : dp[maxIdx].list) { // 가장 긴 부분 수열을 가진 dp[maxIdx]
            System.out.print(num + " ");
        }
    }

    public static class Node {
        List<Integer> list;

        public Node() {
            this.list = new ArrayList<>();
        }

        public void add(int num) {
            this.list.add(num);
        }

        public void update(Node node) {
            this.list = new ArrayList<>(node.list);
        }

        public int getSize() {
            return list.size();
        }
    }
}

// input
// 13
// 3 4 5 6 2 3 1 7 4 3 5 6 7

// answer
// 6
// 2 3 4 5 6 7