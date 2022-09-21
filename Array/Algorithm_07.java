package Array;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String res[] = new String[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] A = st.nextToken().toCharArray();
            char[] B = st.nextToken().toCharArray();
            Arrays.sort(A);
            Arrays.sort(B);

            if(Arrays.equals(A, B)){
                res[i] = "Possible";
            }else{
                res[i] = "Impossible";
            }
        }
        for(String j : res){
            System.out.println(j);
        }
    }
}