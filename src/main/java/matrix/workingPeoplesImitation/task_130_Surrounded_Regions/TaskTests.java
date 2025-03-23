package matrix.workingPeoplesImitation.task_130_Surrounded_Regions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTests {
    Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        printBoard(board);
        testingClass.solve(board);
        char[][] expected = {{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}};
        printBoard(expected);
        assertTrue(Arrays.deepEquals(board, expected));
    }

    private void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char position : row) {
                System.out.print(position + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Test
    public void checkTestcase02() {
        char[][] board = {{'X'}};
        testingClass.solve(board);
        char[][] expected = {{'X'}};
        assertTrue(Arrays.deepEquals(board, expected));
    }

//    @Test
//    public void checkTestcase03() {
//        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
//        testingClass.solve(board);
//        char[][] expected = {{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}};
//        assertTrue(Arrays.deepEquals(board, expected));
//    }
}
