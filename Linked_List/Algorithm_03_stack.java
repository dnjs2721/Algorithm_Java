package Linked_List;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Algorithm_03_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        ArrayList<String> tmp = new ArrayList<>();

        for(int i = N; i > 0; i--){
            stack1.push(Integer.toString(i));
        }

        int pointer = 0;

        for(int i = 0; i < N; i++){
            pointer += K-1;
            if(pointer >= stack1.size()){
                pointer = pointer%stack1.size();
            }
            for(int j = 0; j < pointer; j++){
                stack2.push(stack1.pop());
            }
            tmp.add(stack1.pop());
            while(!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
        StringJoiner sj = new StringJoiner(", ");
        bw.write("<");
        for(String i:tmp){
            sj.add(i);
        }
        String result = sj.toString();
        bw.write(result);
        bw.write(">");
        bw.flush();
        bw.close();
    }
}