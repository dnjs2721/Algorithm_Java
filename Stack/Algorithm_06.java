package Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;;

public class Algorithm_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        int result[] = new int[N];

        for(int i = 0; i < N; i++){
            result[i] = -1;
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);
        for(int i = 1; i < N; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        for(int i:result){
            bw.write(String.valueOf(i) + " ");
        }
        bw.flush();
        bw.close();
    }
}
