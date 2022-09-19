package Beginner.code_java;

import java.util.*;

public class Algorithm_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];

        for(int i = 0; i < 3; i++){
            int tmp = 0;
            for(int j = 0; j < 4; j++){
                arr[j] = sc.nextInt();
            }
            for(int k = 0; k < 4; k++){
                if(arr[k] == 1){
                    tmp += 1;
                }
            }
            if(tmp == 4){
                System.out.println("E");
            }else if(tmp == 3){
                System.out.println("A");
            }else if(tmp == 2){
                System.out.println("B");
            }else if(tmp == 1){
                System.out.println("C");
            }else if(tmp == 0){
                System.out.println("D");
            }
        }
        sc.close();
    }
}
