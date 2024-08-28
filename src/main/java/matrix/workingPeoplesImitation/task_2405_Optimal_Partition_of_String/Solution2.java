package matrix.workingPeoplesImitation.task_2405_Optimal_Partition_of_String;

// from walkccc.me
public class Solution2 {
    public int partitionString(String s) {
        int ans = 1;
        int used = 0;

        for (final char c : s.toCharArray()) {
            final int i = c - 'a';
            if ((used >> i & 1) == 1) {
                used = 1 << i;
                ++ans;
            } else {
                used |= 1 << i;
            }
        }

        return ans;
    }
}
