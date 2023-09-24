package BaekJoon;

import java.io.*;

public class 백준_셀프_넘버 {

    static boolean[] visited = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = 0;
        while (number < 10000) {
            number++;
            if (visited[number]) continue;
            search(number);
            bw.write(number + "\n");
        }
        bw.close();
    }

    public static void search(int x) {
        if (x > 10000) return;
        visited[x] = true;
        if (x <= 9) {
            x += x;
        } else {
            char[] arr = String.valueOf(x).toCharArray();
            for (char c : arr) {
                x += Integer.parseInt(String.valueOf(c));
            }
        }
        search(x);
    }
}