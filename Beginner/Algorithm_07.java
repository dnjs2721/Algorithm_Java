package Beginner.code_java;

import java.util.*;

public class Algorithm_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[3];
        for (int i = 0 ; i < 3 ; i++){
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        // for (int j=0 ; j < 2; j++){
        //     for (int k = j+1 ; k < 3; k++){
        //         if (num[j] > num[k]){
        //             int temp = num[k];
        //             num[k] = num[j];
        //             num[j] = temp;
        //         }
        //     }
        // }  
         
        for (int j = 0 ; j < 3 ; j++){
            System.out.print(num[j]+ " ");
        }
        sc.close();
    }
}