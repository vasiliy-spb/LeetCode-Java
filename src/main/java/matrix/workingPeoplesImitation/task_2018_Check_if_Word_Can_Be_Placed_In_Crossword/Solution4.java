package matrix.workingPeoplesImitation.task_2018_Check_if_Word_Can_Be_Placed_In_Crossword;

// from leetcode code sample
public class Solution4 {
    String word;
    int rows, cols;
    char[][] board;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public boolean placeWordInCrossword(char[][] board, String word) {
        this.word = word;
        rows = board.length;
        cols = board[0].length;
        this.board = board;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] != '#' && isPossible(i, j)) return true;

        return false;
    }

    private boolean isPossible(int x, int y) {
        if (board[x][y] != ' ' && board[x][y] != word.charAt(0)) return false;

        for (int[] d : dirs) {
            int row = x - d[0], col = y - d[1];
            if (isValid(row, col) && isPossible(x, y, d)) return true;
        }

        return false;
    }

    private boolean isPossible(int x, int y, int[] dir) {
        int i = 0;
        while ((i < word.length() && isRange(x, y)) && (board[x][y] == ' ' || board[x][y] == word.charAt(i))) {
            i++;
            x += dir[0];
            y += dir[1];
        }
        if (i < word.length()) return false;
        return isValid(x, y);
    }

    private boolean isValid(int x, int y) {
        if (isRange(x, y)) {
            return board[x][y] == '#';
        }

        return true;
    }

    private boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }
}
