package matrix.workingPeoplesImitation.task_621_Task_Scheduler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int expected = 8;
        assertEquals(expected, testingClass.leastInterval(tasks, n));
    }

    @Test
    public void checkTestcase2() {
        char[] tasks = {'A', 'C', 'A', 'B', 'D', 'B'};
        int n = 1;
        int expected = 6;
        assertEquals(expected, testingClass.leastInterval(tasks, n));
    }

    @Test
    public void checkTestcase3() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 3;
        int expected = 10;
        assertEquals(expected, testingClass.leastInterval(tasks, n));
    }

    @Test
    public void checkTestcase4() { // 18 / 71 testcases passed
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 50;
        int expected = 104;
        assertEquals(expected, testingClass.leastInterval(tasks, n));
    }

    @Test
    public void checkTestcase5() { // 61 / 71 testcases passed
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 1;
        int expected = 12;
        assertEquals(expected, testingClass.leastInterval(tasks, n));
    }

    @Test
    public void checkTestcase6() { // 30 / 71 testcases passed
        char[] tasks = {'A', 'A'};
        int n = 2;
        int expected = 4;
        assertEquals(expected, testingClass.leastInterval(tasks, n));
    }

    @Test
    public void checkTestcase7() { // 32 / 71 testcases passed
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        int n = 7;
        int expected = 18;
        assertEquals(expected, testingClass.leastInterval(tasks, n));
    }
}
