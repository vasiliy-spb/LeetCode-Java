package matrix.workingPeoplesImitation.task_238_Product_of_Array_Except_Self;

public class Solution {
    // my solution
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        int[] prefixSumReverse = new int[n + 1];
        prefixSum[0] = 1;
        prefixSumReverse[n] = 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            prefixSum[i + 1] = prefixSum[i] * nums[i];
            prefixSumReverse[j] = prefixSumReverse[j + 1] * nums[j];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = prefixSum[i] * prefixSumReverse[i + 1];
        }
        return nums;
    }

    // from walkccc.me
    public int[] productExceptSelf2(int[] nums) {
        final int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;

        // Use ans as the prefix product array.
        for (int i = 1; i < n; ++i)
            ans[i] = ans[i - 1] * nums[i - 1];

        int suffix = 1; // suffix product
        for (int i = n - 1; i >= 0; --i) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }

        return ans;
    }

    // from GPT
    public static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;

        // Initialize result array
        int[] result = new int[n];

        // Calculate product of all elements to the left of each element
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Calculate product of all elements to the right of each element and multiply with the left product
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

    // from leetcode solutions
    public int[] productExceptSelf4(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

    // from leetcode solutions (https://leetcode.com/problems/product-of-array-except-self/solutions/135882/a-java-solution-with-an-explanation/?source=submission-ac)
    public int[] productExceptSelf5(int[] nums) {
        // Left is an array containing the left products
        // i.e: left[i] = nums[0] * .... * nums[i-1]  * nums[i]
        int[] left = new int[nums.length];

        // Right is an array containing the array products
        //i.e: right[i] = nums[i] * nums[i+1]  * .... * nums[len(nums)]
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int[] product = new int[nums.length];
        for (int i = 0; i < product.length; i++) {
            product[i] = left[i] * right[i];
        }

        return product;
    }

}
