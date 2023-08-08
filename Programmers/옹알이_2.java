package Programmers;

public class 옹알이_2 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"aya", "yayae", "u", "maa"}));
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        String[] possible = {"aya", "ye", "woo", "ma"};

        for(String b : babbling){
            for (String p : possible) {
                if (b.contains(p + p)){
                    break;
                }
                b = b.replace(p, " ");
            }
            b = b.replace(" ", "");
            if (b.length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}
