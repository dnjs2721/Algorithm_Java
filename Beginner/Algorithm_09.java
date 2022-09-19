import java.util.*;

public class Algorithm_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for(int i =0; i<3; i++){
            arr[i] = sc.nextInt();
        }
        if(arr[0] == arr[1] && arr[1]== arr[2]){
            System.out.println((arr[0]*1000)+10000);
        }else if(arr[0] == arr[1] || arr[0] == arr[2]){
            System.out.println((arr[0]*100)+1000);
        }else if(arr[1] == arr[2]){
            System.out.println((arr[1]*100)+1000);
        }else{
            Arrays.sort(arr);
            System.out.println(arr[2]*100);
        }
        sc.close();
    }
}