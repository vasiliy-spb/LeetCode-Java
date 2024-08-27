package matrix.workingPeoplesImitation.task_2391_Minimum_Amount_of_Time_to_Collect_Garbage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String[] garbage = {"G", "P", "GP", "GG"};
        int[] travel = {2, 4, 3};
        int expected = 21;
        assertEquals(expected, testingClass.garbageCollection(garbage, travel));
    }

    @Test
    public void checkTestcase02() {
        String[] garbage = {"MMM", "PGM", "GP"};
        int[] travel = {3, 10};
        int expected = 37;
        assertEquals(expected, testingClass.garbageCollection(garbage, travel));
    }

//    @Test
//    public void checkTestcase03() {
//
//    }
}
