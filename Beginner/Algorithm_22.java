
import java.util.*;

public class Algorithm_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1; i < N+1; i++){
            for(int j = N; j > i; j-- ){
                System.out.printf(" ");
            }
            for(int k = 0; k < 2 * i - 1; k++){
                System.out.printf("*");
            }
            System.out.println();
        }
        sc.close();
    }
}