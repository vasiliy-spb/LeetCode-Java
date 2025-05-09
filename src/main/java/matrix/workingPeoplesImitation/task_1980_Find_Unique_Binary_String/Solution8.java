package matrix.workingPeoplesImitation.task_1980_Find_Unique_Binary_String;

// from walkccc.me (Approach 2: Heuristic)
public class Solution8 {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();

        // Flip the i-th bit for each nums[i] so that `ans` is unique.
        for (int i = 0; i < nums.length; ++i)
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');

        return sb.toString();
    }
}
