package Programmers;

import java.util.*;

public class 바탕화면_정리 {

    public static int[] solution(String[] wallpaper) {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    y.add(j);
                    x.add(i);
                }
            }
        }

        Collections.sort(x);
        Collections.sort(y);

        return new int[]{x.get(0), y.get(0),  x.get(x.size()-1) + 1, y.get(x.size()-1) + 1 };
    }

    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        System.out.println(Arrays.toString(solution(wallpaper)));
    }
}
