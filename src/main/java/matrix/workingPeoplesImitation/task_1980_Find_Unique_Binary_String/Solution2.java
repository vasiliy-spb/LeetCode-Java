package matrix.workingPeoplesImitation.task_1980_Find_Unique_Binary_String;

// from leetcode code sample
public class Solution2 {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            char flippedBit = nums[i].charAt(i) == '0' ? '1' : '0';
            result.append(flippedBit);
        }

        return result.toString();
    }
}
