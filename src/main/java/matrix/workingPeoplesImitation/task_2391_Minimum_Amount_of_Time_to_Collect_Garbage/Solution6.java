package matrix.workingPeoplesImitation.task_2391_Minimum_Amount_of_Time_to_Collect_Garbage;

// from leetcode editorial (Approach 3: Iterate in Reverse)
public class Solution6 {
    public int garbageCollection(String[] garbage, int[] travel) {
        Boolean M = false, P = false, G = false;
        int ans = garbage[0].length();

        for (int i = garbage.length - 1; i > 0; i--) {
            M |= garbage[i].contains("M");
            P |= garbage[i].contains("P");
            G |= garbage[i].contains("G");
            ans += travel[i - 1] * ((M ? 1 : 0) + (P ? 1 : 0) + (G ? 1 : 0)) + garbage[i].length();
        }

        return ans;
    }
}