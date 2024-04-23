package matrix.workingPeoplesImitation.task_752_Open_the_Lock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        int expected = 6;
        assertEquals(expected, testingClass.openLock(deadends, target));
    }

    @Test
    public void checkTestcase2() {
        String[] deadends = {"8888"};
        String target = "0009";
        int expected = 1;
        assertEquals(expected, testingClass.openLock(deadends, target));
    }

    @Test
    public void checkTestcase3() {
        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";
        int expected = -1;
        assertEquals(expected, testingClass.openLock(deadends, target));
    }
}
