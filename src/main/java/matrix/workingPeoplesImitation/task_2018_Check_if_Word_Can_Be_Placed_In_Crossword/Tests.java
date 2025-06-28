package matrix.workingPeoplesImitation.task_2018_Check_if_Word_Can_Be_Placed_In_Crossword;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution3 testingClass = new Solution3();

    @Test
    public void checkTestcase01() {
        char[][] board = {
                {'#', ' ', '#'},
                {' ', ' ', '#'},
                {'#', 'c', ' '}
        };
        String word = "abc";
        assertTrue(testingClass.placeWordInCrossword(board, word));
    }

    @Test
    public void checkTestcase02() {
        char[][] board = {
                {' ', '#', 'a'},
                {' ', '#', 'c'},
                {' ', '#', 'a'}
        };
        String word = "ac";
        assertFalse(testingClass.placeWordInCrossword(board, word));
    }

    @Test
    public void checkTestcase03() {
        char[][] board = {
                {'#', ' ', '#'},
                {' ', ' ', '#'},
                {'#', ' ', 'c'}
        };
        String word = "ca";
        assertTrue(testingClass.placeWordInCrossword(board, word));
    }

    @Test
    public void checkTestcase04() {
        char[][] board = {
                {'#', 'c', '#'},
                {' ', ' ', '#'},
                {'#', ' ', ' '}
        };
        String word = "abc";
        assertTrue(testingClass.placeWordInCrossword(board, word));
    }

    @Test
    public void checkTestcase05() {
        char[][] board = {
                {' '},
                {'#'},
                {'o'},
                {' '},
                {'t'},
                {'m'},
                {'o'},
                {' '},
                {'#'},
                {' '}
        };
        String word = "octmor";
        assertTrue(testingClass.placeWordInCrossword(board, word));
    }

    @Test
    public void checkTestcase06() {
        char[][] board = {
                {' '},
                {'#'},
                {' '},
                {'o'},
                {'m'},
                {'t'},
                {' '},
                {'o'},
                {'#'},
                {' '}
        };
        String word = "octmor";
        assertTrue(testingClass.placeWordInCrossword(board, word));
    }
}
