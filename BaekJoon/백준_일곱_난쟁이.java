package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_일곱_난쟁이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) continue;
                if (sum - (arr[i] + arr[j]) == 100) {
                    idx1 = i;
                    idx2 = j;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == idx1 || i == idx2) continue;
            bw.write(arr[i] + "\n");
        }
        bw.close();
    }
}