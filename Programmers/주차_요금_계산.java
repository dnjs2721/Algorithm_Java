package Programmers;

import java.util.*;

public class 주차_요금_계산 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> outMap = new HashMap<>();

        for (String r : records) {
            String[] detail = r.split(" ");
            String[] timeString = detail[0].split(":");

            int nowTime = Integer.parseInt(timeString[0]) * 60 + Integer.parseInt(timeString[1]);
            String number = detail[1];
            String type = detail[2];

            if (type.equals("IN")) {
                inMap.put(number, nowTime);
            } else {
                int payTime = nowTime - inMap.get(number);
                outMap.put(number, outMap.getOrDefault(number, 0) + payTime);
                inMap.remove(number);
            }
        }

        Set<String> keySet = inMap.keySet();
        for (String number : keySet){
            int payTime = (23 * 60 + 59) - inMap.get(number);
            outMap.put(number, outMap.getOrDefault(number, 0) + payTime);
        }

        ArrayList<String> numbers = new ArrayList<>(outMap.keySet());
        Collections.sort(numbers);

        int n = numbers.size();
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int payTime = outMap.get(numbers.get(i));
            if (payTime <= fees[0]) {
                answer[i] = fees[1];
            } else {
                int payMoney = fees[1] + ((int)Math.ceil((double)(payTime - fees[0]) / fees[2]) * fees[3]);
                answer[i] = payMoney;
            }
        }

        return answer;
    }
}
