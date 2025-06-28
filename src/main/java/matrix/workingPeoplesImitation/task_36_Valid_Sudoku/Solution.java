package matrix.workingPeoplesImitation.task_36_Valid_Sudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // my solution 2
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> columnMap = new HashMap<>();
        Map<Integer, Set<Integer>> squareMap = new HashMap<>();
        int square = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int num = board[i][j];
                if (!Character.isDigit(num)) continue;
                square = 3 * (i / 3) + (j / 3);
                if (columnMap.getOrDefault(j, new HashSet<>()).contains(num)
                        || rowMap.getOrDefault(i, new HashSet<>()).contains(num)
                        || squareMap.getOrDefault(square, new HashSet<>()).contains(num))
                    return false;
                columnMap.computeIfAbsent(j, set -> new HashSet<>()).add(num);
                rowMap.computeIfAbsent(i, set -> new HashSet<>()).add(num);
                squareMap.computeIfAbsent(square, set -> new HashSet<>()).add(num);
            }
        }
        return true;
    }

    // my solution
    public boolean isValidSudoku0(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> columnMap = new HashMap<>();
        Map<Integer, Set<Integer>> squareMap = new HashMap<>();
        int square = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int num = board[i][j];
                if (!Character.isDigit(num)) continue;
                if (i < 9) {
                    if (j < 9) square = 9;
                    if (j < 6) square = 8;
                    if (j < 3) square = 7;
                }
                if (i < 6) {
                    if (j < 9) square = 6;
                    if (j < 6) square = 5;
                    if (j < 3) square = 4;
                }
                if (i < 3) {
                    if (j < 9) square = 3;
                    if (j < 6) square = 2;
                    if (j < 3) square = 1;
                }
                if (columnMap.getOrDefault(j, new HashSet<>()).contains(num)
                        || rowMap.getOrDefault(i, new HashSet<>()).contains(num)
                        || squareMap.getOrDefault(square, new HashSet<>()).contains(num))
                    return false;
                columnMap.computeIfAbsent(j, set -> new HashSet<>()).add(num);
                rowMap.computeIfAbsent(i, set -> new HashSet<>()).add(num);
                squareMap.computeIfAbsent(square, set -> new HashSet<>()).add(num);
            }
        }
        return true;
    }

    // from leetcode solutions (https://leetcode.com/problems/valid-sudoku/solutions/15472/short-simple-java-using-strings/)
    // Collect the set of things we see, encoded as strings. For example:
    //
    //    '4' in row 7 is encoded as "(4)7".
    //    '4' in column 7 is encoded as "7(4)".
    //    '4' in the top-right block is encoded as "0(4)2".
    //
    // Scream false if we ever fail to add something because it was already added (i.e., seen before).
    public boolean isValidSudoku2_1(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }
    // Edit: Just occurred to me that we can also make it really clear and self-explaining. I'm loving it.
    public boolean isValidSudoku2_2(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }

    // from walkccc.me
    public boolean isValidSudoku3(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.')
                    continue;
                final char c = board[i][j];
                if (!seen.add(c + "@row" + i) || //
                        !seen.add(c + "@col" + j) || //
                        !seen.add(c + "@box" + i / 3 + j / 3))
                    return false;
            }

        return true;
    }

}
