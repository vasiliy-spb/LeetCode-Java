package matrix.workingPeoplesImitation.task_289_Game_of_Life;

public class Solution {

    // my solution
    public void gameOfLife(int[][] board) {
        int[][] nextState = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = calculateNeighbors(board, i, j);
                if (board[i][j] == 1 && count == 2) nextState[i][j] = 1;
                if (count == 3) nextState[i][j] = 1;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] =  nextState[i][j];
            }
        }
    }

    private int calculateNeighbors(int[][] board, int i, int j) {
        int count = 0;
        if (i > 0) count += board[i - 1][j];
        if (i < board.length - 1) count += board[i + 1][j];
        if (j > 0) count += board[i][j - 1];
        if (j < board[0].length - 1) count += board[i][j + 1];
        if (i > 0 && j > 0) count += board[i - 1][j - 1];
        if (i > 0 && j < board[0].length - 1) count += board[i - 1][j + 1];
        if (i < board.length - 1 && j > 0) count += board[i + 1][j - 1];
        if (i < board.length - 1 && j < board[0].length - 1) count += board[i + 1][j + 1];
        return count;
    }

    // from walkccc.me
    public void gameOfLife2(int[][] board) {
        final int m = board.length;
        final int n = board[0].length;

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                int ones = 0;
                for (int x = Math.max(0, i - 1); x < Math.min(m, i + 2); ++x)
                    for (int y = Math.max(0, j - 1); y < Math.min(n, j + 2); ++y)
                        ones += board[x][y] & 1;
                // Any live cell with two or three live neighbors lives on to the next
                // generation.
                if (board[i][j] == 1 && (ones == 3 || ones == 4))
                    board[i][j] |= 0b10;
                // Any dead cell with exactly three live neighbors becomes a live cell,
                // as if by reproduction.
                if (board[i][j] == 0 && ones == 3)
                    board[i][j] |= 0b10;
            }

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                board[i][j] >>= 1;
    }

}
