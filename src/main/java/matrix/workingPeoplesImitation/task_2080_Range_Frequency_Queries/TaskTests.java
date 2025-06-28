package matrix.workingPeoplesImitation.task_2080_Range_Frequency_Queries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {

    @Test
    public void checkTestcase01() {
        int[] nums = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        RangeFreqQuery testingClass = new RangeFreqQuery(nums);
        assertEquals(1, testingClass.query(1, 2, 4));
        assertEquals(2, testingClass.query(0, 11, 33));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        RangeFreqQuery testingClass = new RangeFreqQuery(nums);
        assertEquals(1, testingClass.query(1, 2, 4));
        assertEquals(2, testingClass.query(0, 11, 33));
        assertEquals(1, testingClass.query(2, 5, 4));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {1, 1, 1, 2, 2};
        RangeFreqQuery testingClass = new RangeFreqQuery(nums);
        assertEquals(0, testingClass.query(0, 1, 2));
        assertEquals(3, testingClass.query(0, 2, 1));
        assertEquals(1, testingClass.query(3, 3, 2));
        assertEquals(1, testingClass.query(2, 2, 1));
    }
}
