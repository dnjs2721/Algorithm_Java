package Array;

import java.io.*;
import java.util.StringTokenizer;

public class Algorithm_06 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int arr[] = new int[12];
        int res = 0;
        for(int i =0; i < total; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            if(s == 1){
                arr[y+5] += 1;
            }else{
                arr[y-1] += 1;
            }
        }
        for(int j = 0; j < arr.length; j++){
            int tmp = arr[j];
            if(tmp % max > 0){
                res += tmp/max + 1;
            }else{
                res += tmp/max;
            }
        } 
        System.out.println(res);
    }
}