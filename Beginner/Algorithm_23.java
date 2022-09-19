
import java.util.*;

public class Algorithm_23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                System.out.printf(" ");
            }
            for(int k = (2 * N) - (2 * i) - 1 ; k > 0; k--){
                System.out.printf("*");
            }
            System.out.println();
        }
        sc.close();
    }
}