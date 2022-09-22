package Linked_List;

import java.io.*;
import java.util.Stack;

public class Algorithm_02{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i< N; i++){
            String L = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for(int j = 0; j < L.length(); j++){
                char tmp = L.charAt(j);
                if(tmp == '<'){
                    if(left.empty()) continue;
                    else right.push(left.pop());
                }else if(tmp == '>'){
                    if(right.empty()) continue;
                    else left.push(right.pop());
                }else if(tmp == '-'){
                    if(left.empty()) continue;
                    else left.pop();
                }else left.push(tmp);
            }

            while(!left.empty()){
                right.push(left.pop());
            }

            while(!right.empty()){
                bw.write(right.pop());
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}