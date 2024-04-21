package matrix.workingPeoplesImitation.task_419_Battleships_in_a_Board;

public class Solution {

    // my solution
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' && (
                        (i + 1 == board.length || board[i + 1][j] == '.')
                                && (j + 1 == board[i].length || board[i][j + 1] == '.')))
                    count++;
            }
        }
        return count;
    }

    // from walkccc.me
    public int countBattleships2(char[][] board) {
        int ans = 0;

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.')
                    continue;
                if (i > 0 && board[i - 1][j] == 'X')
                    continue;
                if (j > 0 && board[i][j - 1] == 'X')
                    continue;
                ++ans;
            }

        return ans;
    }
}
