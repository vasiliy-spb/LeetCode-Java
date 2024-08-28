package matrix.workingPeoplesImitation.task_2405_Optimal_Partition_of_String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "abacaba";
        int expected = 4;
        assertEquals(expected, testingClass.partitionString(s));
    }

    @Test
    public void checkTestcase02() {
        String s = "ssssss";
        int expected = 6;
        assertEquals(expected, testingClass.partitionString(s));
    }

    @Test
    public void checkTestcase03() {
        String s = "hdklqkcssgxlvehva";
        int expected = 4;
        assertEquals(expected, testingClass.partitionString(s));
    }
}
