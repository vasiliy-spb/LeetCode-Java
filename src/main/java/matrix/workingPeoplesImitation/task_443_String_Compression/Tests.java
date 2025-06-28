package matrix.workingPeoplesImitation.task_443_String_Compression;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    private final Solution testingClass = new Solution();

    @Test
    public void makeTestcase1a() {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int result = testingClass.compress(chars);
        assertEquals(6, result);
    }

    @Test
    public void makeTestcase1b() {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int length = testingClass.compress(chars);
        assertArrayEquals(new char[] {'a', '2', 'b', '2', 'c', '3'}, Arrays.copyOf(chars, length));
    }

    @Test
    public void makeTestcase2a() {
        char[] chars = {'a'};
        int result = testingClass.compress(chars);
        assertEquals(1, result);
    }

    @Test
    public void makeTestcase2b() {
        char[] chars = {'a'};
        int length = testingClass.compress(chars);
        assertArrayEquals(new char[] {'a'}, Arrays.copyOf(chars, length));
    }

    @Test
    public void makeTestcase3a() {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int result = testingClass.compress(chars);
        assertEquals(4, result);
    }

    @Test
    public void makeTestcase3b() {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int length = testingClass.compress(chars);
        assertArrayEquals(new char[] {'a', 'b', '1', '2'}, Arrays.copyOf(chars, length));
    }

}
