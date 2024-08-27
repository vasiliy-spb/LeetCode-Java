package matrix.workingPeoplesImitation.task_179_Largest_Number;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {10,2};
        String expected = "210";
        assertEquals(expected, testingClass.largestNumber(nums));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {3,30,34,5,9};
        String expected = "9534330";
        assertEquals(expected, testingClass.largestNumber(nums));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {3,30,34,5,9,305};
        String expected = "9534330530";
        assertEquals(expected, testingClass.largestNumber(nums));
    }

    @Test
    public void checkTestcase04() {
        int[] nums = {3,30,34,5,9,305};
        String expected = "9534330530";
        assertEquals(expected, testingClass.largestNumber(nums));
    }

    @Test
    public void checkTestcase05() {
        int[] nums = {432,43243};
        String expected = "43243432";
        assertEquals(expected, testingClass.largestNumber(nums));
    }

    @Test
    public void checkTestcase06() {
        int[] nums = {111311, 1113};
        String expected = "1113111311";
        assertEquals(expected, testingClass.largestNumber(nums));
    }

    @Test
    public void checkTestcase07() {
        int[] nums = {0, 0};
        String expected = "0";
        assertEquals(expected, testingClass.largestNumber(nums));
    }

    @Test
    public void checkTestcase08() {
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String expected = "0";
        assertEquals(expected, testingClass.largestNumber(nums));
    }

    @Test
    public void checkTestcase09() {
        int[] nums = {1000000000, 1000000000};
        String expected = "10000000001000000000";
        assertEquals(expected, testingClass.largestNumber(nums));
    }
}
