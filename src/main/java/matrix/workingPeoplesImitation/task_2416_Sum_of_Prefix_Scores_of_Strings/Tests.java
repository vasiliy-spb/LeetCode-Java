package matrix.workingPeoplesImitation.task_2416_Sum_of_Prefix_Scores_of_Strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private Solution testingClass;

    @Before
    public void init() {
        testingClass = new Solution();
    }

    @Test
    public void checkTestcase01() {
        String[] words = {"abc", "ab", "bc", "b"};
        int[] expected = {5, 4, 3, 2};
        assertArrayEquals(expected, testingClass.sumPrefixScores(words));
    }

    @Test
    public void checkTestcase02() {
        String[] words = {"abcd"};
        int[] expected = {4};
        assertArrayEquals(expected, testingClass.sumPrefixScores(words));
    }
}
