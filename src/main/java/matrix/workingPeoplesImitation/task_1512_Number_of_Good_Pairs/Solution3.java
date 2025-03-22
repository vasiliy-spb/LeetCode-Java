package matrix.workingPeoplesImitation.task_1512_Number_of_Good_Pairs;

// from leetcode code sample (2)
public class Solution3 {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int[] cnt = new int[101];
        for (int num : nums) {
            count += cnt[num]++;
        }
        return count;
    }
}
