import java.io.*;

public class Algorithm_26 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());

        for(int i = 0; i < N; i++){
            bw.write(" ".repeat(i)+"*".repeat(2*N-2*i-1)+"\n");
        }
        for(int j = 1; j < N; j++){
            bw.write(" ".repeat(N - j - 1)+"*".repeat(2*j+1)+"\n");
        }
        // bw.flush();
        // bw.close();
    }
}