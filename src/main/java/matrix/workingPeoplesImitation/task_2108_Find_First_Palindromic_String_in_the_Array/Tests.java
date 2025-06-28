package matrix.workingPeoplesImitation.task_2108_Find_First_Palindromic_String_in_the_Array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        String expected = "ada";
        assertEquals(expected, testingClass.firstPalindrome(words));
    }

    @Test
    public void checkTestcase2() {
        String[] words = {"notapalindrome", "racecar"};
        String expected = "racecar";
        assertEquals(expected, testingClass.firstPalindrome(words));
    }

    @Test
    public void checkTestcase3() {
        String[] words = {"def", "ghi"};
        String expected = "";
        assertEquals(expected, testingClass.firstPalindrome(words));
    }

}
