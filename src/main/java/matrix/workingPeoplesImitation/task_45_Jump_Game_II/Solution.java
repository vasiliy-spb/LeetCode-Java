package matrix.workingPeoplesImitation.task_45_Jump_Game_II;

public class Solution {

    // my solution
    public int jump(int[] nums) {
        int count = 0;
        if (nums.length == 1) return count;
        for (int i = 0; i < nums.length; ) {
            if (i + nums[i] >= nums.length - 1) {
                count++;
                break;
            }
            int max = 0;
            int add = 0;
            for (int j = 0; j <= nums[i]; j++) {
                if (j + nums[i + j] > max || j + nums[i + j] >= max && max > 0) {
                    max = j + nums[i + j];
                    add = j;
                }
            }
            count++;
            i += add == 0 ? nums[i] : add;
        }
        return count;
    }

    // from walkccc.me
    public int jump2(int[] nums) {
        int ans = 0;
        int end = 0;
        int farthest = 0;

        // Start an implicit BFS.
        for (int i = 0; i < nums.length - 1; ++i) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                ++ans;
                break;
            }
            if (i == end) {   // Visited all the items on the current level.
                ++ans;          // Increment the level.
                end = farthest; // Make the queue size for the next level.
            }
        }

        return ans;
    }

}
