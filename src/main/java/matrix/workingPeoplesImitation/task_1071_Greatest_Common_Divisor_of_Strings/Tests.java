package matrix.workingPeoplesImitation.task_1071_Greatest_Common_Divisor_of_Strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String str1 = "ABCABC", str2 = "ABC";
        String expected = "ABC";
        assertEquals(expected, testingClass.gcdOfStrings(str1, str2));
    }

    @Test
    public void checkTestcase2() {
        String str1 = str1 = "ABABAB", str2 = "ABAB";
        String expected = "AB";
        assertEquals(expected, testingClass.gcdOfStrings(str1, str2));
    }

    @Test
    public void checkTestcase3() {
        String str1 = str1 = "LEET", str2 = "CODE";
        String expected = "";
        assertEquals(expected, testingClass.gcdOfStrings(str1, str2));
    }

    @Test
    public void checkTestcase4() {
        String str1 = "ABCDEF", str2 = "ABC";
        String expected = "";
        assertEquals(expected, testingClass.gcdOfStrings(str1, str2));
    }

    @Test
    public void checkTestcase5() {
        String str1 = "AABB", str2 = "AB";
        String expected = "";
        assertEquals(expected, testingClass.gcdOfStrings(str1, str2));
    }

    @Test
    public void checkTestcase6() {
        String str1 = "ABABCCABAB", str2 = "ABAB";
        String expected = "";
        assertEquals(expected, testingClass.gcdOfStrings(str1, str2));
    }

}
