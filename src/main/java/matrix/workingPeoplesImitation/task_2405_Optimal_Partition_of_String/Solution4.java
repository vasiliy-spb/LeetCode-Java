package matrix.workingPeoplesImitation.task_2405_Optimal_Partition_of_String;

// from leetcode code sample (2)
public class Solution4 {
    public int partitionString(String s) {
        int ans = 1, mask = 0;
        for (char c : s.toCharArray()) {
            int a = 1 << (c - 'a');
            if ((mask & a) == a) {
                ans++;
                mask = a;
            } else mask |= a;
        }
        return ans;
    }
}
