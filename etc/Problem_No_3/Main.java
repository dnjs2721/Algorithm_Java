package etc.Problem_No_3;
// 공굴리기
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] map = new int[n]; 
		int[] visited = new int[14];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(map[0]);
		
		for (int i = 1; i < n; i++) {
			if (Math.abs(stack.peek() - map[i]) == 1) {
				stack.push(map[i]);
			} else {
				if (stack.size() >= 2) {
					answer++;
					while (!stack.isEmpty()) {
						int tmp = stack.pop();
						visited[tmp]++;
					}
				} else {
					stack.clear();
				}
				stack.add(map[i]);
			}
		}
		
		if (stack.size() >= 2) {
			answer++;
			while (!stack.isEmpty()) {
				int tmp = stack.pop();
				visited[tmp]++;
			}
		}
		

		System.out.println(answer);
		for (int i = 1; i <= 13; i++) {
			bw.write(visited[i] + " ");
		}
		bw.close();
	}
}

// 같은 문양, 숫자가 1만큼 차이 연속으로 카드 제거 가능
// 카드 문양 고려 안함 숫자는 1~13
// 13 <-> 1 불가
// 계단의 개수, 계단에 포함된 카드의 개수를 출력