package matrix.workingPeoplesImitation.task_162_Find_Peak_Element;

public class Solution {

    // my solution
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) return i;
                else continue;
            }
            if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) return i;
                else break;
            }
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
        }
        return -1;
    }

    // from walkccc.me
    public static int findPeakElement2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            final int m = (l + r) / 2;
            if (nums[m] >= nums[m + 1])
                r = m;
            else
                l = m + 1;
        }

        return l;
    }

    // from leetcode solutions (https://leetcode.com/problems/find-peak-element/solutions/1290642/intuition-behind-conditions-complete-explanation-diagram-binary-search/?source=submission-ac)
    public int findPeakElement3(int[] nums) {

        if(nums.length == 1) return 0; // single element

        int n = nums.length;

        // check if 0th/n-1th index is the peak element
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        // search in the remaining array
        int start = 1;
        int end = n-2;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] < nums[mid-1]) end = mid - 1;
            else if(nums[mid] < nums[mid+1]) start = mid + 1;
        }
        return -1; // dummy return statement
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,0,4,5,6,7,8,9};
        int[] arr = {3,4,2,1,2};
        System.out.println(findPeakElement2(arr));
        System.out.println(findPeakElement(arr));
    }
}
