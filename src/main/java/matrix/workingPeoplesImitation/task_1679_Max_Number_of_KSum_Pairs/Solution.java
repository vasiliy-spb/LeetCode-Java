package matrix.workingPeoplesImitation.task_1679_Max_Number_of_KSum_Pairs;

import java.util.*;

public class Solution {

    // correct
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int left = 0, right = nums.length - 1; left < right; ) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }
        return count;
    }

    public int maxOperations2(int[] nums, int k) {
        Set<Integer> usedIndexes = new HashSet<>();
        int count = 0;
        boolean met = false;
        boolean fullTrack = false;
        for (int left = 0, right = nums.length - 1; left < nums.length || right >= 0; ) {
            if (left == nums.length) {
                if (!fullTrack) {
                    left = 0;
                    fullTrack = true;
                } else {
                    break;
                }
            }
            if (right < 0) {
                if (!fullTrack) {
                    right = nums.length - 1;
                    fullTrack = true;
                } else {
                    break;
                }
            }
            if (!usedIndexes.contains(left) && !usedIndexes.contains(right)) {
                if (left != right) {
                    int sum = nums[left] + nums[right];
                    if (sum == k) {
                        usedIndexes.add(left);
                        usedIndexes.add(right);
                        count++;
                        left++;
                        right--;
                    } else if (sum > k) {
                        if (nums[left] > nums[right]) {
                            left++;
                        } else {
                            right--;
                        }
                    } else {
                        if (nums[left] > nums[right]) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                } else {
                    if (left < nums.length / 2) left++;
                    else right--;
                }
            } else {
                if (usedIndexes.contains(left)) left++;
                if (usedIndexes.contains(right)) right--;
            }
        }
        return count;
    }

    public int maxOperations3(int[] nums, int k) {
        Map<Integer, Integer> pastNumMap = new HashMap<>();
        int count = 0;
        for (int left = 0, right = nums.length - 1; left < right; ) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum > k) {
                if (nums[left] > nums[right]) {
                    if (pastNumMap.containsKey(k - nums[left])) {
                        pastNumMap.put(k - nums[left], pastNumMap.get(k - nums[left]) - 1);
                        if (pastNumMap.get(k - nums[left]) == 0) pastNumMap.remove(k - nums[left]);
                        count++;
                    } else {
                        if (!pastNumMap.containsKey(nums[left])) pastNumMap.put(nums[left], 1);
                    }
                    left++;
                } else {
                    if (pastNumMap.containsKey(k - nums[right])) {
                        pastNumMap.put(k - nums[right], pastNumMap.get(k - nums[right]) - 1);
                        if (pastNumMap.get(k - nums[right]) == 0) pastNumMap.remove(k - nums[right]);
                        count++;
                    } else {
                        if (!pastNumMap.containsKey(nums[right])) pastNumMap.put(nums[right], 1);
                    }
                    right--;
                }
            } else {
                if (nums[left] > nums[right]) {
                    if (pastNumMap.containsKey(k - nums[right])) {
                        pastNumMap.put(k - nums[right], pastNumMap.get(k - nums[right]) - 1);
                        if (pastNumMap.get(k - nums[right]) == 0) pastNumMap.remove(k - nums[right]);
                        count++;
                    } else {
                        if (!pastNumMap.containsKey(nums[right])) pastNumMap.put(nums[right], 1);
                    }
                    right--;
                } else {
                    if (pastNumMap.containsKey(k - nums[left])) {
                        pastNumMap.put(k - nums[left], pastNumMap.get(k - nums[left]) - 1);
                        if (pastNumMap.get(k - nums[left]) == 0) pastNumMap.remove(k - nums[left]);
                        count++;
                    } else {
                        if (!pastNumMap.containsKey(nums[left])) pastNumMap.put(nums[left], 1);
                    }
                    left++;
                }
            }
        }
        return count;
    }

    // correct
    public int maxOperations4(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int num : nums) {
            if (!numsMap.containsKey(num)) numsMap.put(num, 0);
            numsMap.put(num, numsMap.get(num) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : numsMap.entrySet()) {
            if (numsMap.containsKey(k - entry.getKey())) {
                if ((entry.getKey() * 2) == k) {
                    count += entry.getValue() / 2;
                } else {
                    count += Math.min(entry.getValue(), numsMap.get(k - entry.getKey()));
                }
                entry.setValue(0);
            }
        }
        return count;
    }

    // from leetcode Solutions
    public int maxOperations5(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            //to check if that k-nums[i] present and had some value left or already paired
            if (map.containsKey(k - nums[i]) && map.get(k - nums[i]) > 0) {
                count++;
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
            } else {
                //getOrDefault is easy way it directly checks if value is 0 returns 0 where I added 1
                //and if some value is present then it return that value "similar to map.get(i)" and I added 1 on it
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }

    // from leetcode Solutions (with my modification)
    public int maxOperations6(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (map.getOrDefault(k - num, 0) > 0) {
                count++;
                map.put(k - num, map.get(k - num) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}
