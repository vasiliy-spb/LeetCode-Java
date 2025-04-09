package matrix.workingPeoplesImitation.task_2233_Maximum_Product_After_K_Increments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {0, 4};
        int k = 5;
        int expected = 20;
        assertEquals(expected, testingClass.maximumProduct(nums, k));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {6, 3, 3, 2};
        int k = 2;
        int expected = 216;
        assertEquals(expected, testingClass.maximumProduct(nums, k));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {24, 5, 64, 53, 26, 38};
        int k = 54;
        int expected = 180820950;
        assertEquals(expected, testingClass.maximumProduct(nums, k));
    }
}
