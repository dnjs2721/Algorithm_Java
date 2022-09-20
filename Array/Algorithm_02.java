package Array;

import java.io.*;

public class Algorithm_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int val = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        int[] res = new int[10];
        String str = String.valueOf(val);
        for(int i = 0; i < str.length(); i++){
            res[str.charAt(i) - 48]++; //글자 '0'에 대한 아스키 코드(48)
        }
        for(int j:res){
            bw.write(j + "\n");
        }
        bw.flush();
        bw.close();
    }
}