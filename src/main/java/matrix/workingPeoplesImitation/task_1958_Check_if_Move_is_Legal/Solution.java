package matrix.workingPeoplesImitation.task_1958_Check_if_Move_is_Legal;

// my solution
public class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] dir : dirs) {
            int y = rMove + dir[0];
            int x = cMove + dir[1];
            int length = 2;
            while (x >= 0 && y >= 0 && x < 8 && y < 8) {
                if (board[y][x] == '.') {
                    break;
                }
                if (board[y][x] == color) {
                    if (length >= 3) {
                        return true;
                    } else {
                        break;
                    }
                }
                y += dir[0];
                x += dir[1];
                length++;
            }
        }
        return false;
    }
}
