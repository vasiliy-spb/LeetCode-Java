package matrix.workingPeoplesImitation.task_2215_Find_the_Difference_of_Two_Arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> expected = List.of(List.of(1, 3), List.of(4, 6));
        assertEquals(expected, testingClass.findDifference(nums1, nums2));
    }

    @Test
    public void checkTestcase2() {
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};
        List<List<Integer>> expected = List.of(List.of(3), new ArrayList<>());
        assertEquals(expected, testingClass.findDifference(nums1, nums2));
    }

}
