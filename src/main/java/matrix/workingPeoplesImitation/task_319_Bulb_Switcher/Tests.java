package matrix.workingPeoplesImitation.task_319_Bulb_Switcher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int n = 3;
        int expected = 1;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }

    @Test
    public void checkTestcase02() {
        int n = 0;
        int expected = 0;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }

    @Test
    public void checkTestcase03() {
        int n = 1;
        int expected = 1;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }

    @Test
    public void checkTestcase04() {
        int n = 16;
        int expected = 4;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }

    @Test
    public void checkTestcase05() {
        int n = 32;
        int expected = 5;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }

    @Test
    public void checkTestcase06() {
        int n = 60;
        int expected = 7;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }

    @Test
    public void checkTestcase07() {
        int n = 61;
        int expected = 7;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }

    @Test
    public void checkTestcase08() {
        int n = 4;
        int expected = 2;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }

    @Test
    public void checkTestcase09() {
        int n = 9;
        int expected = 3;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }

    @Test
    public void checkTestcase10() {
        int n = 13;
        int expected = 3;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }

    @Test
    public void checkTestcase11() {
        int n = 1000;
        int expected = 31;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }

    @Test
    public void checkTestcase12() {
        int n = 1000000;
        int expected = 1000;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }

    @Test
    public void checkTestcase13() {
        int n = 1_000_000_000;
        int expected = 31622;
        assertEquals(expected, testingClass.bulbSwitch(n));
    }
}
