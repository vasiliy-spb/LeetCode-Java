package matrix.workingPeoplesImitation.task_1926_Nearest_Exit_from_Entrance_in_Maze;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance = {1, 2};
        int expected = 1;
        assertEquals(expected, testingClass.nearestExit(maze, entrance));
    }

    @Test
    public void checkTestcase2() {
        char[][] maze = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        int[] entrance = {1, 0};
        int expected = 2;
        assertEquals(expected, testingClass.nearestExit(maze, entrance));
    }

    @Test
    public void checkTestcase3() {
        char[][] maze = {{'.', '+'}};
        int[] entrance = {0, 0};
        int expected = -1;
        assertEquals(expected, testingClass.nearestExit(maze, entrance));
    }

    @Test
    public void checkTestcase4() { // 4 / 194 testcases passed
        char[][] maze = {{'+', '.'}};
        int[] entrance = {0, 1};
        int expected = -1;
        assertEquals(expected, testingClass.nearestExit(maze, entrance));
    }

}
