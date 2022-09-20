package Array;

import java.io.*;
import java.util.Arrays;

public class Algorithm_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long val = Long.parseLong(br.readLine());
        String str = String.valueOf(val);
        int arr[] = new int[9];
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 57 ){
                arr[6]++;
            }else{
                arr[str.charAt(i) - 48]++;
            }
        }
        if(arr[6] % 2 == 1){
            arr[6] += 1;
        }
        arr[6]/=2;
        Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);
    }
}