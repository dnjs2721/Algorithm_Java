package Array;

import java.io.*;
import java.util.StringTokenizer;

public class Algorithm_05 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int v = Integer.parseInt(br.readLine());
        int res = 0;
        for(int j = 0; j < N; j++){
            if(arr[j] == v){
                res += 1;
            }
        }
        System.out.println(res);
    }
}