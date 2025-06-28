package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class AuxiliaryTests {
    @Test
    public void checkDecrementFunction01() {
        int num = 10000;
        int[] numArray = Solution2.getNumAsArray(num);
        int[] expected = {0, 9, 9, 9, 9};
        Solution2.decrementDigitArray(numArray);
        System.out.println("num = " + num);
        System.out.println("Expected:");
        System.out.println(Arrays.toString(expected));
        System.out.println("Actual:");
        System.out.println(Arrays.toString(numArray));
        assertArrayEquals(expected, numArray);
    }

    @Test
    public void checkDecrementFunction02() {
        int num = 4532;
        int[] numArray = Solution2.getNumAsArray(num);
        int[] expected = {4, 5, 3, 1};
        System.out.println("num = " + num);
        Solution2.decrementDigitArray(numArray);
        System.out.println("Expected:");
        System.out.println(Arrays.toString(expected));
        System.out.println("Actual:");
        System.out.println(Arrays.toString(numArray));
        assertArrayEquals(expected, numArray);
    }
}
