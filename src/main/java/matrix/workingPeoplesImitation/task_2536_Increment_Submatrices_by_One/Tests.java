package matrix.workingPeoplesImitation.task_2536_Increment_Submatrices_by_One;

import org.junit.Test;

import static matrix.workingPeoplesImitation.utils.MatrixUtils.printMatrix;
import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();
//    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        int n = 3;
        int[][] query = {
                {0, 0, 2, 2},
                {1, 1, 2, 2},
                {0, 0, 1, 1}
        };
        int[][] result = {
                {2, 2, 1},
                {2, 3, 2},
                {1, 2, 2}
        };
        int[][] ans = testingClass.rangeAddQueries(n, query);
//        printMatrix(ans);
        assertArrayEquals(result, ans);
    }

    @Test
    public void checkTestcase02() {
        int n = 2;
        int[][] query = {
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        };
        int[][] result = {
                {2, 1},
                {1, 1}
        };
        assertArrayEquals(result, testingClass.rangeAddQueries(n, query));
    }

    @Test
    public void checkTestcase03() {
        int n = 4;
        int[][] query = {
                {1, 1, 2, 2},
                {0, 0, 3, 3},
                {2, 2, 3, 3}
        };
        int[][] result = {
                {1, 1, 1, 1},
                {1, 2, 2, 1},
                {1, 2, 3, 2},
                {1, 1, 2, 2}
        };
        assertArrayEquals(result, testingClass.rangeAddQueries(n, query));
    }

    @Test
    public void checkTestcase04() {
        int n = 1;
        int[][] query = {
                {0, 0, 0, 0}
        };
        int[][] result = {
                {1}
        };
        assertArrayEquals(result, testingClass.rangeAddQueries(n, query));
    }

    @Test
    public void checkTestcase05() {
        int n = 3;
        int[][] query = {};
        int[][] result = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        assertArrayEquals(result, testingClass.rangeAddQueries(n, query));
    }

    @Test
    public void checkTestcase06() {
        int n = 5;
        int[][] query = {
                {0, 0, 4, 4},
                {1, 1, 3, 3},
                {2, 2, 4, 4},
                {0, 0, 2, 2},
                {3, 3, 4, 4}
        };
        int[][] result = {
                {2, 2, 2, 1, 1},
                {2, 3, 3, 2, 1},
                {2, 3, 4, 3, 2},
                {1, 2, 3, 4, 3},
                {1, 1, 2, 3, 3}
        };
        int[][] ans = testingClass.rangeAddQueries(n, query);
//        printMatrix(ans);
        assertArrayEquals(result, ans);
    }

    @Test
    public void checkTestcase07() {
        int n = 6;
        int[][] query = {
                {0, 0, 5, 5},
                {1, 1, 4, 4},
                {2, 2, 3, 3},
                {0, 0, 1, 1},
                {4, 4, 5, 5},
                {3, 3, 4, 4}
        };
        int[][] result = {
                {2, 2, 1, 1, 1, 1},
                {2, 3, 2, 2, 2, 1},
                {1, 2, 3, 3, 2, 1},
                {1, 2, 3, 4, 3, 1},
                {1, 2, 2, 3, 4, 2},
                {1, 1, 1, 1, 2, 2}
        };
        int[][] ans = testingClass.rangeAddQueries(n, query);
//        printMatrix(ans);
        assertArrayEquals(result, ans);
    }

    @Test
    public void checkTestcase08() {
        int n = 8;
        int[][] query = {
                {0, 0, 7, 7},
                {0, 0, 6, 6},
                {0, 0, 5, 5},
                {0, 0, 4, 4},
                {0, 0, 3, 3},
                {0, 0, 2, 2},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        };
        int[][] result = {
                {8, 7, 6, 5, 4, 3, 2, 1},
                {7, 7, 6, 5, 4, 3, 2, 1},
                {6, 6, 6, 5, 4, 3, 2, 1},
                {5, 5, 5, 5, 4, 3, 2, 1},
                {4, 4, 4, 4, 4, 3, 2, 1},
                {3, 3, 3, 3, 3, 3, 2, 1},
                {2, 2, 2, 2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        assertArrayEquals(result, testingClass.rangeAddQueries(n, query));
    }

    @Test
    public void checkTestcase09() {
        int n = 10;
        int[][] query = {
                {1, 1, 8, 8},
                {2, 2, 7, 7},
                {3, 3, 6, 6},
                {4, 4, 5, 5},
                {0, 0, 9, 9},
                {0, 0, 9, 0},
                {0, 0, 0, 9},
                {9, 9, 9, 9}
        };
        int[][] result = {
                {3, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {2, 2, 3, 3, 3, 3, 3, 3, 2, 1},
                {2, 2, 3, 4, 4, 4, 4, 3, 2, 1},
                {2, 2, 3, 4, 5, 5, 4, 3, 2, 1},
                {2, 2, 3, 4, 5, 5, 4, 3, 2, 1},
                {2, 2, 3, 4, 4, 4, 4, 3, 2, 1},
                {2, 2, 3, 3, 3, 3, 3, 3, 2, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {2, 1, 1, 1, 1, 1, 1, 1, 1, 2}
        };
        int[][] ans = testingClass.rangeAddQueries(n, query);
//        printMatrix(ans);
        assertArrayEquals(result, ans);
    }

    @Test
    public void checkTestcase10() {
        int n = 7;
        int[][] query = {
                {0, 0, 6, 6},
                {1, 1, 5, 5},
                {2, 2, 4, 4},
                {3, 3, 3, 3},
                {0, 0, 3, 3},
                {3, 3, 6, 6},
                {1, 4, 5, 5}
        };
        int[][] result = {
                {2, 2, 2, 2, 1, 1, 1},
                {2, 3, 3, 3, 3, 3, 1},
                {2, 3, 4, 4, 4, 3, 1},
                {2, 3, 4, 6, 5, 4, 2},
                {1, 2, 3, 4, 5, 4, 2},
                {1, 2, 2, 3, 4, 4, 2},
                {1, 1, 1, 2, 2, 2, 2}
        };
        int[][] ans = testingClass.rangeAddQueries(n, query);
//        printMatrix(ans);
        assertArrayEquals(result, ans);
    }

}
