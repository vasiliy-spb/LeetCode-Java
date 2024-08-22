package matrix.workingPeoplesImitation.task_1314_Matrix_Block_Sum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        int[][] expected = {{12, 21, 16}, {27, 45, 33}, {24, 39, 28}};
        assertEquals(expected, testingClass.matrixBlockSum(mat, k));
    }

    @Test
    public void checkTestcase02() {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 2;
        int[][] expected = {{45, 45, 45}, {45, 45, 45}, {45, 45, 45}};
        assertEquals(expected, testingClass.matrixBlockSum(mat, k));
    }

//    @Test
//    public void checkTestcase03() {
//        int[][] mat = [[1,2,3],[4,5,6],[7,8,9]];
//        int k = 1;
//        int[][] expected = [[12,21,16],[27,45,33],[24,39,28]];
//        assertEquals(expected, testingClass.matrixBlockSum(mat, k));
//    }
}
