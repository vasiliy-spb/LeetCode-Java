package matrix.workingPeoplesImitation.task_1750_Minimum_Length_of_String_After_Deleting_Similar_Ends;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "ca";
        int expected = 2;
        assertEquals(expected, testingClass.minimumLength(s));
    }

    @Test
    public void checkTestcase2() {
        String s = "cabaabac";
        int expected = 0;
        assertEquals(expected, testingClass.minimumLength(s));
    }

    @Test
    public void checkTestcase3() {
        String s = "aabccabba";
        int expected = 3;
        assertEquals(expected, testingClass.minimumLength(s));
    }

    @Test
    public void checkTestcase4() {
        String s = "a";
        int expected = 1;
        assertEquals(expected, testingClass.minimumLength(s));
    }

    @Test
    public void checkTestcase5() { // 96 / 100 testcases passed
        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
        int expected = 1;
        assertEquals(expected, testingClass.minimumLength(s));
    }

    @Test
    public void checkTestcase6() {
        String s = "aaa";
        int expected = 1;
        assertEquals(expected, testingClass.minimumLength(s));
    }

    @Test
    public void checkTestcase7() {
        String s = "bab";
        int expected = 1;
        assertEquals(expected, testingClass.minimumLength(s));
    }

    @Test
    public void checkTestcase8() { // 97 / 100 testcases passed
        String s = "abbbbbbbbbbbbbbbbbbba";
        int expected = 0;
        assertEquals(expected, testingClass.minimumLength(s));
    }

    @Test
    public void checkTestcase9() { // 99 / 100 testcases passed
        String s = "c";
        int expected = 1;
        assertEquals(expected, testingClass.minimumLength(s));
    }
}
