package matrix.workingPeoplesImitation.task_417_Pacific_Atlantic_Water_Flow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// my solution
public class Solution {
    private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Integer> pacificCell = new HashSet<>();
        Set<Integer> atlanticCell = new HashSet<>();
        findAllCell(heights, atlanticCell, pacificCell);
        return getCommonCell(atlanticCell, pacificCell, heights[0].length);
    }

    private void findAllCell(int[][] heights, Set<Integer> atlanticCell, Set<Integer> pacificCell) {
        int n = heights.length;
        int m = heights[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isPacificCoast(i, j)) {
                    pacificCell.add(getCellKey(i, j, m));
                    traverseNeighbours(heights, i, j, pacificCell);
                }
                if (isAtlanticCoast(i, j, n, m)) {
                    atlanticCell.add(getCellKey(i, j, m));
                    traverseNeighbours(heights, i, j, atlanticCell);
                }
            }
        }
    }

    private boolean isPacificCoast(int i, int j) {
        return i == 0 || j == 0;
    }

    private int getCellKey(int y, int x, int length) {
        return y * length + x;
    }

    private void traverseNeighbours(int[][] heights, int i, int j, Set<Integer> pacificCell) {
        for (int[] direction : directions) {
            int y = i + direction[0];
            int x = j + direction[1];
            if (isValid(y, x, heights)) {
                int key = getCellKey(y, x, heights[0].length);
                if (pacificCell.contains(key)) {
                    continue;
                }
                if (heights[y][x] >= heights[i][j]) {
                    pacificCell.add(key);
                    traverseNeighbours(heights, y, x, pacificCell);
                }
            }
        }
    }

    private boolean isValid(int y, int x, int[][] heights) {
        return y >= 0 && y < heights.length && x >= 0 && x < heights[0].length;
    }

    private boolean isAtlanticCoast(int i, int j, int height, int width) {
        return i == height - 1 || j == width - 1;
    }

    private List<List<Integer>> getCommonCell(Set<Integer> atlanticCell, Set<Integer> pacificCell, int width) {
        List<List<Integer>> result = new ArrayList<>();
        for (int key : pacificCell) {
            if (!atlanticCell.contains(key)) {
                continue;
            }
            int y = key / width;
            int x = key % width;
            result.add(List.of(y, x));
        }
        return result;
    }
}
