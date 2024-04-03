package matrix.workingPeoplesImitation.task_205_Isomorphic_Strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "egg";
        String t = "add";
        assertTrue(testingClass.isIsomorphic(s, t));
    }

    @Test
    public void checkTestcase2() {
        String s = "foo";
        String t = "bar";
        assertFalse(testingClass.isIsomorphic(s, t));
    }

    @Test
    public void checkTestcase3() {
        String s = "paper";
        String t = "title";
        assertTrue(testingClass.isIsomorphic(s, t));
    }

    @Test
    public void checkTestcase4() { // 24 / 45 testcases passed
        String s = "bbbaaaba";
        String t = "aaabbbba";
        assertFalse(testingClass.isIsomorphic(s, t));
    }

    @Test
    public void checkTestcase5() { // 37 / 45 testcases passed
        String s = "badc";
        String t = "baba";
        assertFalse(testingClass.isIsomorphic(s, t));
    }
}
