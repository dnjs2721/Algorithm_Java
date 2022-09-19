package Beginner.code_java;

import java.util.*;

public class Algorithm_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] time = new int[N];
        int Y = 0;
        int M = 0;
        for(int i = 0; i < N; i++){
            time[i] = sc.nextInt();
            Y += (time[i]/30 + 1) * 10;
            M += (time[i]/60 + 1) * 15;
        }
        if(Y < M){
            System.out.print("Y" + " " + Y);
        }else if(M < Y){
            System.out.print("M" + " " + M);
        }else{
            System.out.print("Y M" + " " + Y);
        }
        sc.close();
    }
}