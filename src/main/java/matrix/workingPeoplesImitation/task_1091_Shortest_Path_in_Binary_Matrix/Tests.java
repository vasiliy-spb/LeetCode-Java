package matrix.workingPeoplesImitation.task_1091_Shortest_Path_in_Binary_Matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[][] grid = {
                {0, 1},
                {1, 0}
        };
        int expected = 2;
        assertEquals(expected, testingClass.shortestPathBinaryMatrix(grid));
    }

//    @Test
//    public void checkTestcase02() {
//        
//    }
//    
//    @Test
//    public void checkTestcase03() {
//        
//    }
}
