package Linked_List;

import java.io.*;
import java.util.Stack;

public class Algorithm_01 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<Character>right = new Stack<>();
        Stack<Character>left = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            left.push(str.charAt(i));
        }

        for(int i = 0; i < M; i++){
            String command = br.readLine();
            char com = command.charAt(0);
            if(com == 'L'){
                if(left.empty()) continue;
                else right.push(left.pop());
            }else if(com == 'D'){
                if(right.empty()) continue;
                else left.push(right.pop());
            }else if(com == 'B'){
                if(left.empty()) continue;
                else left.pop();
            }else{
                char val = command.charAt(2);
                left.push(val);
            }
        }

        while(!left.empty()){
            right.push(left.pop());
        }

        while(!right.empty()){
            bw.write(right.pop());
        }
        bw.flush();
        bw.close();
    }
}