package matrix.workingPeoplesImitation.task_1992_Find_All_Groups_of_Farmland;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[][] land = {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}};
        int[][] expected = {{0, 0, 0, 0}, {1, 1, 2, 2}};
        int[][] result = testingClass.findFarmland(land);
        Arrays.stream(result).map(Arrays::toString).forEach(System.out::println);
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkTestcase2() {
        int[][] land = {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}};
        int[][] expected = {{0, 0, 0, 0}, {1, 1, 2, 2}};
        int[][] result = testingClass.findFarmland(land);
        Arrays.stream(result).map(Arrays::toString).forEach(System.out::println);
        assertArrayEquals(expected, result);
    }

    @Test
    public void checkTestcase3() {
        int[][] land = {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}};
        int[][] expected = {{0, 0, 0, 0}, {1, 1, 2, 2}};
        int[][] result = testingClass.findFarmland(land);
        Arrays.stream(result).map(Arrays::toString).forEach(System.out::println);
        assertArrayEquals(expected, result);
    }
}
