package Programmers;

public class 혼자서_하는_틱택토 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"O.X", ".O.", "..X"}));
    }

    private static int solution(String[] board) {
        int o = 0, x = 0;

        for (String b : board) {
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == 'O') { // O 의 갯수
                    o++;
                } else if (b.charAt(i) == 'X') { // X의 갯수
                    x++;
                }
            }
        }

        boolean oWin = check(board, 'O'); // O 승리 체크
        boolean xWin = check(board, 'X'); // X 승리 체크

        if (oWin && xWin || o < x) { // O,X 둘 다 승리 했을 경우, O가 X 보다 적을 경우
            return 0; // 잘못된 경우
        } else if (oWin) { // O 만 승리 했을 경우
            if (o - x == 1) { //O와 X의 차이가 1일 경우
                return 1; // 가능한 경우
            } else { // 그 외
                return 0; // 잘못된 경우
            }
        } else if (xWin) { // X만 승리 했을 경우
            if (o == x) { // O 와 X의 수가 같을 경우
                return 1; // 가능한 경우
            } else { // 그 외
                return 0; // 잘못된 경우
            }
        } else { // 둘 다 승리 하지 못했을 경우
            if (o - x > 1) { // O의 수가 X 보다 2개 이상 많을 경우
                return 0; // 잘못된 경우
            }
            return 1; // O가 X 보다 적을 경우, O의 수가 X 보다 2개 이상 많을 경우를 제외한 모든 경우
        }
    }

    public static boolean check(String[] board, char mark) { // 승리하는 모든 경우
        return (board[0].charAt(0) == mark && board[0].charAt(1) == mark && board[0].charAt(2) == mark) || // 가로 첫째줄
                (board[1].charAt(0) == mark && board[1].charAt(1) == mark && board[1].charAt(2) == mark) || // 가로 둘째줄
                (board[2].charAt(0) == mark && board[2].charAt(1) == mark && board[2].charAt(2) == mark) || // 가로 셋째줄
                (board[0].charAt(0) == mark && board[1].charAt(0) == mark && board[2].charAt(0) == mark) || // 세로 첫째줄
                (board[0].charAt(1) == mark && board[1].charAt(1) == mark && board[2].charAt(1) == mark) || // 세로 둘째줄
                (board[0].charAt(2) == mark && board[1].charAt(2) == mark && board[2].charAt(2) == mark) || // 세로 셋째줄
                (board[0].charAt(0) == mark && board[1].charAt(1) == mark && board[2].charAt(2) == mark) || // 대각선 1
                (board[0].charAt(2) == mark && board[1].charAt(1) == mark && board[2].charAt(0) == mark); // 대각선 2
    }
}
