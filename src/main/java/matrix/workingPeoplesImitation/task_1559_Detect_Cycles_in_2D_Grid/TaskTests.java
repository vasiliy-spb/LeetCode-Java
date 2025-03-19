package matrix.workingPeoplesImitation.task_1559_Detect_Cycles_in_2D_Grid;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        char[][] grid = {{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};
        assertTrue(testingClass.containsCycle(grid));
    }

    @Test
    public void checkTestcase02() {
        char[][] grid = {{'c', 'c', 'c', 'a'}, {'c', 'd', 'c', 'c'}, {'c', 'c', 'e', 'c'}, {'f', 'c', 'c', 'c'}};
        assertTrue(testingClass.containsCycle(grid));
    }

    @Test
    public void checkTestcase03() {
        char[][] grid = {{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}};
        assertFalse(testingClass.containsCycle(grid));
    }

    @Test
    public void checkTestcase04() {
        char[][] grid = {
                {'c', 'a', 'd'},
                {'a', 'a', 'a'},
                {'a', 'a', 'd'},
                {'a', 'c', 'd'},
                {'a', 'b', 'c'}
        };
        assertTrue(testingClass.containsCycle(grid));
    }

    @Test
    public void checkTestcase05() {
        char[][] grid = {
                {'b', 'a', 'c'},
                {'c', 'a', 'c'},
                {'d', 'd', 'c'},
                {'b', 'c', 'c'}
        };
        assertFalse(testingClass.containsCycle(grid));
    }

    @Test
    public void checkTestcase06() {
        char[][] grid = readFromFile("src/main/java/matrix/workingPeoplesImitation/task_1559_Detect_Cycles_in_2D_Grid/testcases/testcase06.txt");
        assertFalse(testingClass.containsCycle(grid));
    }

    private char[][] readFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            List<String[]> lines = new ArrayList<>();
            while (reader.ready()) {
                String[] line = reader.readLine().trim().split(",");
                lines.add(line);
            }
            char[][] ans = new char[lines.size()][lines.get(0).length];
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    ans[i][j] = lines.get(i)[j].charAt(0);
                }
            }
            return ans;
        } catch (IOException ignored) {
        }
        return new char[][]{};
    }
}
