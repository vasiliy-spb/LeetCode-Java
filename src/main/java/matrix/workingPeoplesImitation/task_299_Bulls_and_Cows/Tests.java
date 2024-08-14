package matrix.workingPeoplesImitation.task_299_Bulls_and_Cows;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String secret = "1807";
        String guess = "7810";
        String expected = "1A3B";
        assertEquals(expected, testingClass.getHint(secret, guess));
    }

    @Test
    public void checkTestcase02() {
        String secret = "1123";
        String guess = "0111";
        String expected = "1A1B";
        assertEquals(expected, testingClass.getHint(secret, guess));
    }

    @Test
    public void checkTestcase03() {
        String secret = "1122";
        String guess = "1222";
        String expected = "3A0B";
        assertEquals(expected, testingClass.getHint(secret, guess));
    }
}
