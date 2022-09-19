package Beginner.code_java;

import java.util.*;

public class Algorithm_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        int target1 = 0;
        int target2 = 0;
        
        // 값을 입력 받아 ArrayList에 추가, 합을 계산
        for(int i = 0; i < 9; i++){
            int num = sc.nextInt();
            arr.add(num);
            sum += num;
        }

        // 2중 for문을 통해 합에서 두 수를 뺀 값이 100이 되는 두 수를 찾는다
        for(int j = 0; j < 9; j++){
            for(int k = j+1; k < 9; k++){
                if(sum - arr.get(j) - arr.get(k) == 100){
                    target1 = arr.get(j);
                    target2 = arr.get(k);
                }
            }
        }

        // 찾은 두 수를 ArrayList에서 제거 후 오름차순으로 정렬
        arr.remove(Integer.valueOf(target1));
        arr.remove(Integer.valueOf(target2));
        Collections.sort(arr);
        for(int l : arr){
            System.out.println(l);
        }

        sc.close();
    }
}