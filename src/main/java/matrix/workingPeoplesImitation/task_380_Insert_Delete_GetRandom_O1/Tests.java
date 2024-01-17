package matrix.workingPeoplesImitation.task_380_Insert_Delete_GetRandom_O1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {
    private final RandomizedSet testingClass = new RandomizedSet();

    @Test
    public void checkTestcase1() {
        assertTrue(testingClass.insert(1));
        assertFalse(testingClass.remove(2));
        assertTrue(testingClass.insert(2));
        assertEquals(2, testingClass.getRandom());
        assertTrue(testingClass.remove(1));
        assertFalse(testingClass.insert(2));
        assertEquals(2, testingClass.getRandom());
    }
}
