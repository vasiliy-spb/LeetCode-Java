package matrix.workingPeoplesImitation.task_4_Median_of_Two_Sorted_Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
//    private final Solution testingClass = new Solution();
//    private final Solution2 testingClass = new Solution2();
    private final Solution3 testingClass = new Solution3();

    @Test
    public void checkTestcase1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2.00000;
        assertEquals(expected, testingClass.findMedianSortedArrays(nums1, nums2), .0);
    }

    @Test
    public void checkTestcase2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.50000;
        assertEquals(expected, testingClass.findMedianSortedArrays(nums1, nums2), .0);
    }

    @Test
    public void checkTestcase3() {
        int[] nums1 = {2, 3, 5, 7};
        int[] nums2 = {1, 4, 6, 8};
        double expected = 4.50000;
        assertEquals(expected, testingClass.findMedianSortedArrays(nums1, nums2), .0);
    }

//    @Test
//    public void checkTestcase3() {
//        int[] nums1 = {1, 3};
//        int[] nums2 = {2};
//        double expected = 2.00000;
//        assertEquals(expected, testingClass.findMedianSortedArrays(nums1, nums2), .0);
//    }
}
