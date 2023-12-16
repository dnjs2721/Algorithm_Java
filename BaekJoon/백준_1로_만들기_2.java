package BaekJoon;

import java.util.*;
import java.io.*;
public class 백준_1로_만들기_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] dp = new ArrayList[n + 1];

        dp[1] = new ArrayList<>(List.of(1));

        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> tmp = new ArrayList<>(dp[i - 1]);
            if (i % 3 == 0) {
                if (tmp.size() > dp[i / 3].size()) {
                    tmp = new ArrayList<>(dp[i / 3]);
                }
            }
            if (i % 2 == 0) {
                if (tmp.size() > dp[i / 2].size()) {
                    tmp = new ArrayList<>(dp[i / 2]);
                }
            }
            tmp.add(i);
            dp[i] = tmp;
        }

        System.out.println(dp[n].size() - 1);
        for (int i = dp[n].size() - 1; i >= 0; i--) {
            bw.write(dp[n].get(i) + " ");
        }
        bw.close();
    }
}