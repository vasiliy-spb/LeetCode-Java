package matrix.workingPeoplesImitation.task_79_Word_Search;

import java.util.*;

public class Solution {

    // my solution
    public boolean exist(char[][] board, String word) {
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean foundWord = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) return true;
                    for (int[] direction : directions) {
                        if (i + direction[0] >= 0 && i + direction[0] < board.length && j + direction[1] >= 0 && j + direction[1] < board[0].length && board[i + direction[0]][j + direction[1]] == word.charAt(1) && !visited[i + direction[0]][j + direction[1]]) {
                            boolean[][] currentVisited = new boolean[visited.length][];
                            for (int k = 0; k < visited.length; k++) {
                                currentVisited[k] = Arrays.copyOf(visited[k], visited[k].length);
                            }
                            currentVisited[i][j] = true;
                            currentVisited[i + direction[0]][j + direction[1]] = true;
                            foundWord |= checkWordWithBacktracking(board, word, 1, i + direction[0], j + direction[1], currentVisited);
                        }
                    }
                }
            }
        }
        return foundWord;
    }

    private boolean checkWordWithBacktracking(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
        if (index == word.length() - 1) return true;
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean foundWord = false;
        for (int[] direction : directions) {
            if (x + direction[0] >= 0 && x + direction[0] < board.length && y + direction[1] >= 0 && y + direction[1] < board[0].length && board[x + direction[0]][y + direction[1]] == word.charAt(index + 1) && !visited[x + direction[0]][y + direction[1]]) {
                boolean[][] currentVisited = new boolean[visited.length][];
                for (int i = 0; i < visited.length; i++) {
                    currentVisited[i] = Arrays.copyOf(visited[i], visited[i].length);
                }
                currentVisited[x + direction[0]][y + direction[1]] = true;
                foundWord |= checkWordWithBacktracking(board, word, index + 1, x + direction[0], y + direction[1], currentVisited);
            }
        }
        return foundWord;
    }

    // from walkccc.me
    public boolean exist2(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if (dfs(board, word, i, j, 0))
                    return true;
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int s) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length)
            return false;
        if (board[i][j] != word.charAt(s) || board[i][j] == '*')
            return false;
        if (s == word.length() - 1)
            return true;

        final char cache = board[i][j];
        board[i][j] = '*';
        final boolean isExist = dfs(board, word, i + 1, j, s + 1) || //
                dfs(board, word, i - 1, j, s + 1) || //
                dfs(board, word, i, j + 1, s + 1) || //
                dfs(board, word, i, j - 1, s + 1);
        board[i][j] = cache;

        return isExist;
    }
}
