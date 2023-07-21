package Array;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int left = 0;
        int right = n -1;
        int res = 0;
        while(left < right){
            int tmp = arr[left] + arr[right];
            if(tmp < x){
                left +=1;
            }else if(tmp > x){
                right -= 1;
            }else{
                res += 1;
                left += 1;
                right -= 1;
            }
        }
        System.out.println(res);
    }
}