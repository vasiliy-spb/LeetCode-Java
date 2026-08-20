package matrix.workingPeoplesImitation.task_3069_Distribute_Elements_Into_Two_Arrays_I;

// my solution 2
class Solution2 {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int first = 0;
        int second = n - 1;
        result[first] = nums[0];
        result[second] = nums[1];
        for (int i = 2; i < n; i++) {
            if (result[first] > result[second]) {
                result[++first] = nums[i];
            } else {
                result[--second] = nums[i];
            }
        }
        int left = second;
        int right = n - 1;
        while (left < right) {
            result[left] += result[right];
            result[right] = result[left] - result[right];
            result[left++] -= result[right--];
        }
        return result;
    }
}
