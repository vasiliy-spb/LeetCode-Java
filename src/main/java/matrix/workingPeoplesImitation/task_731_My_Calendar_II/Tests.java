package matrix.workingPeoplesImitation.task_731_My_Calendar_II;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
//    private MyCalendarTwo testingClass;
    private MyCalendarTwo testingClass;

    @Before
    public void init() {
//        testingClass = new MyCalendarTwo();
        testingClass = new MyCalendarTwo();
    }

    @Test
    public void checkTestcase01() {
        List<Boolean> result = new ArrayList<>();
        result.add(testingClass.book(10, 20));
        result.add(testingClass.book(50, 60));
        result.add(testingClass.book(10, 40));
        result.add(testingClass.book(5, 15));
        result.add(testingClass.book(5, 10));
        result.add(testingClass.book(25, 55));
        List<Boolean> expected = List.of(true, true, true, false, true, true);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase02() {
        List<Boolean> result = new ArrayList<>();
        result.add(testingClass.book(47, 50));
        result.add(testingClass.book(1, 10));
        result.add(testingClass.book(27, 36));
        result.add(testingClass.book(40, 47));
        result.add(testingClass.book(20, 27));
        result.add(testingClass.book(15, 23));
        result.add(testingClass.book(10, 18));
        result.add(testingClass.book(27, 36));
        result.add(testingClass.book(17, 25));
        result.add(testingClass.book(8, 17));
        result.add(testingClass.book(24, 33));
        result.add(testingClass.book(23, 28));
        result.add(testingClass.book(21, 27));
        result.add(testingClass.book(47, 50));
        result.add(testingClass.book(14, 21));
        result.add(testingClass.book(26, 32));
        result.add(testingClass.book(16, 21));
        result.add(testingClass.book(2, 7));
        result.add(testingClass.book(24, 33));
        result.add(testingClass.book(6, 13));
        result.add(testingClass.book(44, 50));
        result.add(testingClass.book(33, 39));
        result.add(testingClass.book(30, 36));
        result.add(testingClass.book(6, 15));
        result.add(testingClass.book(21, 27));
        result.add(testingClass.book(49, 50));
        result.add(testingClass.book(38, 45));
        result.add(testingClass.book(4, 12));
        result.add(testingClass.book(46, 50));
        result.add(testingClass.book(13, 21));
        List<Boolean> expected = List.of(true, true, true, true, true, true, true, true, false, false, false, false, false, true, false, false, false, true, false, false, false, false, false, false, false, false, true, false, false, false);
        assertEquals(expected, result);
    }

//    @Test
//    public void checkTestcase03() {
//
//    }
}
