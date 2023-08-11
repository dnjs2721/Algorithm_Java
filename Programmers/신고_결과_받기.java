package Programmers;

import java.util.*;

public class 신고_결과_받기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> reportName = new HashMap<>();

        for (String r : report) {
            String user = r.split(" ")[0];
            String target = r.split(" ")[1];
            if (reportName.containsKey(target)) {
                reportName.get(target).add(user);
            } else {
                reportName.put(target, new HashSet<>(Collections.singletonList(user)));
            }
        }

        Map<String, Integer> res = new HashMap<>();

        for (String key : reportName.keySet()) {
            Set<String> names = reportName.get(key);
            if (names.size() >= k) {
                for (String name : names) {
                    res.put(name, res.getOrDefault(name, 0) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            if (res.containsKey(id_list[i])) {
                answer[i] = res.get(id_list[i]);
            }
        }

        return answer;
    }
}
