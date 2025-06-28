package matrix.workingPeoplesImitation.task_1415_The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int n = 1, k = 3;
        String expected = "c";
        assertEquals(expected, testingClass.getHappyString(n, k));
    }

    @Test
    public void checkTestcase02() {
        int n = 1, k = 4;
        String expected = "";
        assertEquals(expected, testingClass.getHappyString(n, k));
    }

    @Test
    public void checkTestcase03() {
        int n = 3, k = 9;
        String expected = "cab";
        assertEquals(expected, testingClass.getHappyString(n, k));
    }

    @Test
    public void checkTestcase04() {
        int n = 10, k = 3;
        String expected = "ababababca";
        assertEquals(expected, testingClass.getHappyString(n, k));
    }

    @Test
    public void checkTestcase05() {
        int n = 10, k = 30;
        String expected = "ababacbcac";
        assertEquals(expected, testingClass.getHappyString(n, k));
    }

    @Test
    public void checkTestcase06() {
        int n = 10, k = 100;
        String expected = "abacbabacb";
        assertEquals(expected, testingClass.getHappyString(n, k));
    }
}
