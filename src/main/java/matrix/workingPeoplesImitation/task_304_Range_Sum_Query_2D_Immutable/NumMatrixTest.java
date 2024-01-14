package matrix.workingPeoplesImitation.task_304_Range_Sum_Query_2D_Immutable;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumMatrixTest {

    @Test
    public void testSumRegion() {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix numMatrix = new NumMatrix(matrix);

        assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
        assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2));
        assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4));
    }
}
