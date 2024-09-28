package matrix.workingPeoplesImitation.task_179_Largest_Number;

import java.util.Arrays;

// from leetcode code sample (3)
public class Solution11 {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(arr,(a, b)-> (b+a).compareTo(a+b));
        if (arr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s: arr){
            sb.append(s);
        }
        return sb.toString();
    }
}
