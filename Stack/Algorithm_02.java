package Stack;

import java.io.*;
import java.util.Stack;

public class Algorithm_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0; i< K; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) stack.pop();
            else stack.push(num);
        }

        while(!stack.empty()){
            result += stack.pop();
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}