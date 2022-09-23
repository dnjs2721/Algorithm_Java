package Linked_List;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Algorithm_03_queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringJoiner sj = new StringJoiner(", ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            queue.add(i+1);
        }

        int pointer = K-1;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < pointer; j++){
                queue.add(queue.poll());
            }
            sj.add(queue.poll().toString());
        }

        bw.write("<" + sj.toString() + ">");
        bw.flush();
        bw.close();
    }
}