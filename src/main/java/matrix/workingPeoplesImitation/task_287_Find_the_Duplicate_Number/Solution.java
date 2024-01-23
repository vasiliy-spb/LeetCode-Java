package matrix.workingPeoplesImitation.task_287_Find_the_Duplicate_Number;

public class Solution {

    // my solution
    public int findDuplicate(int[] nums) {
        int[] temp = new int[nums.length + 1];
        for (int i : nums) {
            temp[i]++;
            if (temp[i] > 1) return i;
        }
        return 0;
    }

    // from GPT
    public int findDuplicate2(int[] nums) {
        // Use Floyd's Tortoise and Hare algorithm

        // Phase 1: Detect whether a cycle exists

        // Initialize slow and fast pointers to the first element of the array
        int slow = nums[0];
        int fast = nums[0];

        // Move the pointers until they meet or the fast pointer reaches the end of the array
        do {
            System.out.println("slow = " + slow);
            System.out.println("fast = " + fast);
            slow = nums[slow];          // Move slow one step
            fast = nums[nums[fast]];    // Move fast two steps
        } while (slow != fast);         // Continue until they meet

        System.out.println("slow = " + slow);
        System.out.println("fast = " + fast);
        System.out.println();
        // Phase 2: Find the entrance of the cycle

        // Reset the slow pointer to the beginning
        slow = nums[0];

        // Move both pointers one step at a time until they meet again
        while (slow != fast) {
            System.out.println("slow = " + slow);
            System.out.println("fast = " + fast);
            slow = nums[slow];          // Move slow one step
            fast = nums[fast];          // Move fast one step
        }
        System.out.println("slow = " + slow);
        System.out.println("fast = " + fast);

        // The intersection point is the duplicate number
        return slow;
    }

    // from walkccc.me
    public int findDuplicate3(int[] nums) {
        int slow = nums[nums[0]];
        int fast = nums[nums[nums[0]]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    // from GPT (Approach: using Bit Manipulation)
    public int findDuplicate4(int[] nums) {
        // Length of the array minus 1, as the array contains n + 1 elements
        int n = nums.length - 1;

        // Variable to hold the XOR result
        int result = 0;

        // Step 1: XOR all elements from 1 to n
        for (int i = 1; i <= n; i++) {
            result ^= i; // XOR with the expected range of numbers
        }

        // Step 2: XOR all elements in the array
        for (int num : nums) {
            result ^= num; // XOR with the array elements
        }

        // The final value of 'result' is the duplicate number
        return result;
    }
    // Explanation:
    //
    //    The XOR operation has the property that XOR-ing the same value twice cancels out, resulting in 0. It is also commutative and associative.
    //    By XOR-ing all numbers from 1 to n, the non-duplicate numbers cancel out, leaving only the duplicate number in result.
    //    XOR-ing all elements in the array with result further cancels out the duplicate number, leaving only the XOR of non-duplicate numbers.
    //    The final value of result is the XOR of non-duplicate numbers, and the duplicate number has been effectively canceled out.
    //
    //Example:
    //
    //Let's take the array [1, 3, 4, 2, 2] as an example.
    //
    //    Expected XOR for numbers 1 to 4: 1 ^ 2 ^ 3 ^ 4 (binary representation is 001 ^ 010 ^ 011 ^ 100), which results in 000 (binary representation of 0).
    //    XOR of array elements: 1 ^ 3 ^ 4 ^ 2 ^ 2 (binary representation is 001 ^ 011 ^ 100 ^ 010 ^ 010), which results in 100 (binary representation of 4).
    //    The final result is 000 ^ 100, which is 100 (binary representation of 4).
    //
    //So, the duplicate number in the array is 4, and the algorithm correctly identifies it using bit manipulation.

}
