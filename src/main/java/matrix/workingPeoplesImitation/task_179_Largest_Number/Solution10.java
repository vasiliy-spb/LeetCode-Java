package matrix.workingPeoplesImitation.task_179_Largest_Number;

import java.util.Arrays;

// from leetcode code sample (2)
public class Solution10 {
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        // sort numsStr
        Arrays.sort(numsStr, (a, b) -> customSort(a, b)); // or: Arrays.sort(numsStr, this::customSort);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numsStr.length; i++) {
            if (numsStr[i].equals("0")) {
                if (!builder.isEmpty() || i == numsStr.length - 1) {
                    builder.append(numsStr[i]);
                }
            } else {
                builder.append(numsStr[i]);
            }
        }
        return builder.toString();
    }

    private int customSort(String a, String b) {
        int shorterLength = Math.min(a.length(), b.length());
        for (int i = 0; i < shorterLength; i++) {
            int digitA = a.charAt(i) - '0';
            int digitB = b.charAt(i) - '0';
            if (digitA > digitB) {
                return -1;
            }
            if (digitA < digitB) {
                return 1;
            }
        }

        if (a.length() == b.length()) {
            return 0;
        }

        return a.length() > shorterLength ? customSort(a.substring(shorterLength), b) : customSort(a, b.substring(shorterLength));
    }
}
