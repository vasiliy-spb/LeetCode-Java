package matrix.workingPeoplesImitation.task_525_Contiguous_Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int[] prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i > 0) prefixSum[i] = prefixSum[i - 1] + 1;
                else prefixSum[i] = 1;
            } else {
                if (i > 0) prefixSum[i] = prefixSum[i - 1] - 1;
                else prefixSum[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < prefixSum.length; i++) {
            if (!map.containsKey(prefixSum[i])) map.put(prefixSum[i], i);
            else maxLength = Math.max(i - map.get(prefixSum[i]), maxLength);
        }
        return maxLength;
    }
    public int findMaxLength1(int[] nums) {
        int maxLength = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i] - 1;
            }
            if (prefixSum[i + 1] == 0) {
                maxLength = Math.max(maxLength, (i + 1));
            }
        }
        return maxLength;
    }

    public int findMaxLength2(int[] nums) {
        int maxLength = 0;
        int balance = 0;
        int currentLength = 0;
        for (int num : nums) {
            balance += num == 1 ? 1 : -1;
            currentLength++;
            if (balance == 0) {
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    public int findMaxLength3(int[] nums) {
        int maxLength = 0;
        int onesCount = 0;
        int zerosCount = 0;
        for (int num : nums) {
            if (num == 1) {
                onesCount++;
            } else {
                zerosCount++;
            }
            maxLength = Math.min(onesCount, zerosCount) * 2;
        }
        return maxLength;
    }

    public int findMaxLength0(int[] nums) {
        int maxLength = 0;
        int onesCount = 0;
        int zerosCount = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                onesCount++;
            } else {
                zerosCount++;
            }
            prefixSum[i + 1] = prefixSum[i]; // + ...
            maxLength = Math.min(onesCount, zerosCount) * 2; // ?
        }
        return maxLength;
    }

}
