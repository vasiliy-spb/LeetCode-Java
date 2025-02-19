package matrix.workingPeoplesImitation.task_2375_Construct_Smallest_Number_From_DI_String;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String pattern = "IIIDIDDD";
        String expected = "123549876";
        assertEquals(expected, testingClass.smallestNumber(pattern));
    }

    @Test
    public void checkTestcase02() {
        String pattern = "DDD";
        String expected = "4321";
        assertEquals(expected, testingClass.smallestNumber(pattern));
    }

    @Test
    public void checkTestcase03() {
        String pattern = "DDDIII";
        String expected = "4321567";
        assertEquals(expected, testingClass.smallestNumber(pattern));
    }

    @Test
    public void checkTestcase04() {
        String pattern = "DDDDDDDD";
        String expected = "987654321";
        assertEquals(expected, testingClass.smallestNumber(pattern));
    }

    @Test
    public void checkTestcase05() {
        String pattern = "IIIDDD";
        String expected = "1237654";
        assertEquals(expected, testingClass.smallestNumber(pattern));
    }

    @Test
    public void checkTestcase06() {
        String pattern = "III";
        String expected = "1234";
        assertEquals(expected, testingClass.smallestNumber(pattern));
    }

    @Test
    public void checkTestcase07() {
        String pattern = "IDIDIDID";
        String expected = "132547698";
        assertEquals(expected, testingClass.smallestNumber(pattern));
    }

    @Test
    public void checkTestcase08() {
        String pattern = "DIDIDIDI";
        String expected = "214365879";
        assertEquals(expected, testingClass.smallestNumber(pattern));
    }

    @Test
    public void checkTestcase09() {
        String pattern = "IDI";
        String expected = "1324";
        assertEquals(expected, testingClass.smallestNumber(pattern));
    }

    @Test
    public void checkTestcase10() {
        String pattern = "DID";
        String expected = "2143";
        assertEquals(expected, testingClass.smallestNumber(pattern));
    }

    @Test
    public void checkTestcase11() {
        String pattern = "ID";
        String expected = "132";
        assertEquals(expected, testingClass.smallestNumber(pattern));
    }

    @Test
    public void checkTestcase12() {
        String pattern = "DI";
        String expected = "213";
        assertEquals(expected, testingClass.smallestNumber(pattern));
    }
}
