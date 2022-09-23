package Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm_01_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com1 = st.nextToken();
    
            switch(com1){
                case("push"):
                    int com2 = Integer.parseInt(st.nextToken());
                    stack.push(com2);
                    break;
                case("pop"):
                    result.append(!stack.empty() ? stack.pop() : -1).append("\n");
                    break;
                case("size"):
                    result.append(stack.size()).append("\n");
                    break;
                case("empty"):
                    result.append(!stack.empty() ? 0 : 1).append("\n");
                    break;
                case("top"):
                    result.append(!stack.empty() ? stack.peek() : -1).append("\n");
                    break;
            }
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}