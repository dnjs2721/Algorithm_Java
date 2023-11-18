package etc.Problem_No_2;
//원카드

import java.io.*;
import java.util.*;
class Main {
	static int n;
	static int s;
	static int k;
	static int[][] map;
	static int[] visited;
	static int[] dx = new int[]{-1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[k + 1][n + 1]; // 1 부터 n까지
		visited = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			map[1][i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 2; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(s, 1);
		for (int i = 1; i <= n; i++) {
			bw.write(visited[i] + " ");
		}
		bw.close();
	}
	
	public static void dfs(int x, int depth) {
		for (int i = 0; i < 2; i++) {
			int before = x;
			int nx = x + dx[i];
			while (true) {
				if (nx < 1) {
					if (visited[1] == 1) break;
					if (depth == k) {
						visited[1] = 1;
						break;
					}
 					dfs(1, depth + 1);
					break;
				}
				if (nx > n) {
					if (visited[n] == 1) break;
					if (depth == k) {
						visited[n] = 1;
						break;
					}
 					dfs(n, depth + 1);
					break;
				}
				if (map[depth][nx] > map[depth][before]){
						if (visited[before] == 1) break;
						if (depth == k) {
							visited[before] = 1;
							break;
						}
 						dfs(before, depth + 1);
						break;
				}
				
				before = nx;
				nx += dx[i];
			}
		}
	}
}

// n X 1의 직사각형 맵
// 1 ~ n 순서의 구역
// S번이 현재위치
// 왼쪽 오른쪽 두 방향으로 이동
// K번 다른 방향 가능
// 한번 굴리면 계속 굴러감
// 더 굴러갈 수 없는 경우 멈춤
// 굴러갈 수 없는 경우
// 1. 다음 구역이 자신보다 높을경우
// 2. 맵의 범위를 벗어나는 경우
// 맵은 k - 1번 변함