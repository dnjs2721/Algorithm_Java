package Stack;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;;

public class Algorithm_01_2 {
    public static ArrayList<Integer> stack;
    public static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        stack = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com1 = st.nextToken();

            switch(com1){
                case("push"):
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case("pop"):
                    result.append(pop()).append("\n");
                    break;
                case("size"):
                    result.append(size()).append("\n");
                    break;
                case("empty"):
                    result.append(empty()).append("\n");
                    break;
                case("top"):
                    result.append(top()).append("\n");
                    break;
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static void push(int item){
        stack.add(item);
        size++;
    }

    public static int pop(){
        if(size == 0){
            return -1;
        }else{
            int res = stack.get(size -1);
            stack.remove(size -1);
            size--;
            return res;
        }
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if(size == 0){
            return 1;
        }else return 0;
    }
    
    public static int top(){
        if(size == 0){
            return -1;
        }else return stack.get(size-1);
    }
}