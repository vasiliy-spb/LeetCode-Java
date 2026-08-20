package matrix.workingPeoplesImitation.task_3069_Distribute_Elements_Into_Two_Arrays_I;

// my solution 1
class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] temp = new int[n];
        int first = 0;
        int second = 0;
        result[first] = nums[0];
        temp[second] = nums[1];
        for (int i = 2; i < n; i++) {
            if (result[first] > temp[second]) {
                result[++first] = nums[i];
            } else {
                temp[++second] = nums[i];
            }
        }
        for (int i = 0; i <= second; i++) {
            result[first + 1 + i] = temp[i];
        }
        return result;
    }
}
