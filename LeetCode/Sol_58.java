package LeetCode;

public class Sol_58 {
    public static int lengthOfLastWord(String s) {
//        String[] newS = s.split("\\s");
//        return newS[newS.length - 1].length();
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (cnt > 0) {
                    return cnt;
                }
                continue;
            }
            cnt += 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }
}
