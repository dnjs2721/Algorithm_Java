import java.io.*;

public class Algorithm_27 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tmp = 0;
        int res = 0;
        int num = 0; 
        for(int i =0; i<9; i++){
            num = Integer.parseInt(br.readLine());
            if(num > tmp){
                tmp = num;
                res = i+1;
            }
        }
        bw.write(tmp + "\n" + res);
        bw.flush();
        bw.close();
    }
}