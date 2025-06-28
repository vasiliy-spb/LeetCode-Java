package matrix.workingPeoplesImitation.task_1732_Find_the_Highest_Altitude;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        int[] gain = {-5,1,5,0,-7};
        int expected = 1;
        assertEquals(expected, testingClass.largestAltitude(gain));
    }

    @Test
    public void makeTestcase2() {
        int[] gain = {-4,-3,-2,-1,4,3,2};
        int expected = 0;
        assertEquals(expected, testingClass.largestAltitude(gain));
    }

}
