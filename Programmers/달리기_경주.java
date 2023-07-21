package Programmers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class 달리기_경주 {
    public static Collection<String> solution(String[] players, String[] callings) {
        Map<Integer, String> rankMap = new HashMap<>();
        Map<String, Integer> playerMap = new HashMap<>();

        int num = 1;
        for (String player : players) {
            rankMap.put(num, player);
            playerMap.put(player, num);
            num++;
        }

        for (String call : callings) {
            Integer nowRank = playerMap.get(call);
            int beforeRank = nowRank - 1;
            String beforePlayer = rankMap.get(beforeRank);

            playerMap.put(call, beforeRank);
            playerMap.put(beforePlayer, nowRank);

            rankMap.put(beforeRank, call);
            rankMap.put(nowRank, beforePlayer);
        }

        return rankMap.values();
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(solution(players, callings));
    }
}
