package Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =  Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();
        for(int i = 1; i <= N; i++){
            int top = Integer.parseInt(st.nextToken());
            while(!stack.empty()){
                if(stack.peek()[1] >= top){
                    bw.write(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) bw.write("0 ");
            stack.push(new int[] {i, top});
        }
        bw.flush();
        bw.close();
    }
}