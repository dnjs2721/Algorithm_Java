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

// N = 7
// 2 4 1 2 2 5 1

// 주어진 입력값은 키를 의미하고, 해당 순서로 줄을 서있다고 할 때, 자신보다 키가 큰 사람이 사이에 있다면 반대편과
// 마주볼 수 없다. 위와 같은 조건에서 서로가 마주 볼 수 있는 두 쌍의 총 수를 구하는 문제

// 반복은 입력 순서대로 진행, 만약 새로 들어온 입력값이 스택의 top 보다 크다면,
// top은 더이상 그 뒤에 들어오는 사람들을 마주할 수 없다는 의미이므로 pop으로 거내주며 카운트를 더해준다.
// 만약 키가 같은 경우라면, 카운트값을 누적합 시켜주고, 다시 집어 넣어준다.
// 자신보다 작은 키를 모두 제거한 이후에도 스택에 값이 남이있다면, 스택에 남아있는 값은 자신보다 큰 값을 의미하므로
// 다 꺼낸 상태에서의 top도 마주볼 수 있기 때문에 카운트를 1증가 시켜준다.

// 입력이 2일때 스택이 비어있기 때문에 스택에 (2,1) 을 푸시

// 입력이 4일때 스택의 peek().height = 2  : 2 <= 4 이기 때문에 스택 pop을 통해 스택은 비워지며
// p = (2,1), answer = 0 + 1, 
// 스택이 비워져 있기 때문에 if문 통과
//스택에 (4,1) 을 푸시

// 입력이 1일때 스택의 peek().height = 4  : 조건 부적격
// 스택에 값이 있기 때문에 answer++, answer = 2
// 스택에 (1,1) 푸시

// 입력이 2일때 스택의 peek().height = 1  : 1 <= 2 이기 떄문에 스택 pop을 통해 스택엔 (4,1)만 남으며
// p = (1,1), answer = 2 + 1,
// 다시 한번 while문 조건 검사 : 스택의 peek.height = 4, 입력은 2이기 때문에 조건 부적격
// 스택에 값이 있기 때문에 answer++, answer = 4
// 스택에 (2,1) 을 푸시

// 입력이 2일때 스택의 peek().height = 2  : 2 <= 2 이기 때문에 스택 pop을 통해 스택엔 (4,1)만 남으며
// p = (2,1), answer = 4 + 1, 
// 입력과 peek값이 동일하기 때문에 입력받은 (2,1)의 cnt 값에 p의 cnt값을 더한다  입력받은 값은 (2,2)가 되며, 
// 다시 한번 while문 조건 검사 : 스택의 peek.height = 4, 입력은 2이기 때문에 조건 부적격
// 스택에 값이 있기 때문에 answer++, answer = 6
// 스택에 (2,2) 을 푸시

// 입력이 5일때 스택의 peek().hight = 2 : 2 <= 5 이기 때문에 스택 pop을 통해 스택엔 (4,1)만 남으며
// p = (2,2), answer = 6 + 2,
// 다시 한번 while문 조건 검사 : 입력이 5일때 스택의 peek().height = 4 : 4 <= 5 이기 때문에 스택은 비워지며
// p = (4,1), answer = 8 + 1,
// 스택이 비워져 있기 때문에 if문 통과
// 스택에 (5,1)을 푸시

// 입력이 1일때 스택의 peek().height = 5 : 조건 부적격
// 스택에 값이 있기 때문에 answer++, answer = 10
// 스택에 (1, 1) 푸시

// for 문 종료로 인해 print문 출력