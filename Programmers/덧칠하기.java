package Programmers;

public class 덧칠하기 {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, new int[]{2,3,6}));
    }

    private static int solution(int n, int m, int[] sections) {
        int count = 0;
        int beforeSection = 0;
        for (int section : sections) {
            if (count == 0 || section > beforeSection) {
                count++;
                beforeSection = section + m - 1;
            }
        }
        return count;
    }
}
