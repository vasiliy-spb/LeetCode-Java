package matrix.workingPeoplesImitation.task_933_Number_of_Recent_Calls;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final RecentCounter testingClass = new RecentCounter();

    @Test
    public void checkTestcase1() {
        assertEquals(1, testingClass.ping(1));
        assertEquals(2, testingClass.ping(100));
        assertEquals(3, testingClass.ping(3001));
        assertEquals(3, testingClass.ping(3002));
    }

}
