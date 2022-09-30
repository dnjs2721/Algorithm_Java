package Stack;

import java.io.*;
import java.util.Stack;

class Height
{
    int height,cnt;

    public Height(int height, int cnt) {
        this.height = height;
        this.cnt = cnt;
    }
}

public class Algorithm_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Height> s = new Stack<>();
        long answer = 0;
        for (int i = 0; i < N; ++i) {
            int cur = Integer.parseInt(br.readLine());
            Height next = new Height(cur, 1);
            while (!s.isEmpty() && s.peek().height <= cur) {
                Height p = s.pop();
                answer += p.cnt;
                if (p.height == cur) next.cnt += p.cnt;
            }

            if (!s.isEmpty()) answer++;
            s.push(next);
        }
        System.out.print(answer);
    }
}