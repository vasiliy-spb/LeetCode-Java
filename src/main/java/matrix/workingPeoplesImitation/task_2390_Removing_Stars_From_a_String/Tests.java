package matrix.workingPeoplesImitation.task_2390_Removing_Stars_From_a_String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "leet**cod*e";
        String expected = "lecoe";
        assertEquals(expected, testingClass.removeStars(s));
    }

    @Test
    public void checkTestcase2() {
        String s = "erase*****";
        String expected = "";
        assertEquals(expected, testingClass.removeStars(s));
    }

}
