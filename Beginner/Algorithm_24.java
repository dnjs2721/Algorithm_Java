// package Beginner.code_java;

// import java.util.*;

// public class Algorithm_24 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();
//         for(int i = 1; i < N+1; i++){
//             for(int j = N; j > i; j--){
//                 System.out.printf(" ");
//             }
//             for(int k = 0; k < 2*i -1; k++){
//                 System.out.printf("*");
//             }
//             System.out.println();
//         }
//         for(int i = 1; i < N; i++){
//             for(int j = 0; j < i; j++){
//                 System.out.printf(" ");
//             }
//             for(int k = 0 ; k < (2 * N) - (2 * i) - 1; k++ ){
//                 System.out.printf("*");
//             }
//             System.out.println();
//         }
//         sc.close();
//     }
// }

package Beginner.code_java;

import java.util.*;

public class Algorithm_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1; i < N+1; i++){
            System.out.println(" ".repeat(N-i)+"*".repeat(2*i-1));
        }
        for(int i = 1; i < N; i++){
            System.out.println(" ".repeat(i)+"*".repeat(2*N - 2*i -1));
        }
        sc.close();
    }
}