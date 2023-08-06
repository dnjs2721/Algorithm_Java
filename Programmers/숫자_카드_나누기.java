package Programmers;

public class 숫자_카드_나누기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 17}, new int[]{5, 20}));
        System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int size = arrayA.length;
        int aGcd = arrayA[0];
        int bGcd = arrayB[0];

        for (int i = 1; i < size; i++) {
            aGcd = getGcd(aGcd, arrayA[i]);
            bGcd = getGcd(bGcd, arrayB[i]);
        }

        if (check(arrayA, bGcd)  && check(arrayB, aGcd)) {
            return 0;
        }
        return Math.max(aGcd, bGcd);
    }

    private static boolean check(int[] array, int gcd) {
        for (int n : array) {
            if (n % gcd == 0) {
                return true;
            }
        }
        return false;
    }

    public static int getGcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return getGcd(num2, num1 % num2);
    }
}
