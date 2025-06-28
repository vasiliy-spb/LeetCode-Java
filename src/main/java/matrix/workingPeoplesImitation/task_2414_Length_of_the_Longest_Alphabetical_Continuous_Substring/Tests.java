package matrix.workingPeoplesImitation.task_2414_Length_of_the_Longest_Alphabetical_Continuous_Substring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        String s = "abacaba";
        int expected = 2;
        assertEquals(expected, testingClass.longestContinuousSubstring(s));
    }

    @Test
    public void makeTestcase2() {
        String s = "abcde";
        int expected = 5;
        assertEquals(expected, testingClass.longestContinuousSubstring(s));
    }

}
