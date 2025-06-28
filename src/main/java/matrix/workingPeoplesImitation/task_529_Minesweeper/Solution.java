package matrix.workingPeoplesImitation.task_529_Minesweeper;

public class Solution {

    // my solution
    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }
        int countNearMine = calculateMine(board, i, j);
        if (countNearMine > 0) {
            board[i][j] = (char) ('0' + countNearMine);
            return;
        }
        if (board[i][j] == 'E') {
            board[i][j] = 'B';
            dfs(board, i - 1, j - 1);
            dfs(board, i - 1, j);
            dfs(board, i - 1, j + 1);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
            dfs(board, i + 1, j);
            dfs(board, i + 1, j - 1);
            dfs(board, i + 1, j + 1);
        }
    }

    private int calculateMine(char[][] board, int i, int j) {
        int count = 0;
        if (i - 1 >= 0 && board[i - 1][j] == 'M') {
            count++;
        }
        if (i + 1 < board.length && board[i + 1][j] == 'M') {
            count++;
        }
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 'M') {
            count++;
        }
        if (i + 1 < board.length && j + 1 < board[i].length && board[i + 1][j + 1] == 'M') {
            count++;
        }
        if (i + 1 < board.length && j - 1 >= 0 && board[i + 1][j - 1] == 'M') {
            count++;
        }
        if (i - 1 >= 0 && j + 1 < board[i].length && board[i - 1][j + 1] == 'M') {
            count++;
        }
        if (j - 1 >= 0 && board[i][j - 1] == 'M') {
            count++;
        }
        if (j + 1 < board[i].length && board[i][j + 1] == 'M') {
            count++;
        }
        return count;
    }

    // my solution 2
    private final int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public char[][] updateBoard2(char[][] board, int[] click) {
        dfs2(board, click[0], click[1]);
        return board;
    }

    private void dfs2(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }
        int countNearMine = calculateMine2(board, i, j);
        if (countNearMine > 0) {
            board[i][j] = (char) ('0' + countNearMine);
            return;
        }
        if (board[i][j] == 'E') {
            board[i][j] = 'B';
            for (int[] direction : directions)
                dfs2(board, i + direction[0], j + direction[1]);
        }
    }

    private int calculateMine2(char[][] board, int i, int j) {
        int count = 0;
        for (int[] direction : directions) {
            int a = i + direction[0];
            int b = j + direction[1];
            if (a < 0 || a >= board.length || b < 0 || b >= board[0].length || board[a][b] != 'M') {
                continue;
            }
            count++;
        }
        return count;
    }

    // from walkccc.me
    public char[][] updateBoard3(char[][] board, int[] click) {
        final int i = click[0];
        final int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }

        dfs3(board, i, j);
        return board;
    }

    private static final int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1},
            {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private void dfs3(char[][] board, int i, int j) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length)
            return;
        if (board[i][j] != 'E')
            return;

        final int minesCount = getMinesCount(board, i, j);
        board[i][j] = minesCount == 0 ? 'B' : (char) ('0' + minesCount);

        if (minesCount == 0)
            for (int[] dir : dirs)
                dfs3(board, i + dir[0], j + dir[1]);
    }

    private int getMinesCount(char[][] board, int i, int j) {
        int minesCount = 0;
        for (final int[] dir : dirs) {
            final int x = i + dir[0];
            final int y = j + dir[1];
            if (x < 0 || x == board.length || y < 0 || y == board[0].length)
                continue;
            if (board[x][y] == 'M')
                ++minesCount;
        }
        return minesCount;
    }
}
