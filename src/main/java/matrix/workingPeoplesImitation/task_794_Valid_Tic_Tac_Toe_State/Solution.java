package matrix.workingPeoplesImitation.task_794_Valid_Tic_Tac_Toe_State;

public class Solution {
    public boolean validTicTacToe(String[] board) {
        int countX = 0;
        int countO = 0;
        char[][] game = new char[3][3];
        for (int r = 0; r < 3; r++) {
            String row = board[r];
            game[r] = row.toCharArray();
            for (int i = 0; i < 3; i++) {
                char ch = row.charAt(i);
                if (ch == 'X') {
                    countX++;
                }
                if (ch == 'O') {
                    countO++;
                }
            }
        }
        if (countO > countX || countX - countO > 1) {
            return false;
        }

        int countVictoryRowsX = calculateCountVictoryRows(game, 'X');
        if (countVictoryRowsX > 1) {
            return false;
        }
        int countVictoryColsX = calculateCountVictoryCols(game, 'X');
        if (countVictoryColsX > 1) {
            return false;
        }
        int countVictoryDiagonalsX = calculateCountVictoryDiagonals(game, 'X');
        if (countVictoryRowsX + countVictoryColsX + countVictoryDiagonalsX > 2) {
            return false;
        }
        if (countVictoryRowsX + countVictoryColsX + countVictoryDiagonalsX > 0 && countO >= countX) {
            return false;
        }
        int countVictoryRowsO = calculateCountVictoryRows(game, 'O');
        if (countVictoryRowsO > 1) {
            return false;
        }
        int countVictoryColsO = calculateCountVictoryCols(game, 'O');
        if (countVictoryColsO > 1) {
            return false;
        }
        int countVictoryDiagonalsO = calculateCountVictoryDiagonals(game, 'O');
        if (countVictoryRowsO + countVictoryColsO + countVictoryDiagonalsO > 2) {
            return false;
        }
        if (countVictoryRowsO + countVictoryColsO + countVictoryDiagonalsO > 0 && countX > countO) {
            return false;
        }
        if (countVictoryRowsX + countVictoryColsX + countVictoryDiagonalsX > 0 && countVictoryRowsO + countVictoryColsO + countVictoryDiagonalsO > 0) {
            return false;
        }
        return true;
    }
    private int calculateCountVictoryRows(char[][] board, char ch) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            boolean similar = true;
            for (int j = 0; j < 3; j++) {
                similar &= ch == board[i][j];
            }
            count += similar ? 1 : 0;
        }
        return count;
    }
    private int calculateCountVictoryCols(char[][] board, char ch) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            boolean similar = true;
            for (int j = 0; j < 3; j++) {
                similar &= ch == board[j][i];
            }
            count += similar ? 1 : 0;
        }
        return count;
    }
    private int calculateCountVictoryDiagonals(char[][] board, char ch) {
        int count = 0;
        if (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) {
            count++;
        }
        if (board[2][0] == ch && board[1][1] == ch && board[0][2] == ch) {
            count++;
        }
        return count;
    }
}
