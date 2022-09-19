package Beginner.code_java;

import java.util.*;;

public class Algorithm_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[20];
        for(int j = 0; j < 20; j++){
            arr[j] = j+1;
        }
        for(int i = 0; i < 10; i++){
            // ArrayList<Integer> tmp = new ArrayList<>();
            int A = sc.nextInt();
            int B = sc.nextInt();
            for(int k = A; k < (A + B /2); k++){
                int tmp = arr[k-1];
                arr[k-1] = arr[A + B - k -1];
                arr[A + B - k -1] = tmp;
            }
            // for(int k = A-1; k < B; k++){
            //     tmp.add(arr[k]);
            // }
            // Collections.reverse(tmp);
            // int pointer = 0;
            // for(int l = A-1; l < B; l++){
            //     arr[l] = tmp.get(pointer);
            //     pointer += 1;
            // }
        }
        for(int o = 0; o < 20; o++){
            System.out.print(arr[o] + " ");
        }
        sc.close();
    }
}