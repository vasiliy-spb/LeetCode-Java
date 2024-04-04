package matrix.workingPeoplesImitation.task_79_Word_Search;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        assertTrue(testingClass.exist(board, word));
    }

    @Test
    public void checkTestcase2() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        assertTrue(testingClass.exist(board, word));
    }

    @Test
    public void checkTestcase3() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        assertFalse(testingClass.exist(board, word));
    }

    @Test
    public void checkTestcase4() { // 5 / 87 testcases passed
        char[][] board = {{'A'}};
        String word = "A";
        assertTrue(testingClass.exist(board, word));
    }

    @Test
    public void checkTestcase5() { // 68 / 87 testcases passed
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        assertTrue(testingClass.exist(board, word));
    }

    @Test
    public void checkTestcase6() { // 72 / 87 testcases passed
        char[][] board = {
                {'b', 'b', 'b', 'a', 'b', 'b'},
                {'b', 'a', 'b', 'b', 'a', 'a'},
                {'b', 'a', 'b', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a', 'b', 'a'},
                {'a', 'a', 'b', 'b', 'b', 'a'},
                {'a', 'a', 'b', 'b', 'a', 'a'}};
        String word = "abbbbaabbbbb";
        assertTrue(testingClass.exist(board, word));
    }

    @Test
    public void checkTestcase7() { // 77 / 87 testcases passed
        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}};
        String word = "AAB";
        assertTrue(testingClass.exist(board, word));
    }
}
