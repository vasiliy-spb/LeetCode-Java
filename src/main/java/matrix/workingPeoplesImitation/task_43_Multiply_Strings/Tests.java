package matrix.workingPeoplesImitation.task_43_Multiply_Strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String num1 = "2";
        String num2 = "3";
        String expected = "6";
        assertEquals(expected, testingClass.multiply(num1, num2));
    }

    @Test
    public void checkTestcase2() {
        String num1 = "123";
        String num2 = "456";
        String expected = "56088";
        assertEquals(expected, testingClass.multiply(num1, num2));
    }

    @Test
    public void checkTestcase3() {
        String num1 = "9133";
        String num2 = "0";
        String expected = "0";
        assertEquals(expected, testingClass.multiply(num1, num2));
    }
}
