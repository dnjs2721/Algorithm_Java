package LeetCode;

public class Sol_2778 {

    public static int sumOfSquares(int[] nums) {
        int answer = 0;
        for (int i = 1; i <= nums.length ; i++) {
            if (nums.length % i == 0) {
                answer += nums[i-1] * nums[i-1];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(sumOfSquares(nums));
    }
}
