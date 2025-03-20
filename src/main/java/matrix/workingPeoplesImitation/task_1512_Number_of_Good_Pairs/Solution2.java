package matrix.workingPeoplesImitation.task_1512_Number_of_Good_Pairs;

// from leetcode code sample (1)
public class Solution2 {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101];
        int count = 0;
        for (int num : nums) {
            count += freq[num];
            freq[num]++;
        }
        return count;
    }
}
