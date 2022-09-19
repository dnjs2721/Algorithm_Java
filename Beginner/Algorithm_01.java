package Beginner.code_java;

import java.util.Scanner;

public class Algorithm_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n2 = sc.nextInt();
        int[] arrays = new int[n];
        for(int i = 0; i <= (n-1); i++){
            arrays[i] = sc.nextInt();
            if(arrays[i] < n2) {
                System.out.print(arrays[i] + " ");
            }
        }
        sc.close();
    }
}