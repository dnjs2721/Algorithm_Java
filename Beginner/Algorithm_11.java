
import java.util.*;

public class Algorithm_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> res = new ArrayList<Integer>();
        int sum = 0;
        for(int i = 0; i < 7; i++){
            int num = sc.nextInt();
            if(num%2 > 0){
                res.add(num);
                sum += num;
            }
        }
        if(res.size() == 0){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(Collections.min(res));
        }
        sc.close();
    }
}