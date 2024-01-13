package matrix.workingPeoplesImitation.task_48_Trapping_Rain_Water;

public class Solution {
    public int trap(int[] height) {
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
}
