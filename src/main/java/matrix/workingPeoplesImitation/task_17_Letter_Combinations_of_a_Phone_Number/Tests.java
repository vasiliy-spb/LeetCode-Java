package matrix.workingPeoplesImitation.task_17_Letter_Combinations_of_a_Phone_Number;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String digits = "23";
        List<String> expected = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertEquals(expected, testingClass.letterCombinations(digits));
    }

    @Test
    public void checkTestcase2() {
        String digits = "";
        List<String> expected = new ArrayList<>();
        assertEquals(expected, testingClass.letterCombinations(digits));
    }

    @Test
    public void checkTestcase3() {
        String digits = "2";
        List<String> expected = List.of("a", "b", "c");
        assertEquals(expected, testingClass.letterCombinations(digits));
    }

}
