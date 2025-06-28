package matrix.workingPeoplesImitation.task_136_Single_Number;

public class Solution {

    // my solution
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }

    // from algo.monster
    public int singleNumber1(int[] nums) {
        // Initialize the variable 'answer' with 0
        int answer = 0;

        // Loop over each value in the array 'nums'
        for (int value : nums) {
            // Apply XOR operation between the 'answer' and the 'value'
            // Since XOR of a number with itself is 0 and with 0 is the number itself,
            // this will cancel out all pairs leaving the single number alone
            answer ^= value;
        }
        // Return the single number that doesn’t have a pair
        return answer;
    }
}
