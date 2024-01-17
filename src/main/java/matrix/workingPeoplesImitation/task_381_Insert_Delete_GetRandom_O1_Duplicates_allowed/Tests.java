package matrix.workingPeoplesImitation.task_381_Insert_Delete_GetRandom_O1_Duplicates_allowed;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Tests {
//    private final RandomizedCollection testingClass = new RandomizedCollection();

    @Test
    public void checkTestcase1() {
        RandomizedCollection testingClass = new RandomizedCollection();
        assertTrue(testingClass.insert(1));
        assertFalse(testingClass.insert(1));
        assertTrue(testingClass.insert(2));
        assertEquals(2, testingClass.getRandom());
        assertTrue(testingClass.remove(1));
        assertEquals(1, testingClass.getRandom());
    }

    @Test
    public void checkTestcase2() {
        RandomizedCollection testingClass = new RandomizedCollection();
        assertTrue(testingClass.insert(1));
        assertTrue(testingClass.remove(1));
        assertTrue(testingClass.insert(1));
    }
}
