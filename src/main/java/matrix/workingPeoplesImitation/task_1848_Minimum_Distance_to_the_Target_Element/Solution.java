package matrix.workingPeoplesImitation.task_1848_Minimum_Distance_to_the_Target_Element;

// my solution
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int diffWithStart = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                diffWithStart = Math.min(diffWithStart, Math.abs(i - start));
            }
        }
        return diffWithStart;
    }
}
