package Programmers;


public class PCCP_기출문제_1번_붕대감기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
        System.out.println(solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health; // 회복가능한 최대 체력
        int maxTime = attacks[attacks.length - 1][0]; // 마자막 공격 시간

        int[] map = new int[maxTime + 1]; // map[i] == i 초에 하는 공격 피해 수치 // hashMap 도 가능
        for (int[] attack : attacks) {
            map[attack[0]] = attack[1];
        }

        int t = bandage[0]; // 붕대감는 시간
        int recovery = bandage[1]; // 초당 회복 시간
        int bonusRecovery = bandage[2]; // 붕대감는 시간 충족시 추가 회복량

        int currentTime = 0; // 붕대 연속 감기 성공 시간
        for (int i = 1; i <= maxTime; i++) { // 1초부터 마지막 공격 시간까지 탐색
            currentTime++; // 붕대 감기 시간 1증가
            if (map[i] != 0) { // map[i] 가 0이 아니라는 뜻은 i초에 공격이 있다는 것 -> 회복 불가능, 피해량 계산
                health -= map[i]; // 현재 체력에서 피해량 계산
                if (health <= 0) return -1; // 현재 체력이 0이하로 떨어지면 사망, 바로 종료
                currentTime = 0; // 공격을 받은 후에는 붕대 연속 감기 성공 시간 0으로 초기화
            } else {
                health += recovery; // map[i]가 0일 때, 공격이 없기에 초당 회복량 계산
                if (currentTime == t) { // 만약 붕대 연속 감기 성공 시간이 붕대감기 시전 속도랑 같아진다면
                    health += bonusRecovery; // 보서스 회복 체력까지 계산
                    currentTime = 0; // 붕대감기에 성공하였기에 붕대 연속 감기 성공 시간 0으로 초기화
                }
                if (health > maxHealth) health = maxHealth; // 현재 체력에 최대 체력 보다 많다면 현재 체력을 최대 체력으로 초기화
            }
        }

        return health; // 모든 공격이 끝난 후 사망하지 않았다면 현재 체력 반환
    }
}

// t 초 동안 붕대를 감으면서 1초마다 x 만큼의 체력을 회복 bandage[0]
// t초의 붕대 감기를 성공한다면 y 만큼의 추가 체력 회복 bandage[1]
// 촤대체력이 존재하며 현재 체력이 최대 체력보다 커지는 것은 불가능 bandage[2]

// 기술을 쓰는 도중 공격을 당하면 기술이 취소, 공격을 당하는 순간에는 체력 회복 불가
// 기술이 취소당하거나, 기술이 끝나면 그 즉시 붕대감기를 사용

// 몬스터의 공격을 받으면 현재 체력이 줄어듬, 0 이하면 캐릭터 죽