package matrix.workingPeoplesImitation.task_2904_Shortest_and_Lexicographically_Smallest_Beautiful_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    void checkTestcase01() {
        String s = "100011001";
        int k = 3;
        String expected = "11001";
        Assertions.assertEquals(expected, testingClass.shortestBeautifulSubstring(s, k));
    }

    @Test
    void checkTestcase02() {
        String s = "1011";
        int k = 2;
        String expected = "11";
        Assertions.assertEquals(expected, testingClass.shortestBeautifulSubstring(s, k));
    }

    @Test
    void checkTestcase03() {
        String s = "000";
        int k = 1;
        String expected = "";
        Assertions.assertEquals(expected, testingClass.shortestBeautifulSubstring(s, k));
    }

    @Test
    void checkTestcase04() {
        String s = "11000111";
        int k = 1;
        String expected = "1";
        Assertions.assertEquals(expected, testingClass.shortestBeautifulSubstring(s, k));
    }

    @Test
    void checkTestcase05() {
        String s = "001110101101101111";
        int k = 10;
        String expected = "10101101101111";
        Assertions.assertEquals(expected, testingClass.shortestBeautifulSubstring(s, k));
    }

    @Test
    void checkTestcase06() {
        String s = "1111111011111";
        int k = 12;
        String expected = "1111111011111";
        Assertions.assertEquals(expected, testingClass.shortestBeautifulSubstring(s, k));
    }
}
