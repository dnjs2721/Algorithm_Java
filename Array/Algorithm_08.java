package Array;

import java.io.*;

public class Algorithm_08 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[] arr = new int[26];
        int res = 0;

        for(int i = 0; i < str1.length(); i++){
            arr[str1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < str2.length(); i++){
            arr[str2.charAt(i) - 'a']--;
        }
        for(int j: arr){
            res += Math.abs(j);
        }
        System.out.println(res);
    }
}