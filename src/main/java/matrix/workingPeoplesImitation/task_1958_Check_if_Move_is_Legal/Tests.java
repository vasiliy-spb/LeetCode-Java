package matrix.workingPeoplesImitation.task_1958_Check_if_Move_is_Legal;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        char[][] board = {
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'W', 'B', 'B', '.', 'W', 'W', 'W', 'B'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'}
        };
        int rMove = 4;
        int cMove = 3;
        char color = 'B';
        assertTrue(testingClass.checkMove(board, rMove, cMove, color));
    }

//    @Test
//    public void checkTestcase02() {
//
//    }
//
//    @Test
//    public void checkTestcase03() {
//
//    }
}
