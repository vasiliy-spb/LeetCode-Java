# Solution
## Approach: Two Pointers
### Intuition

The first and third conditions state that every consecutive pair of integers should have opposite signs and the resultant array should begin with a positive integer. Hence, the 0th index shall contain a positive integer, the 1st index shall contain a negative integer, and so on. From these conditions, we can say that all even indices of the result should have positive integers and all odd indices should have negative integers. This suggests we can use two pointers to track the even and odd indices of the resultant array ans.
Let us now consider the second condition, which states that all integers of the same sign should be in the same order as they were in the original array nums. If we were to iterate over nums in order and populate our ans array using the two pointers based on the sign of the current integer, the order of the integers of the same sign would be maintained. Therefore, we can satisfy all the conditions in one pass! Note that since every other index will be odd and every other index will be even, both pointers would increment by 2 rather than 1.

### Algorithm

Let us label the two pointers to track even and odd indices as posIndex and negIndex respectively. These pointers shall be initialized with 0 for posIndex and 1 for negIndex. These indices will traverse the ans array which will be initialized with the same size as nums.
Now, we'll start traversing nums from the 0th index. Recall that traversing nums from the start will ensure that the order is maintained in our ans array. If a positive integer is encountered in nums, we'll set it in `ans[posIndex]`. Since the next positive integer should be placed in posIndex + 2, we'll increment posIndex accordingly. This process will be the same for any negative integer and negIndex. Since it is given that there are equal numbers of positive and negative integers, we don't stand the risk of going out of bounds with either of the two indices.

Let us summarize the algorithm.

1. Initialize n to the size of nums. Initialze ans array of size n.

2. Initialize two integers posIndex and negIndex with 0 and 1 respectively.

3. Traverse nums from the start. Note that 0 won't be in the array according to the constraints.

    * i. If the current integer is positive, set ans[posIndex] equal to it. Increment posIndex by 2.

    * ii. If the current integer is negative, set ans[negIndex] equal to it. Increment negIndex by 2.

4. Once nums is fully traversed, return ans.

[](./1.jpg)
[](./2.jpg)
[](./3.jpg)
[](./4.jpg)
[](./5.jpg)
[](./6.jpg)
[](./7.jpg)

### Implementation

Java
```Java
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Initializing an answer array of size n
        int[] ans = new int[n];

        // Initializing two pointers to track even and 
        // odd indices for positive and negative integers respectively
        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // Placing the positive integer at the 
                // desired index in ans and incrementing posIndex by 2
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                // Placing the negative integer at the 
                // desired index in ans and incrementing negIndex by 2
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;
    }
}
```

JavaScript
```JavaScript
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var rearrangeArray = function(nums) {
    const n = nums.length;

    // Initializing an answer array of size n
    const ans = new Array(n).fill(0);

    // Initializing two pointers to track even and
    // odd indices for positive and negative integers respectively
    let posIndex = 0, negIndex = 1;

    for (let i = 0; i < n; i++) {
        if (nums[i] > 0) {
            // Placing the positive integer at the
            // desired index in ans and incrementing posIndex by 2
            ans[posIndex] = nums[i];
            posIndex += 2;
        } else {
            // Placing the negative integer at the
            // desired index in ans and incrementing negIndex by 2
            ans[negIndex] = nums[i];
            negIndex += 2;
        }
    }

    return ans;
};
```

### Complexity Analysis

Let n be the length of nums

* Time complexity: O(n)
    We traverse nums once and populate ans. Since both these arrays have size n, this results in a time complexity of O(n).
        
* Space complexity: O(n)
    We create an auxiliary array ans of size n.
