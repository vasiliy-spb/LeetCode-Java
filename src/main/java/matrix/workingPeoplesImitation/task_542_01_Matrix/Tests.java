package matrix.workingPeoplesImitation.task_542_01_Matrix;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] expected = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        assertArrayEquals(expected, testingClass.updateMatrix(mat));
    }

    @Test
    public void checkTestcase2() {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] expected = {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}};
        assertArrayEquals(expected, testingClass.updateMatrix(mat));
    }

    @Test
    public void checkTestcase3() { // 2 / 50 testcases passed
        int[][] mat = {{0}, {0}, {0}, {0}, {0}};
        int[][] expected = {{0}, {0}, {0}, {0}, {0}};
        assertArrayEquals(expected, testingClass.updateMatrix(mat));
    }

    @Test
    public void checkTestcase4() { // 19 / 50 testcases passed
        int[][] mat = {
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        int[][] expected = {
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 2, 1, 1, 0, 1},
                {2, 1, 1, 1, 1, 2, 1, 0, 1, 0},
                {3, 2, 2, 1, 0, 1, 0, 0, 1, 1}};
        assertArrayEquals(expected, testingClass.updateMatrix(mat));
    }

    @Test
    public void checkTestcase5() { // 37 / 50 testcases passed
        int[][] mat = readFromFile("src/main/java/matrix/workingPeoplesImitation/task_542_01_Matrix/testCase5");
        int[][] expected = readFromFile("src/main/java/matrix/workingPeoplesImitation/task_542_01_Matrix/expectedTestCase5");
        assertArrayEquals(expected, testingClass.updateMatrix(mat));
    }

    public static int[][] readFromFile(String filePath) {
        int[][] result = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            if (line != null) {
                result = parseStringToArray(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static int[][] parseStringToArray(String input) {
        // Remove leading and trailing brackets and split by "],["
        String[] rowStrings = input.substring(2, input.length() - 2).split("\\],\\[");

        int numRows = rowStrings.length;
        int numCols = rowStrings[0].split(",").length;

        int[][] result = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            String[] colStrings = rowStrings[i].split(",");
            for (int j = 0; j < numCols; j++) {
                result[i][j] = Integer.parseInt(colStrings[j]);
            }
        }

        return result;
    }

}
