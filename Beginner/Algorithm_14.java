
import java.util.*;

public class Algorithm_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] nums = new long[2];
        for( int i = 0; i < 2; i++){
            nums[i] = sc.nextLong();
        }
        Arrays.sort(nums);
        if(nums[1] == nums[0]){
            System.out.println(0);
        }else{
            System.out.println(nums[1] - nums[0] - 1);
            for( long j = nums[0]+1; j < nums[1]; j++){
                System.out.print(j + " ");
            }
        }
        sc.close();
    }
}