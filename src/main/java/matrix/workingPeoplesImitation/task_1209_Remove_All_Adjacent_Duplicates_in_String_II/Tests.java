package matrix.workingPeoplesImitation.task_1209_Remove_All_Adjacent_Duplicates_in_String_II;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "abcd";
        int k = 2;
        String expected = "abcd";
        assertEquals(expected, testingClass.removeDuplicates(s, k));
    }

    @Test
    public void checkTestcase2() {
        String s = "deeedbbcccbdaa";
        int k = 3;
        String expected = "aa";
        assertEquals(expected, testingClass.removeDuplicates(s, k));
    }

    @Test
    public void checkTestcase3() {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        String expected = "ps";
        assertEquals(expected, testingClass.removeDuplicates(s, k));
    }

}
