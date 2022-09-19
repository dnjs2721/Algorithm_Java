
import java.util.*;

public class Algorithm_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1; i < N+1; i ++){
            for(int k = N; k > i; k-- ){
                System.out.printf(" ");
            }
            for(int j = 0; j < i; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
        sc.close();
    }
}