package Programmers;

public class 푸드_파이트_대회 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 7, 1, 2}));
    }

    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }
        String answer = sb + "0";

        return answer + sb.reverse();
    }
}
