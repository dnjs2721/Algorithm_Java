package Programmers;

import java.util.*;
public class 모음_사전 {
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
    }
    static String[] arr = new String[]{"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();

    public static int solution(String word) {
        int answer = 0;

        dfs(word, "");

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void dfs(String word, String str) {
        list.add(str);

        if (str.length() == 5) {
            return;
        }

        for (String alphabet : arr) {
            dfs(word, str + alphabet);
        }
    }
}
