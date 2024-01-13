package matrix.workingPeoplesImitation.task_48_Trapping_Rain_Water;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = testingClass.trap(height);
        int expected = 6;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void makeTestcase2() {
        int [] height = {4,2,0,3,2,5};
        int result = testingClass.trap(height);
        int expected = 9;
        Assertions.assertEquals(expected, result);
    }

}
