package matrix.workingPeoplesImitation.task_229_Majority_Element_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // my solution
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int count = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) count++;
            else {
                if (count > nums.length / 3) result.add(prev);
                prev = nums[i];
                count = 1;
            }
        }
        if (count > nums.length / 3) result.add(prev);
        return result;
    }

    // from walkccc.me (the Boyer-Moore Majority Vote algorithm)
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int candidate1 = 0;
        int candidate2 = 1;  // any number different from candidate1
        int countSoFar1 = 0; // the number of candidate1 so far
        int countSoFar2 = 0; // the number of candidate2 so far

        for (final int num : nums)
            if (num == candidate1) {
                ++countSoFar1;
            } else if (num == candidate2) {
                ++countSoFar2;
            } else if (countSoFar1 == 0) { // Assign the new candidate.
                candidate1 = num;
                ++countSoFar1;
            } else if (countSoFar2 == 0) { // Assign the new candidate.
                candidate2 = num;
                ++countSoFar2;
            } else { // Meet a new number, so pair with the previous counts.
                --countSoFar1;
                --countSoFar2;
            }

        int count1 = 0;
        int count2 = 0;

        for (final int num : nums)
            if (num == candidate1)
                ++count1;
            else if (num == candidate2)
                ++count2;

        if (count1 > nums.length / 3)
            ans.add(candidate1);
        if (count2 > nums.length / 3)
            ans.add(candidate2);
        return ans;
    }
}






