package matrix.workingPeoplesImitation.task_677_Map_Sum_Pairs;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {
    @Test
    public void checkTestcase01() {
        boolean check = true;
        MapSum testingClass = new MapSum();
        testingClass.insert("apple", 3);
        int expected = 3;
        check &= expected == testingClass.sum("ap");
        testingClass.insert("app", 2);
        expected = 5;
        check &= expected == testingClass.sum("ap");
        assertTrue(check);
    }

    @Test
    public void checkTestcase02() {
        boolean check = true;
        MapSum testingClass = new MapSum();
        testingClass.insert("a", 3);
        int expected = 0;
        check &= expected == testingClass.sum("ap");
        testingClass.insert("b", 2);
        expected = 3;
        check &= expected == testingClass.sum("a");
        assertTrue(check);
    }
}
