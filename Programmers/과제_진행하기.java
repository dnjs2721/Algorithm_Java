package Programmers;

import java.util.*;
public class 과제_진행하기 {

    public static String[] solution(String[][] plans) {
        int n = plans.length;

        Arrays.sort(plans, Comparator.comparing((String[] o) -> o[1]));

        String[] answer = new String[n];

        Map<String, Integer> leftTimeMap = new HashMap<>();
        Map<String, Integer> subject = new HashMap<>();

        List<String> stack = new ArrayList<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] afterPlan = plans[i];
            String afterName = afterPlan[0];
            int afterTime = Integer.parseInt(afterPlan[1].substring(0, 2)) * 60 + Integer.parseInt(afterPlan[1].substring(3));
            int afterSpend = Integer.parseInt(afterPlan[2]);

            if (!stack.isEmpty()) {
                String beforeName = stack.get(stack.size() - 1);
                stack.remove(beforeName);

                int beforeTime = subject.get(beforeName);
                int beforeSpend = leftTimeMap.get(beforeName);

                if (beforeTime + beforeSpend <= afterTime) {
                    res.add(beforeName);

                    int leftTime = afterTime - (beforeTime + beforeSpend);

                    while (leftTime > 0 && !stack.isEmpty()) {
                        String stackName = stack.get(stack.size() - 1);
                        stack.remove(stackName);

                        Integer stackSpend = leftTimeMap.get(stackName);

                        if (stackSpend <= leftTime) {
                            res.add(stackName);
                            leftTime -= stackSpend;
                        } else {
                            stack.add(stackName);
                            subject.put(stackName, afterTime);
                            leftTimeMap.put(stackName, stackSpend - leftTime);
                            leftTime = 0;
                        }
                    }

                } else {
                    stack.add(beforeName);
                    subject.put(beforeName, afterTime);
                    leftTimeMap.put(beforeName, beforeSpend - (afterTime - beforeTime));
                }
            }
            stack.add(afterName);
            subject.put(afterName, afterTime);
            leftTimeMap.put(afterName, afterSpend);
        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            res.add(stack.get(i));
        }
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        System.out.println(Arrays.toString(solution(plans)));
    }
}
