package matrix.workingPeoplesImitation.task_1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "eleetminicoworoep";
        int expected = 13; // "_leetminicowor___"
        assertEquals(expected, testingClass.findTheLongestSubstring(s));
    }

    @Test
    public void checkTestcase02() {
        String s = "leetcodeisgreat";
        int expected = 5; // "leetc__________"
        assertEquals(expected, testingClass.findTheLongestSubstring(s));
    }

    @Test
    public void checkTestcase03() {
        String s = "bcbcbc";
        int expected = 6;
        assertEquals(expected, testingClass.findTheLongestSubstring(s));
    }
}
