package Programmers;

public class 소수_만들기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
    }
    public static int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int iNum = nums[i];
            for (int j = i + 1; j < n - 1; j++) {
                int jNum = nums[j];
                for (int k = j + 1; k < n; k++) {
                    int num = iNum + jNum + nums[k];
                    boolean flag = true;
                    for(int s = 2; s * s <= num; s++) {
                        if (num % s == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
