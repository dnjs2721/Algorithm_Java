package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_A_to_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(solution1(A, B)); // BFS
        System.out.println(solution2(A, B)); // Math
    }

    private static int solution1(int A, int B) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A, 0)); // A 부터 탐색 시작

        while (!q.isEmpty()) { // 큐가 빌 때 까지 탐색 시작
            Node node = q.poll(); // 현재 수와 탐색 횟수
            int num = node.num;  // 현재 수

            if (num <= 99999999) { // 인트형에서 뒤에 1을 추가했을 때 표현할 수 있는 최대는 99999999이다 -> 999999991
                int numPlus1 = Integer.parseInt(num + "1"); // num 뒤에 1을 추가 ex) 12 -> 121
                if (numPlus1 == B) { // 해당 조건이 처음 통과 했을 때가 연산의 최소값이다.
                    return node.count + 2; // 현재까지 연산횟수 + 이번 연산 횟수 1 + 1 반환
                } else if (numPlus1 < B) { // numPlus1이 B보다 작을 경우
                    q.add(new Node(numPlus1, node.count + 1)); // 큐에 추가
                }
            }

            if (num * 2 == B) { // 해당 조건이 처음 통과 했을 때가 연산의 최소값이다.
                return node.count + 2; // 현재까지 연산횟수 + 이번 연산 횟수 1 + 1 반환
            } else if (num * 2 < B) { // num * 2가 B보다 작을 경우
                q.add(new Node(num * 2, node.count + 1)); // 큐에 추가
            }
        }

        return -1; // 만들 수 없는 경우
    }

    public static class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    private static int solution2(int A, int B) {
        int count = 0; // 연산 횟수

        while (A <= B) { // A가 B도다 작거나 같을 때 까지
            if (A == B) { // 두 수가 같다면
                return count + 1; // 연산횟수 + 1 반환
            }

            // 만약 B에서 2를 나눴을 때 나머지가 없다면
            if (B % 2 == 0) {
                count++; // 연산횟수 + 1
                B /= 2; // B = B / 2

            // 만약 B에서 10을 나눴을 때 나머지가 1이라면
            } else if (B % 10 == 1) {
                count++; // 연산횟수 + 1
                B /= 10; // B = B / 10 -> 1의 자리수 버림

            // 위 두 조건에 충족이 안된다면 만들 수 없는 수
            // 즉 끝 자리가 3, 5, 7, 9 인 경우 불가능 하다. : 2를 곱해서 나올 수 없는 수
            } else
                break;
        }

        return -1;  // 만들 수 없는 경우
    }
}