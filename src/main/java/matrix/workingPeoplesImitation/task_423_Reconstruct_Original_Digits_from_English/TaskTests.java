package matrix.workingPeoplesImitation.task_423_Reconstruct_Original_Digits_from_English;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "owoztneoer";
        String expected = "012";
        assertEquals(expected, testingClass.originalDigits(s));
    }

    @Test
    public void checkTestcase02() {
        String s = "fviefuro";
        String expected = "45";
        assertEquals(expected, testingClass.originalDigits(s));
    }

    @Test
    public void checkTestcase03() {
        String s = "zeroonetwothreefourfivesixseveneightnine";
        String expected = "0123456789";
        assertEquals(expected, testingClass.originalDigits(s));
    }
}
