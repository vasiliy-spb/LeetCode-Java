package matrix.workingPeoplesImitation.task_47_Permutations_II;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = testingClass.permuteUnique(nums);

        assertEquals(3, result.size());
        assertTrue(result.contains(Arrays.asList(1, 1, 2)));
        assertTrue(result.contains(Arrays.asList(1, 2, 1)));
        assertTrue(result.contains(Arrays.asList(2, 1, 1)));
    }

    @Test
    public void checkTestcase2() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = testingClass.permuteUnique(nums);

        assertEquals(6, result.size());
        assertTrue(result.contains(Arrays.asList(1, 2, 3)));
        assertTrue(result.contains(Arrays.asList(1, 3, 2)));
        assertTrue(result.contains(Arrays.asList(2, 1, 3)));
        assertTrue(result.contains(Arrays.asList(2, 3, 1)));
        assertTrue(result.contains(Arrays.asList(3, 1, 2)));
        assertTrue(result.contains(Arrays.asList(3, 2, 1)));
    }
}
