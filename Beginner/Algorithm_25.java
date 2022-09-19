package Beginner.code_java;

import java.util.*;

public class Algorithm_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1; i < N+1; i++){
            System.out.println("*".repeat(i)+" ".repeat(2*N-2*i)+"*".repeat(i));
        }
        for(int j = N-1; j > 0; j--){
            System.out.println("*".repeat(j)+" ".repeat(2*N-2*j)+"*".repeat(j));
        }
        sc.close();
    }
}