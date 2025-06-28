package matrix.workingPeoplesImitation.task_42_Trapping_Rain_Water;

public class Solution {

    // my solution (12.04.2024)
    public int trap(int[] height) {
        int maxHeight = 0;
        int index = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                index = i;
            }
        }
        int count = 0;
        int currentHeight = height[0];
        for (int i = 1; i < index; i++) {
            if (currentHeight > height[i]) count += currentHeight - height[i];
            else currentHeight = height[i];
        }
        currentHeight = height[height.length - 1];
        for (int i = height.length - 1; i > index; i--) {
            if (currentHeight > height[i]) count += currentHeight - height[i];
            else currentHeight = height[i];
        }
        return count;
    }

    // my previous solution
    public int trap1(int[] height) {
        int maxHeight = 0;
        int indexMaxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                indexMaxHeight = i;
            }
        }
        int trap = 0;
        int leftHeight = 0;
        int rightHeight = 0;
        for (int i = 0, j = height.length - 1; i < indexMaxHeight || j > indexMaxHeight; i++, j--) {
            if (i < indexMaxHeight) {
                if (height[i] < leftHeight) {
                    trap += leftHeight - height[i];
                } else {
                    leftHeight = height[i];
                }
            }
            if (j > indexMaxHeight) {
                if (height[j] < rightHeight) {
                    trap += rightHeight - height[j];
                } else {
                    rightHeight = height[j];
                }
            }
        }
        return trap;
    }

    // from leetcode solutions (https://leetcode.com/problems/trapping-rain-water/solutions/5010235/faster-lesser-detailed-explaination-no-two-pointer-step-by-step-explaination-python-java/)
    public int trap3(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] left = new int[n];
        int[] right = new int[n];
        int storedWater = 0;

        // Fill left array
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        // Fill right array
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(left[i], right[i]);
            storedWater += minHeight - height[i];
        }

        return storedWater;
    }

    // from walkccc.me (Approach 1: O(n) space)
    public int trap4(int[] height) {
        final int n = height.length;
        int ans = 0;
        int[] l = new int[n]; // l[i] := max(height[0..i])
        int[] r = new int[n]; // r[i] := max(height[i..n))

        for (int i = 0; i < n; ++i)
            l[i] = i == 0 ? height[i] : Math.max(height[i], l[i - 1]);

        for (int i = n - 1; i >= 0; --i)
            r[i] = i == n - 1 ? height[i] : Math.max(height[i], r[i + 1]);

        for (int i = 0; i < n; ++i)
            ans += Math.min(l[i], r[i]) - height[i];

        return ans;
    }

    // from walkccc.me (Approach 2: O(1) space)
    public int trap5(int[] height) {
        if (height.length == 0)
            return 0;

        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];

        while (l < r)
            if (maxL < maxR) {
                ans += maxL - height[l];
                maxL = Math.max(maxL, height[++l]);
            } else {
                ans += maxR - height[r];
                maxR = Math.max(maxR, height[--r]);
            }

        return ans;
    }
}
