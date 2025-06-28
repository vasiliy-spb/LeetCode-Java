package matrix.workingPeoplesImitation.task_85_Maximal_Rectangle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {

    // my solution
    public int maximalRectangle(char[][] matrix) {
        int[][] suffixY = new int[matrix.length][matrix[0].length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    suffixY[i][j] = matrix[i][j] - '0';
                    if (i < matrix.length - 1) suffixY[i][j] += suffixY[i + 1][j];
                }
            }
        }
        int area = 0;
        int width = 0;
        int height = 202;
        for (int i = 0; i < matrix.length; i++) {
            boolean similar = true;
            int prev = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] - '0' == 1) {
                    width++;
                    height = Math.min(height, suffixY[i][j]);
                    if (width > 1) similar &= prev == suffixY[i][j];
                    prev = suffixY[i][j];
                    int currentArea;
                    if (!similar) currentArea = calculateArea(suffixY, i, j, width);
                    else currentArea = height * width;
                    area = Math.max(area, currentArea);
                } else {
                    width = 0;
                    height = 202;
                }
            }
            width = 0;
            height = 202;
        }
        return area;
    }

    private int calculateArea(int[][] suffixY, int i, int j, int width) {
        int area = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int k = j - width + 1; k <= j; k++) {
            queue.offer(suffixY[i][k]);
            PriorityQueue<Integer> currentQueue = new PriorityQueue<>(queue);
            for (int l = j - width + 1; l <= k; l++) {
                area = Math.max(area, (k - l + 1) * currentQueue.peek());
                currentQueue.remove(suffixY[i][l]);
            }
        }
        return area;
    }

    // from leetcode solutions
    public int maximalRectangle2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols + 1]; // Include an extra element for easier calculation
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < cols; i++) {
                heights[i] = (row[i] == '1') ? heights[i] + 1 : 0;
            }

            // Calculate max area using stack-based method
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
            }
        }

        return maxArea;
    }

    // from walkccc.me
    public int maximalRectangle3(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int ans = 0;
        int[] hist = new int[matrix[0].length];

        for (char[] row : matrix) {
            for (int i = 0; i < row.length; ++i)
                hist[i] = row[i] == '0' ? 0 : hist[i] + 1;
            ans = Math.max(ans, largestRectangleArea(hist));
        }

        return ans;
    }

    private int largestRectangleArea(int[] heights) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= heights.length; ++i) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                final int h = heights[stack.pop()];
                final int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, h * w);
            }
            stack.push(i);
        }

        return ans;
    }

    // from leetcode solutions (approach: Monotonic stack) (https://leetcode.com/problems/maximal-rectangle/solutions/5027802/java-monotonic-stack-solution-converting-to-leetcode-84/)
    public int maximalRectangle4(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            ans = Math.max(ans, largestRectInHistogram(heights));
        }
        return ans;
    }

    // https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/5027623/java-monotonic-stack-solution-explaining-why-we-use-it
    private int largestRectInHistogram(int[] heights) {
        // Monotonic Stack Approach
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int ans = 0;
        stack.offerFirst(-1);
        for (int i = 0; i < n; i++) {
            while (stack.peekFirst() != -1 && heights[stack.peekFirst()] > heights[i]) {
                int ind = stack.pollFirst();
                ans = Math.max(ans, heights[ind] * (i - stack.peekFirst() - 1));
            }
            stack.offerFirst(i);
        }
        while (stack.peekFirst() != -1) {
            int ind = stack.pollFirst();
            ans = Math.max(ans, heights[ind] * (n - stack.peekFirst() - 1));
        }
        return ans;
    }
}
