package matrix.workingPeoplesImitation.task_228_Summary_Ranges;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> expected = List.of("0->2", "4->5", "7");
        assertEquals(expected, testingClass.summaryRanges(nums));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        List<String> expected = List.of("0", "2->4", "6", "8->9");
        assertEquals(expected, testingClass.summaryRanges(nums));
    }
}
