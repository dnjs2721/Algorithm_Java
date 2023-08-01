package Programmers;

public class 마법의_엘리베이터 {
    public static void main(String[] args) {
        System.out.println(solution(16));
    }

    public static int solution(int storey) {
        int answer = 0;
        while (storey != 0) {
            int n = storey % 10; // 층수의 첫번째 자리

            // 첫번째 자리가 6 이상이거나,
            // 첫번째 자리가 5일떄 두번째 자리가 5이상일 경우
            if (n >= 6 || (n == 5 && (storey / 10) % 10 >= 5)) {
                storey += 10 - n; // 현재 층수에서 첫번째 자리가 0이 될때까지 올라간다.
                answer += 10 - n; // 올라간 층수 만큼 상승
            // 첫번째 자리가 4 이하이거나
            // 첫번째 자리가 5일때 두번째 자리가 4이하일 경우
            } else {
                storey -= n; // 아래 버리는 연산을 통해 버려지기에 수행하지 않아도 되지만 이해를 위해 수행.
                answer += n; // 첫번째 자리의 수만큼 내려간다.
            }
            // 현재 층수의 첫번째 자리를 버린다.
            storey = storey / 10;
        }

        return answer;
    }
}
