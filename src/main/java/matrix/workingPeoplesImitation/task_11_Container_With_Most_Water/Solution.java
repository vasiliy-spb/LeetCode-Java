package matrix.workingPeoplesImitation.task_11_Container_With_Most_Water;

public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i <= j;) {
            int h = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, h * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public int maxArea3(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int currentMax = Math.min(height[i], height[j]) * (j - i);
                if (currentMax > maxArea) maxArea = currentMax;
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        int maxArea = 0;
        int maxLeft = 0;
        int indexMaxLeft = 0;
        int maxRight = 0;
        int indexMaxRight = 0;
        for (int i = 0, j = height.length - 1; i <= j; i++, j--) {
            if (height[i] > maxLeft) {
                maxLeft = height[i];
                indexMaxLeft = i;
            }
            if (height[j] > maxRight) {
                maxRight = height[j];
                indexMaxRight = j;
            }
            int currentMaxArea = Math.min(maxLeft, maxRight) * (indexMaxRight - indexMaxLeft);
            if (currentMaxArea > maxArea) maxArea = currentMaxArea;
        }
        for (int i = 0, j = height.length - 1; i <= j; i++, j--) {
            int currentLeftArea = Math.min(maxLeft, height[j]) * (j - indexMaxLeft);
            if (currentLeftArea > maxArea) maxArea = currentLeftArea;
            int currentRightArea = Math.min(maxRight, height[i]) * (indexMaxRight - i);
            if (currentRightArea > maxArea) maxArea = currentRightArea;
        }
        for (int i = indexMaxLeft, j = indexMaxLeft; i >= 0 || j < height.length; i--, j++) {
            if (i >= 0) {
                int currentLeftArea = Math.min(maxLeft, height[i]) * (indexMaxLeft - i);
                if (currentLeftArea > maxArea) maxArea = currentLeftArea;
            }
            if (j < height.length) {
                int currentLeftArea = Math.min(maxLeft, height[j]) * (j - indexMaxLeft);
                if (currentLeftArea > maxArea) maxArea = currentLeftArea;
            }
        }
        for (int i = indexMaxRight, j = indexMaxRight; i >= 0 || j < height.length; i--, j++) {
            if (i >= 0) {
                int currentLeftArea = Math.min(maxRight, height[i]) * (indexMaxRight - i);
                if (currentLeftArea > maxArea) maxArea = currentLeftArea;
            }
            if (j < height.length) {
                int currentLeftArea = Math.min(maxRight, height[j]) * (j - indexMaxRight);
                if (currentLeftArea > maxArea) maxArea = currentLeftArea;
            }
        }
        return maxArea;
    }

    // from GPT
    public static int maxArea0(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, h * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
//[1,2,4,3]
/*
            |
            |   |
        |   |   |
    |   |   |   |


 */

//[2,3,4,5,18,17,6] // 17


