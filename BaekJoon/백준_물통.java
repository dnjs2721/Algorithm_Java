package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_물통 {
    static Set<Integer> answer = new HashSet<>();
    static boolean[][] visited = new boolean[201][201];
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dfs(0, 0, c);

        for (int n : answer) {
            bw.write(n + " ");
        }
        bw.close();
    }

    public static void dfs(int aa, int bb, int cc) {
        if (visited[aa][bb]) return;

        if (aa == 0) answer.add(cc);

        visited[aa][bb] = true;

        // a에서 b로
        if (aa + bb > b) {
            dfs(aa + bb - b, b, cc);
        } else {
            dfs(0, aa + bb, cc);
        }

        // b에서 a로
        if (bb + aa > a) {
            dfs(a, bb + aa - a, cc);
        } else {
            dfs(bb + aa, 0, cc);
        }

        // c에서 a로
        if (cc + aa > a) {
            dfs(a, bb, cc + aa - a);
        } else {
            dfs(cc + aa, bb, 0);
        }

        // c에서 b로
        if (cc + bb > b) {
            dfs(aa, b, cc + bb - b);
        } else {
            dfs(aa, cc + bb, 0);
        }

        // a 에서 c로
        dfs(0, bb, aa + cc);

        // b에서 c로
        dfs(aa, 0, bb + cc);
    }
}