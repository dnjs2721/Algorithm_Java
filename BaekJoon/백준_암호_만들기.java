package BaekJoon;

import java.util.*;
import java.io.*;

public class 백준_암호_만들기 {
    static int l, c;
    static String[] list;
    static List<String> vowel = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        list = br.readLine().split(" ");
        Arrays.sort(list);

        for (int i = 0; i < c - l + 1; i++) {
            check(0, 0, 1, i, list[i]);
        }

        bw.close();
    }

    public static void check(int v, int v2, int depth, int idx, String res) throws IOException {
        if (vowel.contains(list[idx])) v++;
        else v2++;

        if (depth == l) {
            if (v >= 1 && v2 >= 2) {
                bw.write(res + "\n");
            }
            return;
        }

        for (int i = idx + 1; i < c; i++) {
            check(v, v2, depth + 1, i, res + list[i]);
        }
    }
}