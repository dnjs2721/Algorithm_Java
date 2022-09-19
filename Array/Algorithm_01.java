package Array;

import java.io.*;

public class Algorithm_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int res[] = new int[26];
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            res[ch - 'a']++;
        }
        for(int j = 0; j < 26; j++){
            bw.write(res[j]+" ");
        }
        bw.flush();
        bw.close();
    }
}
