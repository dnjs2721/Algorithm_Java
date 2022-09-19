import java.util.*;

public class Algorithm_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        int sum = 0;
        for(int i =
         0; i < 5; i++){
            int num = sc.nextInt();
            nums.add(num);
            sum += num;
        }
        Collections.sort(nums);
        System.out.println(sum/nums.size());
        System.out.println(nums.get(2));
        sc.close();
    }
}