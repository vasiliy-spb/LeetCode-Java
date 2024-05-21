package matrix.workingPeoplesImitation.task_78_Subsets;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = List.of(List.of(), List.of(1), List.of(2), List.of(1, 2), List.of(3), List.of(1, 3), List.of(2, 3), List.of(1, 2, 3));
        assertEquals(expected, testingClass.subsets(nums));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {0};
        List<List<Integer>> expected = List.of(List.of(), List.of(0));
        assertEquals(expected, testingClass.subsets(nums));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {1, 9, 8, 3, -1, 0};
        List<List<Integer>> expected = List.of();
        assertEquals(expected, testingClass.subsets(nums));
    }

    @Test
    public void checkTestcase04() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 10, 0};
        List<List<Integer>> expected = List.of();
        assertEquals(expected, testingClass.subsets(nums));
    }
}
