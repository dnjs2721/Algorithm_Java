package Programmers;

public class PCCP_기출문제_3번_아날로그_시계 {
    public static void main(String[] args) {
        System.out.println(solution(0, 5, 30, 0, 7, 0));
        System.out.println(solution(12, 0, 0, 12, 0, 30));
    }

    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int startTimeSec = (h1 * 60 * 60) + (m1 * 60) + s1; // 시작 시각을 초로 변환
        int endTimeSec = (h2 * 60 * 60) + (m2 * 60) + s2; // 종료 시각을 초로 변환

        int alam = 0;

        double[] prevAngles = calAngle(startTimeSec); // 시작 시각에 대한 시침, 분침, 초침의 각도 계산
        double prevHAngle = prevAngles[0]; // 시침의 각도
        double prevMAngle = prevAngles[1]; // 분침의 각도
        double prevSAngle = prevAngles[2]; // 초침의 각도

        // 시작 시각의 초침과 시침/분침이 겹쳤을 경우 알람이 울린다.
        if (prevSAngle == prevMAngle || prevSAngle == prevHAngle) alam++;

        for (int sec = startTimeSec + 1; sec <= endTimeSec; sec++) { // 시작 시각 + 1초 부터 마지막 시각까지 탐색
            double[] curAngles = calAngle(sec); // 현재 시각에 대한 시침, 분침, 초침의 각도 계산
            double curHAngle = curAngles[0]; // 현재 시침의 각도
            double curMAngle = curAngles[1]; // 현재 분침의 각도
            double curSAngle = curAngles[2]; // 현재 초침의 각도

            // 현재 시각의 초침과 시침/분침이 겹쳤을 경우 알람이 울린다.
            if (curHAngle == curSAngle || curMAngle == curSAngle) {
                alam++; // 알람이 울렸다
                prevHAngle = curHAngle; // 이전 시각을 현재 시각으로 초기화 한다
                prevMAngle = curMAngle; // 이전 시각을 현재 시각으로 초기화 한다
                prevSAngle = curSAngle; // 이전 시각을 현재 시각으로 초기화 한다
                continue; // 시침과 분침이 같을 경우에는 알람이 한번만 울린다.
            }

            // 초침이 시침을 넘어선 경우
            // 이전 시각에 대한 초침이 이신 시각에 대한 시침 뒤에 있다가
            // 현재 시각에 대한 초침이 현재 시각에 대한 시침 앞에 있다면
            // 초침이 시침을 넘어 갔다는 뜻.. 그렇다면 그 사이 ms에 겹쳤던 순간이 있음을 의미한다.
            if ((prevSAngle < prevHAngle) && (curSAngle >= curHAngle)) {
                alam++;
            } else if ((prevSAngle < prevHAngle) && curSAngle == 0) {
                // 이전 시각에 대한 초침이 이신 시각에 대한 시침 뒤에 있다가
                // 현재 시각에 대한 초침이 0이 됐을 때
                // 이는 초침이 시침을 넘어섰지만 0초가 됐을 때를 말한다.
                alam++;
            }

            // 초침이 분침을 넘어선 경우
            // 이전 시각에 대한 초침이 이신 시각에 대한 분침 뒤에 있다가
            // 현재 시각에 대한 초침이 현재 시각에 대한 분침 앞에 있다면
            // 초침이 분침을 넘어 갔다는 뜻.. 그렇다면 그 사이 ms에 겹쳤던 순간이 있음을 의미한다.
            if ((prevSAngle < prevMAngle) && (curSAngle >= curMAngle)) {
                alam++;
            } else if ((prevSAngle < prevMAngle) && curSAngle == 0) {
                // 이전 시각에 대한 초침이 이신 시각에 대한 분침 뒤에 있다가
                // 현재 시각에 대한 초침이 0이 됐을 때
                // 이는 초침이 분침을 넘어섰지만 0초가 됐을 때를 말한다.
                alam++;
            }

            prevHAngle = curHAngle; // 이전 시각을 현재 시각으로 초기화 한다,
            prevMAngle = curMAngle; // 이전 시각을 현재 시각으로 초기화 한다,
            prevSAngle = curSAngle; // 이전 시각을 현재 시각으로 초기화 한다,
        }

        return alam;
    }

    public static double[] calAngle(int sec) {
        // 1시간당 시침이 이동하는 각도는 360 / 12 = 30도
        // 1분당 시침이 이동하는 각도는 30 / 60
        // 1초당 시침이 이동하는 각도는 30 / 60 / 60
        double hourHandSecAngle = 30.0 / 60 / 60;

        // 1분당 분침이 이동하는 각도는 360 / 60 = 6도
        // 1초당 분침이 이동하는 각도는 6 / 60
        double minuteHandSecAngle = 6.0 / 60;

        // 1초당 초침이 이동하는 각도는 360 / 60 = 6도
        double secondHandSecAngle = 6.0;

        // 각 침의 최대 각도는 360도, 360도를 넘는 다면 한바퀴를 넘어간것이기에 360으로 나눈 나머지가 현재 각도가 된다.
        // sec 초에 대한 시침, 분침, 초침 의 각도 정보를 반환한다.
        return new double[]{(sec * hourHandSecAngle) % 360, (sec * minuteHandSecAngle) % 360, sec * secondHandSecAngle % 360};
    }
}


// 시침은 12시간마다, 분침은 60분마다, 초침은 60초마다 시계를 한바퀴 돈다.
// 시침, 분침, 초침의 움직으는 속도는 일정하며 각각 다르다.
// 초침이 시침과 겹칠 때, 초침이 분침과 겹칠 때 알람이 울린다.
// 알람이 울린 횟수를 출력하라

// 각 침이 움직이는 시간은 어떻게 알지