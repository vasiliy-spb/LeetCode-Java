package matrix.workingPeoplesImitation.task_2018_Check_if_Word_Can_Be_Placed_In_Crossword;

// my solution
public class Solution3 {
    public boolean placeWordInCrossword(char[][] board, String word) {
        // left-right
        if (checkWord(board, word)) {
            return true;
        }
        // right-left
        if (checkWord(board, new StringBuffer(word).reverse().toString())) {
            return true;
        }
        char[][] rotatedBoard = rotateBoard(board);
        // top-bottom
        if (checkWord(rotatedBoard, word)) {
            return true;
        }
        // bottom-right
        if (checkWord(rotatedBoard, new StringBuffer(word).reverse().toString())) {
            return true;
        }
        return false;
    }

    private char[][] rotateBoard(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        char[][] rotatedBoard = new char[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedBoard[j][i] = board[i][j];
            }
        }
        return rotatedBoard;
    }

    private static boolean checkWord(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            int wordIndex = 0;
            boolean checkingWord = false;
            for (int j = 0; j < m; j++) {
                char ch = board[i][j];
                boolean canStart = ch == '#' || j == 0;
                if (checkingWord) {
                    if (ch == '#') {
                        if (wordIndex == word.length()) {
                            return true;
                        } else {
                            wordIndex = 0;
                        }
                    } else if (wordIndex >= word.length()) {
                        checkingWord = false;
                    } else if (ch == word.charAt(wordIndex) || ch == ' ') {
                        wordIndex++;
                    } else {
                        wordIndex = -1;
                        checkingWord = false;
                    }
                } else {
                    if (canStart) {
                        wordIndex = 0;
                        checkingWord = true;
                        j--;
                    }
                }
            }
            if (checkingWord && wordIndex == word.length()) {
                return true;
            }
        }
        return false;
    }
}
