package Beginner.code_java;

import java.util.*;

public class Algorithm_21 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                System.out.printf(" ");
            }
            for(int k = N; k > i; k--){
                System.out.printf("*");
            }
            System.out.println();
        }
        sc.close();
    }
}