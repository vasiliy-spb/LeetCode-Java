package matrix.workingPeoplesImitation.task_392_Is_Subsequence;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        String subsequence = "abc";
        String text = "ahbgdc";
        assertTrue(testingClass.isSubsequence(subsequence, text));
    }

    @Test
    public void makeTestcase2() {
        String subsequence = "axc";
        String text = "ahbgdc";
        assertFalse(testingClass.isSubsequence(subsequence, text));
    }

    @Test
    public void makeTestcase3() {
        String subsequence = "";
        String text = "ahbgdc";
        assertTrue(testingClass.isSubsequence(subsequence, text));
    }
}
