package matrix.workingPeoplesImitation.task_2745_Construct_the_Longest_New_String;

// my solution
public class Solution {
    public int longestString(int x, int y, int z) {
        int minPP = Math.min(x, y);
        int ans = minPP * 4;
        x -= minPP;
        y -= minPP;
        ans += z * 2;
        if (x > 0 || y > 0) {
            ans += 2;
        }
        return ans;
    }
}
