package BaekJoon;

import java.io.*;
import java.util.*;
public class 백준_신나는_함수_실행 {

    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;

            bw.write("w(" + a + ", " + b + ", " + c + ") = "+ scan(a, b, c) + "\n");
        }

        bw.close();
    }

    public static int scan(int a, int b, int c) {
        if ((a > 0 && b > 0 && c > 0) && (a < 21 && b < 21 && c < 21)) {
            if (dp[a][b][c] != 0) return dp[a][b][c];
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a >= 21 || b >= 21 || c >= 21) {
            return dp[20][20][20] = scan(20, 20,20);
        } else {
            return dp[a][b][c] = scan(a - 1, b, c) + scan(a - 1, b - 1, c) + scan(a - 1, b, c - 1) - scan(a - 1, b - 1, c - 1);
        }
    }
}