import java.util.*;

public class Algorithm_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            for(int k = N; k > i; k--){
                System.out.printf("*");
            }
            System.out.println();
        }
        sc.close();
    }
}