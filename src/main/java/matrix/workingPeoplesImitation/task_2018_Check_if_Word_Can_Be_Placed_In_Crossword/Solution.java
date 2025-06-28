package matrix.workingPeoplesImitation.task_2018_Check_if_Word_Can_Be_Placed_In_Crossword;

// my solution
public class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        // left-right
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

        // right-left
        for (int i = 0; i < n; i++) {
            int wordIndex = 0;
            boolean checkingWord = false;
            for (int j = m - 1; j >= 0; j--) {
                char ch = board[i][j];
                boolean canStart = ch == '#' || j == m - 1;
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
                        j++;
                    }
                }
            }
            if (checkingWord && wordIndex == word.length()) {
                return true;
            }
        }

        // top-bottom
        for (int j = 0; j < m; j++) {
            int wordIndex = 0;
            boolean checkingWord = false;
            for (int i = 0; i < n; i++) {
                char ch = board[i][j];
                boolean canStart = ch == '#' || i == 0;
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
                        i--;
                    }
                }
            }
            if (checkingWord && wordIndex == word.length()) {
                return true;
            }
        }

        // bottom-top
        for (int j = 0; j < m; j++) {
            int wordIndex = 0;
            boolean checkingWord = false;
            for (int i = n - 1; i >= 0; i--) {
                char ch = board[i][j];
                boolean canStart = ch == '#' || i == n - 1;
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
                        i++;
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
