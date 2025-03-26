package matrix.workingPeoplesImitation.task_1980_Find_Unique_Binary_String;

// from leetcode editorial (Approach 4: Cantor's Diagonal Argument)
public class Solution6 {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Character curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0');
        }

        return ans.toString();
    }
}
