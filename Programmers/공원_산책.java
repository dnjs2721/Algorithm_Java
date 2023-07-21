package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 공원_산책 {

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int w = park[0].length();
        int h = park.length;
        int sx = 0;
        int sy = 0;

        boolean forFlag = true;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (park[y].charAt(x) == 'S') {
                    sx = x;
                    sy = y;
                    forFlag = false;
                    break;
                }
            }
            if (!forFlag) {
                break;
            }
        }

        Map<String, Integer> dx = new HashMap<>();
        dx.put("E", 1);
        dx.put("W", -1);
        dx.put("N", 0);
        dx.put("S", 0);
        Map<String, Integer> dy = new HashMap<>();
        dy.put("E", 0);
        dy.put("W", 0);
        dy.put("N", -1);
        dy.put("S", 1);

        for (String route : routes) {
            String[] command = route.split(" ");

            String direction = command[0];
            int num = Integer.parseInt(command[1]);
            boolean flag = true;

            int nx = 0;
            int ny = 0;
            for (int i = 1; i < num + 1; i++) {
                nx = sx + dx.get(direction) * i;
                ny = sy + dy.get(direction) * i;
                if (nx < 0 || nx >= w || ny < 0 || ny >= h || park[ny].charAt(nx) == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sx = nx;
                sy = ny;
            }
        }

        answer[0] = sy;
        answer[1] = sx;

        return answer;
    }

    public static void main(String[] args) {
        String[] park = {"SOO", "OXX", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};
        System.out.println(Arrays.toString(solution(park, routes)));
    }
}
