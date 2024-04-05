package matrix.workingPeoplesImitation.task_55_Jump_Game;

public class Solution {

    // my solution
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (i >= nums.length - 1 || i + nums[i] >= nums.length - 1) return true;
            int max = 0;
            int add = 0;
            for (int j = 0; j <= nums[i]; j++) {
                if (j + nums[i + j] > max || j + nums[i + j] >= max && max > 0) {
                    max = j + nums[i + j];
                    add = j;
                }
            }
            if (add == 0 && nums[i] == 0) return false;
            i += add == 0 ? nums[i] : add;
        }
        return false;
    }

    // from walkccc.me
    public boolean canJump2(int[] nums) {
        int i = 0;

        for (int reach = 0; i < nums.length && i <= reach; ++i)
            reach = Math.max(reach, i + nums[i]);

        return i == nums.length;
    }

}
