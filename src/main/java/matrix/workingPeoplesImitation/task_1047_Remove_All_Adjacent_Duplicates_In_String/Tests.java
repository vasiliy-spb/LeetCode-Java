package matrix.workingPeoplesImitation.task_1047_Remove_All_Adjacent_Duplicates_In_String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "abbaca";
        String expected = "ca";
        assertEquals(expected, testingClass.removeDuplicates(s));
    }

    @Test
    public void checkTestcase2() {
        String s = "azxxzy";
        String expected = "ay";
        assertEquals(expected, testingClass.removeDuplicates(s));
    }

    @Test
    public void checkTestcase3() {
        String s = "azxxxzy";
        String expected = "azxzy";
        assertEquals(expected, testingClass.removeDuplicates(s));
    }

}
