package Programmers;

public class 크기가_작은_부분문자열 {
    public static void main(String[] args) {
        System.out.println(solution("500220839878", "7"));
    }

    public static int solution(String t, String p) {
        int answer = 0;
        long target = Long.parseLong(p);
        int targetLength = p.length();

        for (int i = 0; i <= t.length() - targetLength; i++) {
            long substring = Long.parseLong(t.substring(i, targetLength + i));
            if (substring <= target) {
                answer++;
            }
        }

        return answer;
    }
}
