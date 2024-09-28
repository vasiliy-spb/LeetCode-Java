package matrix.workingPeoplesImitation.task_2981_Find_Longest_Special_Substring_That_Occurs_Thrice_I;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "aaaa";
        int expected = 2;
        assertEquals(expected, testingClass.maximumLength(s));
    }

    @Test
    public void checkTestcase02() {
        String s = "abcdef";
        int expected = -1;
        assertEquals(expected, testingClass.maximumLength(s));
    }

    @Test
    public void checkTestcase03() {
        String s = "abcaba";
        int expected = 1;
        assertEquals(expected, testingClass.maximumLength(s));
    }

    @Test
    public void checkTestcase04() {
        String s = "eccdnmcnkl";
        int expected = 1;
        assertEquals(expected, testingClass.maximumLength(s));
    }

    @Test
    public void checkTestcase05() {
        String s = "acc";
        int expected = -1;
        assertEquals(expected, testingClass.maximumLength(s));
    }

    @Test
    public void checkTestcase06() {
        String s = "lkwwdddddnnnnnynnnnl";
        int expected = 4;
        assertEquals(expected, testingClass.maximumLength(s));
    }
}
