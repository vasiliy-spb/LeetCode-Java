package matrix.workingPeoplesImitation.task_1431_Kids_With_the_Greatest_Number_of_Candies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // my solution
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies)
            maxCandies = Math.max(maxCandies, candy);
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies)
            if (candy + extraCandies >= maxCandies) result.add(true);
            else result.add(false);
        return result;
    }

    // from walkccc.me
    public List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        final int maxCandy = Arrays.stream(candies).max().getAsInt();

        for (final int candy : candies)
            ans.add(candy + extraCandies >= maxCandy);

        return ans;
    }

}
