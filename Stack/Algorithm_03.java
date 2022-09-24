package Stack;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Algorithm_03 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 1;
        boolean flag = false;
        int n =  Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        Stack<Integer> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i:arr){
            while(count <= i){
                stack.push(count);
                result.add("+");
                count++;
            }
            if(stack.peek() == i){
                stack.pop();
                result.add("-");
            }else{
                flag = true;
                break;
            }
        }
        if(flag) bw.write("NO");
        else{
            for(String i : result){
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}

