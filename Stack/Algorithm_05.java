package Stack;

import java.io.*;
import java.util.Stack;;

public class Algorithm_05 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Long> stack = new Stack<>();
        int result = 0;

        for(int i = 0; i < N; i++){
            Long roof = Long.parseLong(br.readLine());
            while(!stack.isEmpty() && stack.peek() <= roof){
                stack.pop();
            }
            stack.push(roof);
            result += stack.size() -1;
        }
        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
    }
}