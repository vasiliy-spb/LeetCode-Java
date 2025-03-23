package matrix.workingPeoplesImitation.task_130_Surrounded_Regions;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public void solve(char[][] board) {
        Set<Integer> visited = new HashSet<>();
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i += Math.max(1, n - 1)) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    visited.add(getKey(i, j, m));
                    traverse(board, i, j, visited, m);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j += Math.max(1, m - 1)) {
                if (board[i][j] == 'O') {
                    visited.add(getKey(i, j, m));
                    traverse(board, i, j, visited, m);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    if (!visited.contains(getKey(i, j, m))) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private int getKey(int i, int j, int width) {
        return i * width + j;
    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void traverse(char[][] board, int i, int j, Set<Integer> visited, int width) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        for (int[] direction : DIRECTIONS) {
            int y = i + direction[0];
            int x = j + direction[1];
            if (!isValid(y, x, board)) {
                continue;
            }
            if (board[y][x] == 'O') {
                if (!visited.contains(getKey(y, x, width))) {
                    visited.add(getKey(y, x, width));
                    traverse(board, y, x, visited, width);
                }
            }
        }
    }

    private boolean isValid(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        return true;
    }
}
