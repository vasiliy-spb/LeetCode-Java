package matrix.workingPeoplesImitation.task_3043_Find_the_Length_of_the_Longest_Common_Prefix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
        int expected = 3;
        assertEquals(expected, testingClass.longestCommonPrefix(arr1, arr2));
    }

    @Test
    public void checkTestcase02() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 4, 4};
        int expected = 0;
        assertEquals(expected, testingClass.longestCommonPrefix(arr1, arr2));
    }

    @Test
    public void checkTestcase03() {
        int[] arr1 = {100};
        int[] arr2 = {2};
        int expected = 0;
        assertEquals(expected, testingClass.longestCommonPrefix(arr1, arr2));
    }
}
