package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소_짝꿍 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{100, 180, 360, 100, 270}));
    }

    public static long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> info = new HashMap<>();

        /**
         * x : y = a : b
         * 180 : 360 = 2 : 4
         * 2 * 360 = 4 * 180
         * 180 = (360 * 2) / 4
         */
        // 1:1, 2:3, 2:4, 3:4
        for (int weight : weights) {
            double oneAndOne = weight * 1.0; // 1 : 1
            double twoAndThree = (weight * 2.0) / 3.0; // 2 : 3
            double twoAndFour = (weight * 2.0) / 4.0; // 2 : 4
            double threeAndFour = (weight * 3.0) / 4.0; // 3 : 4
            if (info.containsKey(oneAndOne)) answer += info.get(oneAndOne);
            if (info.containsKey(twoAndThree)) answer += info.get(twoAndThree);
            if (info.containsKey(twoAndFour)) answer += info.get(twoAndFour);
            if (info.containsKey(threeAndFour)) answer += info.get(threeAndFour);

            info.put(weight * 1.0, info.getOrDefault(weight * 1.0, 0) + 1);
        }
        return answer;
    }
}
