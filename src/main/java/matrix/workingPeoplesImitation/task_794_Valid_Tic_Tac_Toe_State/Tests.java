package matrix.workingPeoplesImitation.task_794_Valid_Tic_Tac_Toe_State;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String[] board = {"O  ","   ","   "};
        assertFalse(testingClass.validTicTacToe(board));
    }

    @Test
    public void checkTestcase02() {
        String[] board = {"XOX"," X ","   "};
        assertFalse(testingClass.validTicTacToe(board));
    }

    @Test
    public void checkTestcase03() {
        String[] board = {"XOX","O O","XOX"};
        assertTrue(testingClass.validTicTacToe(board));
    }

    @Test
    public void checkTestcase04() {
        String[] board = {"XXX","OOX","OOX"};
        assertTrue(testingClass.validTicTacToe(board));
    }

    @Test
    public void checkTestcase05() {
        String[] board = {"XXX","   ","OOO"};
        assertFalse(testingClass.validTicTacToe(board));
    }

    @Test
    public void checkTestcase06() {
        String[] board = {
                "XXX",
                "XOO",
                "OO "
        };
        assertFalse(testingClass.validTicTacToe(board));
    }

    @Test
    public void checkTestcase07() {
        String[] board = {
                "OXX",
                "XOX",
                "OXO"
        };
        assertFalse(testingClass.validTicTacToe(board));
    }

    @Test
    public void checkTestcase08() {
        String[] board = {
                "XXX",
                "XO ",
                "OOO"
        };
        assertFalse(testingClass.validTicTacToe(board));
    }
}
