package Programmers;

import java.util.ArrayList;

public class 문자열_나누기 {
    public static void main(String[] args) {
        System.out.println(solution("aaabbaccccabbb"));
    }

    public static int solution(String s) {
        ArrayList<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count1 = 0;
        int count2 = 0;
        char c = 0;

        for (int i = 0; i < s.length() ; i++) {
            if (sb.length() == 0) {
                c = s.charAt(i);
                sb.append(c);
                count1 = 1;
                count2 = 0;
                continue;
            }
            if (s.charAt(i) == c) {
                count1++;
                sb.append(c);
            } else {
                count2++;
                sb.append(s.charAt(i));
                if (count1 == count2) {
                    answer.add(String.valueOf(sb));
                    sb = new StringBuilder();
                }
            }
        }
        if (sb.length() != 0) {
            answer.add(String.valueOf(sb));
        }
        return answer.size();
    }
}
