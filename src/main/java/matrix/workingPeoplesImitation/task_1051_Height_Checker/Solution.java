package matrix.workingPeoplesImitation.task_1051_Height_Checker;

import java.util.Arrays;

public class Solution {

    // my solution
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        for (int i = 0; i < heights.length; i++)
            expected[i] = heights[i];
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++)
            if (heights[i] != expected[i]) count++;
        return count;
    }

    // from walkccc.me
    public int heightChecker2(int[] heights) {
        int ans = 0;
        int currentHeight = 1;
        int[] count = new int[101];

        for (int height : heights)
            ++count[height];

        for (int height : heights) {
            while (count[currentHeight] == 0)
                ++currentHeight;
            if (height != currentHeight)
                ++ans;
            --count[currentHeight];
        }

        return ans;
    }

}
