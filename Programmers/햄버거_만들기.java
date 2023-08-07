package Programmers;


public class 햄버거_만들기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }

    public static int solution(int[] ingredient) {
        int answer = 0;
        int point = 0;
        int[] stack = new int[ingredient.length];

        for (int i : ingredient) {
            stack[point++] = i;
            if (point >= 4
                    && stack[point - 1] == 1
                    && stack[point - 2] == 3
                    && stack[point - 3] == 2
                    && stack[point - 4] == 1) {
                point -= 4;
                answer++;
            }
        }
        return answer;
    }
}
