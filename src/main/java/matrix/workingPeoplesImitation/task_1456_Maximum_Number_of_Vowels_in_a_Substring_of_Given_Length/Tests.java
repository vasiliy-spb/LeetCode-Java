package matrix.workingPeoplesImitation.task_1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1() {
        String s = "abciiidef";
        int k = 3;
        int expected = 3;
        assertEquals(expected, testingClass.maxVowels(s, k));
    }

    @Test
    public void makeTestcase2() {
        String s = "aeiou";
        int k = 2;
        int expected = 2;
        assertEquals(expected, testingClass.maxVowels(s, k));
    }

    @Test
    public void makeTestcase3() {
        String s = "leetcode";
        int k = 3;
        int expected = 2;
        assertEquals(expected, testingClass.maxVowels(s, k));
    }

    @Test
    public void makeTestcase4() {
        String s = "l";
        int k = 1;
        int expected = 0;
        assertEquals(expected, testingClass.maxVowels(s, k));
    }

    @Test
    public void makeTestcase5() {
        String s = "a";
        int k = 1;
        int expected = 1;
        assertEquals(expected, testingClass.maxVowels(s, k));
    }

}
